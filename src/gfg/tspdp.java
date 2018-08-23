package gfg;

import sun.text.resources.cldr.ia.FormatData_ia;

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


    static int budget = 120;

    static int maskmost = 1<<n;

    //当前花费时间下,访问mask个poi的profit
    //
    class node{

    }
//    static double[][]dp = new double[maskmost][budget+1];
    static void init(){
        add();
//        for (int i = 0; i <n ; i++) {
//            dp[cost[0][0]][1<<i] = profit(i);
//
//        }
    }
    //mask = {0001,0010,0100,1000}


    //5 10000 0~4 123
   static int[][] dp;
    static int tsp(int finalmask,int mask,int pos){
        if(mask == finalmask){
            return cost[pos][0];
        }
        if(dp[mask][pos]!=-1){
            return dp[mask][pos];
        }
        int idx =0;
        //111->0,1,2
        int ans = Integer.MAX_VALUE;
        while (((finalmask>>idx)&((2<<29)-1))!=0){

            if(((finalmask>>idx)&1)!=0&&(mask&(1<<idx))==0){
//                idx++;
                int newAns = cost[pos][idx]+tsp(finalmask,mask|(1<<idx),idx);
                ans = Math.min(ans,newAns);
//                if(ans>budget){
//                    return 999999;
//                }
            }
            idx++;
        }
        return dp[mask][pos] = ans;
    }
    private static double getscore(int mask){
//        mask = 5;
        Map<Integer,Double> map = new HashMap<>();
        int idx = 0;
        double score = 0;
//        System.out.println(Integer.toBinaryString(mask));
        while (((mask>>idx)&((2<<29)-1))!=0) {
            if (((mask>> idx) & 1) != 0) {
//                System.out.println("idx"+idx);
                score += profit(idx);
            }
            idx++;
        }
        map.put(mask,score);
        return score;

//        map.put(, )
    }
    private static void findmask(int[] poiIDs) {
        //1000 1,2,3 0~111
        int pownum = 1<<poiIDs.length-1;

            for (int j = 0; j < pownum; j++) {
                int mask = (j<<1)+1;

                dp = new int[mask+1][29];
                for (int i = 0; i <dp.length ; i++) {
                    for (int k = 0; k<dp[0].length ; k++) {
                        dp[i][k]=-1;

                    }

                }
//                System.out.println(tsp(mask, 1, 0));
                //mask = j
//                if(((j>>i)&1)!=0){
                    //当前mask对应的poiID
                int tsp = tsp(mask, 1, 0);
                if(tsp<budget) {
                    System.out.println(tsp);
                    System.out.println(getscore(mask));
                }


            }
    }
//    static double  tsp(int mask,int pos,int budget) {
//        //pos = 28
//
//        if(budget<cost[pos][0])return -1;
////        if(pos == 28)return profit(pos);
//        double minval = 0;
//        for (int i = 1; i < n; i++) {
//            if ((mask & (1 << i)) == 0) {
//                mask |= (1 << i);//11
//                budget -= cost[pos][i];
//                if (budget >= 0) {
//                    double val = profit(i) + tsp(mask, i, budget);
//                    minval = Math.max(val, minval);
//                }
//                budget += cost[pos][i];
//                mask &= ~(1 << i);//01 下一次101
//            }
//        }
//        return dp[mask][pos] = minval;
//    }

//        static List<Integer> bestroute;
//
        static void start(){
            add();
            System.out.println(Arrays.deepToString(cost));

            findmask(poiIDs);
//            System.out.println(tsp(150, 1, 0,profit(0)));


        }
//    static void tsp(int s,int mask){
//        int choosepoint = 1;
//        for (int i = 0; i < n; i++) {
//            int
//
//        }
//
//    }
//
        public static void main(String[] args) {
            long start = System.currentTimeMillis();
            start();
//            System.out.println(Arrays.deepToString(dp));
            long end = System.currentTimeMillis();
            System.out.println("用时"+(end-start));


        }


//        for (int i = 1; i <n ; i++) {
//            for (int j = 0; j <budget ; j++) {
//                if((mask&(1<<i))==0){
//                    mask|=(1<<i);//11
//
//
//                    double v =profit(i) + tsp(mask, budget-=cost[pos][i],i);
//                    mask&=~(1<<j);//01 下一次101
//
//                }
//
//
//
//            }
//
//        }
    }


































//    static double tsp(int budget,int mask,int pos,double score){
//        if(budget<0){
//            return -1;
//        }
//        if(budget==0)return profit(pos);
//        if(dp[budget][mask]!=-1)return dp[budget][mask];
////        double score =profit(0);
//
//            for (int j = 1; j < n; j++) {
//                for (int i = budget; i >=0 ; i--) {
//                //1
//                if((mask&(1<<j))==0&&(i-cost[pos][j]>=0)){
//                    mask|=(1<<j);
////                    int newmask = mask|(1<<j);
//                    score+=Math.max(score,profit(j)+tsp(budget-cost[pos][j],mask,j,score));
//                    mask&=~(1<<j);
//
//                }
//            }
//
//        }
//        return dp[budget][mask]=score;
//
//    }




//}
