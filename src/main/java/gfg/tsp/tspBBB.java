package gfg.tsp;

import java.util.Arrays;
import java.util.stream.Stream;

//PTP profitable tour problem :find a circuit that min cost - profit
//cost as constrain

//OP问题 只要不超过cost最大化profit
public class tspBBB {
    int n;
    int[][] cost = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
    };
    boolean[] marked = new boolean[n];

//    int budget = 200;
//    double[] weight = new double[]{0.9035,0.131809,0.773522,0.47438};
//    double[] popular = new double[]{0.123264,0.0812708,0.627277,0.922849,};
////    static double ita = .5;
//    double profit(int poiID){
//        return ita * popular[poiID] + (1 - ita) * weight[poiID];
//    }
//
//    int getBoundd(int i){
//
//    }
//
//    {
//        int[] path = new int[n + 2];
//
//        Arrays.fill(path,-1);
//        path[0] = 0;
//    }
//    private int getMin(int start){
//        int min = Integer.MIN_VALUE;
//        for (int i = 0; i <n ; i++) {
//            min = Math.min(cost[start][i],min);
//        }
//        return min;
//    }
//    private void tsp(){
//        marked[0] = true;
//    }
//    //dfs
//    int bestP;
//    private void tsp(int level,int start,int curcost,int curP){
//
//        if(curcost+cost[start][0]>budget){
//            return;
//        }
//
//
//
//
//        for (int i = 1; i <n ; i++) {
//            if(marked[i]||curcost+cost[start][i]+cost[i][0]<=budget)continue;
//            marked[i] =true;
//            curP+=profit(i);
//            curcost+=cost[start][i];
//            tsp(level+1,i,curcost,curP);
//            curcost-=cost[start][i];
//            curP-=profit(i);
//            marked[i] = false;
//        }

//    }
}
