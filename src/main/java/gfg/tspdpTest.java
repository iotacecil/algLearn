package gfg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

public class tspdpTest {
    static Logger logger = Logger.getLogger("main.java.gfg.Logger");
    static int[][] cost;
    static int n = 10;

    static  Random rnd = new Random(1024);

    static int[] poiIDs;
    static double[] weight;
    static double[] popular;
    static int start = 0;
    static int budget = 120;
    static double ita =.5;

    static public void init(){
        cost = new int[n][n];
        poiIDs = new int[n];
        weight = new double[n];
        popular = new double[n];

        for (int i = 0; i <n ; i++) {
            poiIDs[i] = i;
            for (int j = 0; j <n ; j++) {
                if(i==j){
                    cost[i][j] = rnd.nextInt(30)+10;
                    continue;
                }
                cost[i][j] = rnd.nextInt(50)+5;
            }
            weight[i] = rnd.nextDouble();
            popular[i] = rnd.nextDouble();

        }
        logger.info("完成随机初始化");


    }
    static double profit(int poiID){
        return ita * popular[poiID] + (1 - ita) * weight[poiID];
    }



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
        double outsocre = 0;
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
                outsocre = Math.max(outsocre,getscore(mask) );
                System.out.println(tsp);
                System.out.println(getscore(mask));
            }


        }
        System.out.println("实验结果"+outsocre);
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
//        add();
        init();
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
//        System.out.println(Arrays.deepToString(dp));
        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-start));


    }

}
