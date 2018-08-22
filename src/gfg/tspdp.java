package gfg;

import java.util.*;

public class tspdp {

    static int[][] cost = {
            { 0, 10, 15, 20,40 },
            { 10, 0, 35, 25,20 },
            { 15, 35, 0, 30,25 },
            { 20, 25, 30, 0,45 },
            { 30, 10, 15, 20,0 }};
    static int[] visited = {30,50,20,10,5};
    private static void add(){
        for (int i = 0; i <cost.length ; i++) {
            for (int j = 0; j <cost[0].length ; j++) {
                cost[i][j]+=visited[j];

            }
        }
    }
    static double[] popular = {.4,.2,.3,.1,.3};
    static double[] weight = {.2,.2,.3,.3,.5};


    static int[] poiIDs= {0,1,2,3,4};


    static int n = 5;
    static double ita = .5;
    static double profit(int poiID){
        return ita * popular[poiID] + (1 - ita) * weight[poiID];
    }

    static int start = 0;


    static int budget = 150;

    static int maskmost = 1<<n;
    //当前花费时间下,访问mask个poi的profit
    //
    static double[][]dp = new double[budget+1][maskmost];
    static double tsp(int budget,int mask,int pos,double score){
        if(budget<0){
            return -1;
        }
        if(budget==0)return profit(pos);
        if(dp[budget][mask]!=-1)return dp[budget][mask];
//        double score =profit(0);

            for (int j = 1; j < n; j++) {
                for (int i = budget; i >=0 ; i--) {
                //1
                if((mask&(1<<j))==0&&(i-cost[pos][j]>=0)){
                    mask|=(1<<j);
//                    int newmask = mask|(1<<j);
                    score+=Math.max(score,profit(j)+tsp(budget-cost[pos][j],mask,j,score));
                    mask&=~(1<<j);

                }
            }

        }
        return dp[budget][mask]=score;

    }



    static List<Integer> bestroute;

    static void start(){
        add();
        System.out.println(Arrays.deepToString(cost));
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                dp[i][j]=-1;

            }

        }
        System.out.println(tsp(150, 1, 0,profit(0)));


    }
//    static void tsp(int s,int mask){
//        int choosepoint = 1;
//        for (int i = 0; i < n; i++) {
//            int
//
//        }
//
//    }

    public static void main(String[] args) {
        start();




    }
}
