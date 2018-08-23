package gfg;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class tspdpLearn {
    int budget = 200;
   public void init(int n){
       citynumbers = n;
      Random rnd = new Random(1024);
       distance = new int[n][n];
//       visited =new int[n];
       popular = new double[n];
       weight = new double[n];


        for (int i = 0; i <n ; i++) {

            for (int j = 0; j <n ; j++) {
                if(i==j){
                    distance[i][j] = rnd.nextInt(30)+20;
                    continue;
                }
                distance[i][j] = rnd.nextInt(50)+50;
            }
            weight[i] = rnd.nextDouble();

            popular[i] = rnd.nextDouble();
        }

       optimalvalue =new double[citynumbers][1<<(citynumbers-1)];
       optimalchoice=new int[citynumbers][1<<(citynumbers-1)];
       geneScore();
       System.out.println(Arrays.deepToString(distance));
       System.out.println(Arrays.toString(popular));
       System.out.println(Arrays.toString(weight));
       System.out.println("以上是输入");
    }
    private void smallcase(){
        citynumbers=5;

        int[][] cost= {
                { 0, 10, 15, 20,40 },
                { 10, 0, 35, 25,20 },
                { 15, 35, 0, 30,25 },
                { 20, 25, 30, 0,45 },
                { 30, 10, 15, 20,0 }};


        distance = cost;
        optimalvalue =new double[citynumbers][1<<(citynumbers-1)];
        optimalchoice=new int[citynumbers][1<<(citynumbers-1)];
        visited =new int[] {30,50,20,10,5};
        popular =new double[] {.4,.2,.3,.1,.3};
        weight = new double[]{.2,.2,.3,.3,.5};
        add();
        geneScore();
        System.out.println(Arrays.deepToString(distance));
        System.out.println(Arrays.toString(popular));
        System.out.println(Arrays.toString(weight));
        System.out.println("以上是输入");
        dpscore = new double[citynumbers+1][budget+1];
    }
    double[] maskscore;

    private void geneScore(){
        maskscore= new double[1<<(citynumbers-1)];
        for (int i = 0; i <1<<(citynumbers-1) ; i++) {
            double socre0 = profit(0);;
            for(int k =0;k<citynumbers-1;k++)
            {
                if((i&(1<<(k)))!=0){
                    socre0+=profit(k+1);
                }
            }
            maskscore[i] = socre0;

        }
//        System.out.println(Arrays.toString(maskscore));
    }
    private double getscore(int mask){
        return maskscore[mask];

    }
    private static void add(){
        for (int i = 0; i <distance.length ; i++) {
            for (int j = 0; j <distance[0].length ; j++) {
                distance[i][j]+=visited[j];

            }
        }
    }

    static int[][] distance;
    static int[] visited;

        private int citynumbers;//城市数目
        double s=0;//总距离
        int path[];//存放路径，方便计算距离
        private double[][] optimalvalue;//阶段最短路径值矩阵
        private int[][] optimalchoice;//阶段最优策略矩阵
        private HashMap<Integer,Double> scores = new HashMap<>();
        private int[][] optback;
    static double[] popular;
    static double[] weight ;
    static double[][] dpscore;
    static double ita = .5;
    double profit(int poiID){
        return ita * popular[poiID] + (1 - ita) * weight[poiID];
    }
        public void solve() {
            double min=Double.MAX_VALUE;//确保会更新
            double score=0;//确保会更新
            int mink=0;
            //计算第一列地值
            for(int i=0;i<citynumbers;i++) {
                optimalvalue[i][0]=distance[i][0];
            }
            for(int i=1;i<(1<<(citynumbers-1));i++) {
                for(int j=1;j<citynumbers;j++) {
                    if(((i>>(j-1))&1)==0) {//确定j不包含在i代表的集合中
                        int idx = 0;
                        //运行时间970
                        while (((i>>idx)&((2<<citynumbers)-1))!=0){
                            if(((i>>idx)&1)!=0) {
                                double y=(distance[j][idx+1]+optimalvalue[idx+1][(i-(1<<idx))]);
                                if(y<min&&y<budget) {

                                        min = (distance[j][idx + 1] + optimalvalue[idx + 1][(i - (1 << idx))]);
                                        mink = idx + 1;
                                }
                            }
                            idx++;
                        }
                            optimalvalue[j][i]=min;
                            optimalchoice[j][i]=mink;
                            min=Double.MAX_VALUE;
//                        }
                    }
                }
            }
            System.out.println("得分 最短路径");
            System.out.println(score+ " " +min+" "+mink);
            score = 0;
            min=Double.MAX_VALUE;//更新min
//            int i=(int)(Math.pow(2, citynumbers-1)-1);//更新最后一列
            //扫描当前mask下

            int i=((1<<(citynumbers-1))-1);//更新最后一列
            int minmask = i;

            for (int mask = i; mask >0 ; mask--) {
            for(int k=citynumbers-2;k>=0;k--) {
                System.out.println(Integer.toBinaryString(mask - (1 << (k))));
                System.out.println(Integer.toBinaryString(k + 1));
                if((mask&(1<<k))!=0&&optimalvalue[k + 1][(mask - (1 << (k)))]<=budget) {
                    double x = (distance[0][k + 1] + optimalvalue[k + 1][ (mask - (1 << (k)))]);
                    if (x<=budget) {
                            min = x;
                            mink = k + 1;
                            minmask = mask;
                    }

                }
            }
            }
            optimalvalue[0][minmask]=min;
            System.out.println(mink);
            System.out.println("score"+score+" cost : "+min+ "k+1: "+mink +" minmask: "+Integer.toBinaryString(minmask));
            optimalchoice[0][minmask]=mink;

            path=new int[citynumbers+1];
            path[0]=0;
            int c=1;

            for(int mask =minmask;mask>0;) {
                int j=optimalchoice[0][mask];
                System.out.println(j);

                mask=mask-(1<<(j-1));
//
                path[c++]=j+1;

            }
            path[c++]=0;
            System.out.println(Arrays.toString(path));

        }



        public static void main(String[] args) throws IOException{
            long a=System.currentTimeMillis();
            tspdpLearn tsp=new tspdpLearn();//建立对象，根据需要初始化10,25或100
//            tsp.init(11);
            tsp.smallcase();


            tsp.solve();
            long b=System.currentTimeMillis();
            long c=b-a;
            System.out.println("运行时间为:"+c);//输出运行时间
        }


}
