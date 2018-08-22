package gfg;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

public class tspbruteTest {
    static Logger logger = Logger.getLogger("gfg.Logger");
    static int[][] cost;
    static int n = 11;
    static  Random rnd = new Random();
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

    //start =0 生成1,2,3->[[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
    //复杂度2^n
    private static List<List<Integer>> subpermutation(){
        List<List<Integer>> rst = new ArrayList<>();
        back(rst,new ArrayList<>(),1);
        logger.info("完成生成subset");
        return rst;
    }
    private static void back(List<List<Integer>> rst,List<Integer> item,int idx){
        if(idx==poiIDs.length){
            rst.add(new ArrayList<>(item));
            return;
        }
        for (int i = idx; i <poiIDs.length ; i++) {
            item.add(poiIDs[i]);
            back(rst,item,i+1);
            item.remove(item.size()-1);
        }
    }
    static double profit(int poiID){
        return ita * popular[poiID] + (1 - ita) * weight[poiID];
    }
    static HashMap<List<Integer>,Double> subrouteScore(List<List<Integer>> sub){
        HashMap<List<Integer>,Double> route2score = new HashMap<List<Integer>, Double>();
        for(List<Integer> route:sub){
            double score = profit(0);
            for(int poiID:route){
                score+=profit(poiID);
            }
            route2score.put(route,score);
        }
        return route2score;
    }
    //复杂度n!
    static List<List<Integer>> permutation(List<Integer> route){

        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int n : route) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<Integer>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        logger.info("完成"+route+"permutation");
        return res;

    }
    static List<Integer> bestroute;

    static int beforeTimelimit(List<List<Integer>> routes) {
        int min_path = Integer.MAX_VALUE;
        bestroute = routes.get(0);
        for (List<Integer> route : routes) {
            int curcost = 0;
            int k = start;
            for (int i = 0; i < route.size(); i++) {
                curcost += cost[k][route.get(i)];
                k = route.get(i);
            }
            curcost += cost[k][start];
            if(curcost>budget)return 9999999;
            if (min_path > curcost) {
                min_path = curcost;
                bestroute = route;
            }

        }
        logger.info("完成"+routes.get(0)+"的所有排序的最短路径");
        return min_path;
    }
    static void start(){

        System.out.println(Arrays.deepToString(cost));
        List<List<Integer>> subpermutation = subpermutation();
        HashMap<List<Integer>, Double> score = subrouteScore(subpermutation);
        double bestScore = 0;

        for(List<Integer> subroute:subpermutation){
            List<List<Integer>> permutation = permutation(subroute);
            bestroute= new ArrayList<>();
            int bestCost = beforeTimelimit(permutation);
            if (bestCost<=budget) {
                if(score.get(subroute)>bestScore){
                    bestScore = score.get(subroute);
                }
                System.out.println("----------");
                System.out.println("少于120分钟的点集 兴趣评分是");
                System.out.println(subroute+" "+score.get(subroute));
                System.out.println("最短路线是");
                System.out.println(bestroute+" "+bestCost);
                System.out.println("----------");

            }


        }
    }
    public static void main(String[] args) {
        init();
        start();
    }
}
