package niuke;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.ForkJoinTask;

public class taotaoeat {
   static   class good{
        int w;
        int v;

        public good(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public String toString() {
            return "good{" +
                    "w=" + w +
                    ", v=" + v +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {

       StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int)in.nval;
            if (n == 0) break;
            good[] goods = new good[n];
            in.nextToken();
            int m = (int)in.nval;
            in.nextToken();
            int h = (int)in.nval;
//            int[] w = new int[n];
//            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                int w= (int)in.nval;
                in.nextToken();
                int v =(int)in.nval;
                goods[i] = new good(w,v);

            }
            int[] dp = new int[m+h+1];
            //先装重量大的
          Arrays.sort(goods,(g1,g2)->g2.w-g1.w);
            System.out.println(Arrays.toString(goods));
            for (int i = 0; i <n ; i++) {
                //把免费的添加到每个背包里
                if(goods[i].w==0){
                    for (int j = m+h; j >=0; j--) {
                        dp[j]+=goods[i].v;
                    }
                    continue;
                }
                for(int j = m+h;j>=goods[i].w;j--){

                    dp[j] = Math.max(dp[j],dp[j-goods[i].w]+goods[i].v);//i=2 开始装w=2,v=3
                    System.out.println("为什么这个只加了2,j=:"+j);
                    System.out.println(Arrays.toString(dp));//i=2 j=2装w=2,v=3之后取dp[0]不装的值更新

                }
                System.out.println("结束了");//容量>=3的背包里都放了goods[1]
                if(h>0){
                    for (int j = Math.min(m+h,goods[i].w-1); j >0 ; j--) {//这个物品装不下的第一个 容量2的
                        System.out.println("m+h>w-1 : "+" 这是第"+i+"个物品"+(m+h)+(goods[i].w-1));
                        System.out.println("强行装j:"+j);
                        dp[j] = Math.max(dp[j],dp[0]+goods[i].v);//强行在[2]背包里放入容量3的物品//强行在[1]里装容量2的
                        System.out.println(Arrays.toString(dp));

                    }
                }
            }
            out.println(dp[m+h]);
            out.flush();



            /*
            方法1.然而0%
             */
//            m+=h;
//            int[][] dp =  new int[m+h+1][2];
//            for (int i = 0; i <n ; i++) {
//                for (int j = m; j >0 ; j--) {
//                    if(j>=w[i]){
//                        dp[j][0] = Math.max(dp[j][0], dp[j - w[i]][0] + v[i]);
//                        dp[j][0] = Math.max(dp[j][1], dp[j - w[i]][1] + v[i]);
//
//                    }
//                    dp[j][1] =Math.max(dp[j-1][0]+v[i],dp[j][1]);
//                }
//
//            }
//            if(h!=0)out.println(Math.max(dp[m][0],dp[m][1]));
//            else out.println(dp[m][0]);
//
//            out.flush();
            /*
            方法2：80%
             */
            //人物可装
//            if (h == 0) {
//                int[] dp = new int[m + 1];
//                for (int i = 0; i < m; i++) {
//                    for (int j = m + h; j >= w[i]; j--) {
//                        dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
////                        System.out.println(Arrays.toString(dp));
//
//                    }
//                }
//                out.println(dp[m]);
//            } else {
//                //当装备了背包之后，
//                //如果背包没有满，就可以拿一个任意重量的物品
//                int max = 0;
//                for (int k = 0; k <n ; k++) {
//                    int dp[] = new int[m+h+1];
//                    for (int i = 0; i < n; i++) {
//                        if(i==k)continue;
//                        for (int j = m+h; j >=w[i] ; j--) {
//                            dp[j] = Math.max(dp[j],dp[j-w[i]]+v[i]);
//                        }
//                    }
//                    //装满了怎么办？
//                    max = Math.max(max,dp[m+h-1]+v[k]);
//
//                }
//
//                out.println(max);
//            }
//            out.flush();

        }

    }
}
