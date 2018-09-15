package gfg.tsp;

import java.util.*;

/** random cost
 * 用于测试暴力最多能几个点
 */
public class tspbruteTest {
    //    static Logger logger = Logger.getLogger("main.java.gfg.Logger");
    static int[][] cost;
    static int n = 11;
    static  Random rnd = new Random(1024);
    static int[] poiIDs;
    static double[] weight;
    static double[] popular;
    static int start = 0;
    static int budget = 200;
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
                    cost[i][j] = rnd.nextInt(30)+20;
                    continue;
                }
                cost[i][j] = rnd.nextInt(50)+50;
            }
            weight[i] = rnd.nextDouble();
            popular[i] = rnd.nextDouble();

        }
//        logger.info("完成随机初始化");


    }

    //start =0 生成1,2,3->[[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
    //复杂度2^n
    public static List<List<Integer>> subpermutation() {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());


        for(int i : poiIDs) {
            if(i == 0 )continue;
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        res.remove(0);
//        logger.info("完成生成subset");
        return res;
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
//        logger.info("完成"+route+"permutation");
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
            if(curcost>budget)continue;
            if (min_path > curcost) {
                min_path = curcost;
                bestroute = route;
            }

        }
//        logger.info("完成"+routes.get(0)+"的所有排序的最短路径");
        return min_path;
    }
    private static void testroute(){
        List<Integer> route = new ArrayList<>();
        route.add(9);
        route.add(3 );
        int curcost = 0;
        int k = 0;
        for (int i = 0; i <route.size() ; i++) {
            System.out.println(cost[k][route.get(i)]);
            curcost+=cost[k][route.get(i)];
            k = route.get(i);
        }
        curcost+=cost[k][0];

        System.out.println(curcost);

    }
    static void start(){

        System.out.println(Arrays.deepToString(cost));
        System.out.println(Arrays.toString(popular));
        System.out.println(Arrays.toString(weight));
        System.out.println("以上是输入");
        List<List<Integer>> subpermutation = subpermutation();

        System.out.println(subpermutation);
        HashMap<List<Integer>, Double> score = subrouteScore(subpermutation);
//        System.out.println(score);
        double bestScore = 0;
        int outcost = Integer.MAX_VALUE;
        List<Integer> outRoute = new ArrayList<>();
        for(List<Integer> subroute:subpermutation){
            List<List<Integer>> permutation = permutation(subroute);
            bestroute= new ArrayList<>();
            int bestCost = beforeTimelimit(permutation);
            if (bestCost<=budget) {
                if(score.get(subroute)>bestScore){
                    bestScore = score.get(subroute);
                    outcost = bestCost;
                    outRoute = bestroute;
                }
                System.out.println("----------");
                System.out.println("少于"+budget+"分钟的点集 兴趣评分是");
                System.out.println(subroute+" "+score.get(subroute));
                System.out.println("最短路线是");
                System.out.println(bestroute+" "+bestCost);
                System.out.println("----------");


            }
        }
        System.out.println("实验结果"+outRoute+" "+bestScore+" 花费 "+outcost);
    }
    public static void main(String[] args) {
        init();
        start();
//        testroute();
//        List<Integer> route = new ArrayList<>();
//        route.add(9);
//        route.add(3 );
//        System.out.println(beforeTimelimit(permutation(route)));
    }
}
