package gfg;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * 采用自底向上的填 表的动态规划方法求解TSP问题
 * distance是距离矩阵，optimalvalue存放阶段最短路径
 * optimalchoice存放阶段最优策略，方便回溯找到最短路径
 */
public class tspdpLearn {
   public void init(int n){
       citynumbers = n;
      Random rnd = new Random(1024);
       distance = new int[n][n];


        for (int i = 0; i <n ; i++) {

            for (int j = 0; j <n ; j++) {
                if(i==j){
                    distance[i][j] = rnd.nextInt(30)+10;
                    continue;
                }
                distance[i][j] = rnd.nextInt(50)+5;
            }


        }

       optimalvalue =new double[citynumbers][1<<(citynumbers-1)];
       optimalchoice=new int[citynumbers][1<<(citynumbers-1)];

    }
    static int[][] distance;
//            {
//            { 0, 10, 15, 20 },
//            { 10, 0, 35, 25 },
//            { 15, 35, 0, 30 },
//            { 20, 25, 30, 0 }};

        private int citynumbers;//城市数目
        double s=0;//总距离
        int path[];//存放路径，方便计算距离
//        private double[][] distance;
        private double[][] optimalvalue;//阶段最短路径值矩阵
        private int[][] optimalchoice;//阶段最优策略矩阵


        public void solve() {
            double min=Double.MAX_VALUE;//确保会更新
            int mink=0;
            //计算第一列地值
            for(int i=0;i<citynumbers;i++) {
                optimalvalue[i][0]=distance[i][0];
            }
            for(int i=1;i<(1<<(citynumbers-1));i++) {
                for(int j=1;j<citynumbers;j++) {
                    int k=0;
                    //(1<<j)&i)!=1 反而变慢了
                    //(j>>i)&1
                    if(((i>>(j-1))&1)==0) {//确定j不包含在i代表的集合中
                        String a=tspdpLearn.binary(i,citynumbers-1);
                        int idx = 0;
                        while (((i>>idx)&((2<<citynumbers)-1))!=0){
                            if(((i>>idx)&1)!=0){
                                System.out.println(idx+1);
                            }
                            idx++;
                        }
                        for(int w=a.length();w>0;w-- ) {
                            k=a.charAt(a.length()-w)-48;//k为0或者1
                            if(k==1) {
                                k=k*w;//此时的k为选择的集合中的某个值
//                                System.out.println(a+" "+w);
                                double y=(distance[j][k]+optimalvalue[k][(int)(i-(1<<(k-1)))]);
                                if(y<min) {
                                    min=(distance[j][k]+optimalvalue[k][(int)(i-(1<<(k-1)))]);
                                    mink=k;
                                }
                            }
                        }
                        if(min<Double.MAX_VALUE) {//确定min是否变化，有变化再写入矩阵
                            optimalvalue[j][i]=min;
                            optimalchoice[j][i]=mink;
                            min=Double.MAX_VALUE;
                        }
                    }
                }
            }
            min=Double.MAX_VALUE;//更新min
            int i=(int)(Math.pow(2, citynumbers-1)-1);//更新最后一列
            for(int k=citynumbers-1;k>0;k--) {
                double x=(distance[0][k]+optimalvalue[k][(int)(i-Math.pow(2, k-1))]);
                if(x<min) {
                    min=x;
                    mink=k;
                }
            }
            optimalvalue[0][i]=min;
            optimalchoice[0][i]=mink;
            path=new int[citynumbers+1];
            path[0]=1;
            int c=1;
            for(int j=0;i>0;) {
                j=optimalchoice[j][i];
                i=(int)(i-Math.pow(2, j-1));
                path[c++]=j+1;
            }
            path[c++]=1;
            for(i=0;i<citynumbers;i++) {
                System.out.print(path[i]+" ");
                s=s+distance[path[i]-1][path[i+1]-1];
            }
            System.out.println(1+" ");
            System.out.println(s);
        }

        //判断j是否在i表示的集合中
//        public boolean judge2(int i,int j){
//
//        }
//        public int judge(int i,int j) {
////            System.out.println("掩码 "+Integer.toBinaryString(i));
////            System.out.println(j+" "+Integer.toBinaryString(j));
//            String a=tspdpLearn.binary(i,citynumbers-1);
////            System.out.println("转二进制"+a);
//
//
//            int b=a.charAt(a.length()-j)-'0';
////            System.out.println("取第"+(a.length()-j)+"位"+a);
//
//            if(b!=((i >> (j-1)) & 1)){
//                System.out.println("b "+ b);
//                System.out.println((i >> (j-1)) & 1);
//                System.out.println(Integer.toBinaryString(i>>(j-1)));
//                System.out.println("取第"+(a.length()-j)+"位"+a);
//            }
//
//            return b;
//        }

        //给定一个十进制数，输出一个指定位数的二进制形式字符串
        public static String binary(int decNum ,int digit) {
            String binStr = "";
            for(int i=digit-1;i>=0;i--) {
                binStr +=(decNum>>i)&1;
            }
//            System.out.println(binStr);
            return binStr;
        }

        public static void main(String[] args) throws IOException{
            long a=System.currentTimeMillis();
            tspdpLearn tsp=new tspdpLearn();//建立对象，根据需要初始化10,25或100
            tsp.init(4);
            tsp.solve();
            long b=System.currentTimeMillis();
            long c=b-a;
            System.out.println("运行时间为:"+c);//输出运行时间
        }


}
