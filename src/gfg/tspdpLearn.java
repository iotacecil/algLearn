package gfg;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
480分钟 最多24个点,运行时间为:12592 所有点3000budget 用时14614
 */
public class tspdpLearn {
    int budget =480 ;
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
//       System.out.println(Arrays.deepToString(distance));
//       System.out.println(Arrays.toString(popular));
//       System.out.println(Arrays.toString(weight));
//       System.out.println("以上是输入");
    }
    private void smallcase(){
        citynumbers=5;

        int[][] cost= {
                {0,50,98,59,86,68,84,79,80,68},
            {77,0,71,67,84,81,87,76,85,72},
            {90,83,0,90,91,89,50,92,63,61},
            {95,85,54,0,68,66,75,85,81,80},
            {100,90,84,81,0,77,58,73,84,72},
            {84,50,64,96,67,0,69,76,70,92},
            {65,54,75,81,62,72,0,55,59,71},
            {85,57,52,99,57,86,63,0,81,93},
            {65,65,57,60,93,94,52,96,0,53},
            {65,62,58,64,90,54,77,91,55,0},
//                { 0, 10, 15, 20,40 },
//                { 10, 0, 35, 25,20 },
//                { 15, 35, 0, 30,25 },
//                { 20, 25, 30, 0,45 },
//                { 30, 10, 15, 20,0 }
        };


        distance = cost;
        optimalvalue =new double[citynumbers][1<<(citynumbers-1)];
        optimalchoice=new int[citynumbers][1<<(citynumbers-1)];
       visited = new int[]{36,21,33,48,45,48,39,37,25,43,};
     popular = new double[]{0.123264,0.0812708,0.627277,0.922849,0.834773,0.51677,0.812952,0.327586,0.504624,0.560625,};
     weight = new double[]{0.9035,0.131809,0.773522,0.47438,0.178228,0.757622,0.17774,0.662343,0.830317,0.271706,};

//        popular =new double[] {.411212,.232132,.233234,.12342,.343434};
//        weight = new double[]{.275678,.267567,.365486,.368870,.5353};
//        visited =new int[] {30,50,20,10,5};
//        popular =new double[] {.411212,.232132,.233234,.12342,.343434};
//        weight = new double[]{.275678,.267567,.365486,.368870,.5353};
        add();
        geneScore();
//        System.out.println(Arrays.deepToString(distance));
//        System.out.println(Arrays.toString(popular));
//        System.out.println(Arrays.toString(weight));
//        System.out.println("以上是输入");
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
                //别的地方回到0不要visit
                if(j==0&&i!=0)continue;
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
            double min=budget;//确保会更新
//            double score=0;//确保会更新
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
                                //[0, 11, 13, 21, 10, 1, 12, 9, 23, 2, 18, 15, 16, 20, 8, 3, 14, 7, 19, 4, 22, 5, 6, 17, 0]
                                //运行时间为:14686
//                                if(optimalvalue[idx+1][(i-(1<<idx))]==budget){
//                                  continue;
//                                }
                                double y=(distance[j][idx+1]+optimalvalue[idx+1][(i-(1<<idx))]);
                                if(y<min) {

                                        min = (distance[j][idx + 1] + optimalvalue[idx + 1][(i - (1 << idx))]);
                                        mink = idx + 1;
                                }
                            }
                            idx++;
                        }

//                            if(min<budget){
                            optimalvalue[j][i]=min;
                            optimalchoice[j][i]=mink;
                            min=budget;
//                        }else{
//
//                            }
                    }
                }
            }
//            System.out.println("完成dp构建");
//            for (int i = 0; i <citynumbers ; i++) {
//                System.out.print (optimalvalue[i][1023]+" ");
//
//            }
            double score = 0;
            min=budget;//更新min
//            int i=(int)(Math.pow(2, citynumbers-1)-1);//更新最后一列
            //扫描当前mask下

            int i=((1<<(citynumbers-1))-1);//更新最后一列
            int minmask = i;
            double outscore = 0;
            for (int mask = i; mask >0 ; mask--) {
            for(int k=citynumbers-1;k>0;k--) {
                if((mask&(1<<(k-1)))!=0&&optimalvalue[k][(mask - (1 << (k-1)))]<=budget) {
                    int curmask = mask;
                    double curscore = getscore(curmask);

                    double x = (distance[0][k] + optimalvalue[k][ (mask - (1 << (k-1)))]);
                    if (curscore>=outscore&&x<=budget) {
                        if(curscore==outscore&&x>min)continue;
                            min = x;
                            mink = k;
                            minmask = mask;
                            outscore = curscore;
                    }

                }
            }
            }
            optimalvalue[0][minmask]=min;
//            System.out.println(mink);
            optimalchoice[0][minmask]=mink;
//            System.out.println("score"+outscore+" cost : "+min+ "k+1: "+mink +" minmask: "+Integer.toBinaryString(minmask));


            path=new int[citynumbers+1];
            path[0]=0;
            int c=1;

            for(int j =optimalchoice[0][minmask], mask =minmask;mask>0;) {
                path[c++]=j;
                mask=mask-(1<<(j-1));
                j=optimalchoice[j][mask];
            }
            path[c++]=0;
//            int swap = 1;
//            int last = c-2;
//            while (swap<last){
//                int tmp = path[last];
//                path[last] = path[swap];
//                path[swap] = tmp;
//                swap++;
//                last--;
//            }

            System.out.println(Arrays.toString(path));
//            System.out.println("score"+outscore+" cost : "+min+ " k: "+mink +" minmask: "+Integer.toBinaryString(minmask));
//            int cccc=0;
//            for (int j = 0; j <c-1 ; j++) {
//                System.out.print(distance[j][path[j+1]]+"+");
//                cccc+=distance[path[j]][path[j+1]];
//
//            }
//            System.out.println("="+cccc);
//            System.out.println(distance[9][3]);

        }



        public static void main(String[] args) throws IOException{
            long a=System.currentTimeMillis();
            long start = System.nanoTime();
            tspdpLearn tsp=new tspdpLearn();//建立对象，根据需要初始化10,25或100
            tsp.init(24);
//            tsp.smallcase();


            tsp.solve();
            long end = System.nanoTime();
            long b=System.currentTimeMillis();
            long c=b-a;
            System.out.println("运行时间为:"+c);//输出运行时间
            System.out.println("运行时间为:"+(end-start));//输出运行时间
        }


}
