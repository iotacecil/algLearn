//package gfg.tsp;
//
//import java.util.*;
//
//public class tspbrute {
//
//    static int[][] cost = {
////            { 0, 10, 15, 20,40 },
////            { 10, 0, 35, 25,20 },
////            { 15, 35, 0, 30,25 },
////            { 20, 25, 30, 0,45 },
////            { 30, 10, 15, 20,0 }
//            {0,50,98,59,86,68,84,79,80,68},
//            {77,0,71,67,84,81,87,76,85,72},
//            {90,83,0,90,91,89,50,92,63,61},
//            {95,85,54,0,68,66,75,85,81,80},
//            {100,90,84,81,0,77,58,73,84,72},
//            {84,50,64,96,67,0,69,76,70,92},
//            {65,54,75,81,62,72,0,55,59,71},
//            {85,57,52,99,57,86,63,0,81,93},
//            {65,65,57,60,93,94,52,96,0,53},
//            {65,62,58,64,90,54,77,91,55,0},
//    };
//
////    static int[] visited ={36,54,41,33,20,55,};
//    static int[] visited =new int[]{36,21,33,48,45,48,39,37,25,43,};
//    static int budget = 3000;
//
////    static int[] visited =new int[] {30,50,20,10,5};
////    static double[] popular =new double[] {.411212,.232132,.233234,.12342,.343434};
//    static double[] popular =new double[] {0.9035,0.131809,0.773522,0.47438,0.178228,0.757622,0.17774,0.662343,0.830317,0.271706,};
//    static double[] weight = new double[]{0.123264,0.0812708,0.627277,0.922849,0.834773,0.51677,0.812952,0.327586,0.504624,0.560625,};
////    static double[] weight = new double[]{.275678,.267567,.365486,.368870,.5353};
//    private static void add(){
//
//        for (int i = 0; i <cost.length ; i++) {
//            for (int j = 0; j <cost[0].length ; j++) {
//                if(j==0&&i!=0)continue;
//
//                cost[i][j]+=visited[j];
//
//            }
//        }
//    }
////    static double[] popular ={36,54,41,33,20,55,};
////    static double[] weight = {0.9035,0.556566,0.301431,0.773522,0.58095,0.730522,};
//
//
//    /** 用poiID生成subset
//     * poiIDs= {0,1,2,3,4,5,6,7,8,9}; ->
//     * @return [[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]...]
//     */
//    public static List<List<Integer>> subset4permu() {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<Integer>());
//
//
//        for(int i : poiIDs) {
//            if(i == 0 )continue;
//            List<List<Integer>> tmp = new ArrayList<>();
//            for(List<Integer> sub : res) {
//                List<Integer> a = new ArrayList<>(sub);
//                a.add(i);
//                tmp.add(a);
//            }
//            res.addAll(tmp);
//        }
//        res.remove(0);
//
//        return res;
//    }
//
//    static int[] poiIDs= {0,1,2,3,4,5,6,7,8,9};
//
//
//
//    static int[] category= new int[]{1,2,3,4,1,2,3,4,1,2};
//
//    //另一种subset的写法
////   private static List<List<Integer>> subset4permu(){
////        List<List<Integer>> rst = new ArrayList<>();
////        back(rst,new ArrayList<>(),1);
////        return rst;
////   }
////    static int[] poiIDs= {0,1,2,3,4};
//
////    private static void back(List<List<Integer>> rst,List<Integer> item,int idx){
////        if(idx==poiIDs.length){
////            rst.add(new ArrayList<>(item));
////            return;
////        }
////       for (int i = idx; i <poiIDs.length ; i++) {
////           item.add(poiIDs[i]);
////           back(rst,item,i+1);
////           item.remove(item.size()-1);
////       }
////   }
//    static int n = 10;
//    static double ita = .5;
//    static double[][] dp = new double[1<<n][n];
//    static double profit(int poiID){
//        return ita * popular[poiID] + (1 - ita) * weight[poiID];
//    }
//
//    /**
//     * 每一个点的subset不论顺序的 score累加
//     * @param sub
//     * @return
//     */
//    static HashMap<List<Integer>,Double> subPoisScore(List<List<Integer>> sub){
//       HashMap<List<Integer>,Double> route2score = new HashMap<List<Integer>, Double>();
//        for(List<Integer> route:sub){
//            //加上起点
//            double score = profit(0);
//            for(int poiID:route){
//                score+=profit(poiID);
//            }
//            route2score.put(route,score);
//        }
//        return route2score;
//    }
//
//    /**
//     * 有顺序的score，考虑第二次访问同种category 权重会降
//     * @param routes
//     * @return
//     */
//    static HashMap<List<Integer>,Double> routeScoreCategory(List<List<Integer>> routes){
//        HashMap<List<Integer>,Double> route2score = new HashMap<List<Integer>, Double>();
//        for(List<Integer> route:routes) {
//            //加上起点
//            int[] categoryCnt = new int[5];
//            Arrays.fill(categoryCnt,1);
//            double score = profit(0);
//            for(int poiID:route){
//                score += profit(poiID) / categoryCnt[category[poiID]]/n*(cost[start][poiID]);
//                categoryCnt[category[poiID]]++;
//            }
//            route2score.put(route,score);
//
//        }
//        return route2score;
//
//    }
//
//    static int start = 0;
//
//    /**
//     *
//     * @param route [1,2,3]
//     * @return ->[1,2,3],[3,2,1],[1,3,2]...
//     */
//    static List<List<Integer>> permutation(List<Integer> route){
//
//            LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
//            res.add(new ArrayList<Integer>());
//            for (int n : route) {
//                int size = res.size();
//                for (; size > 0; size--) {
//                    List<Integer> r = res.pollFirst();
//                    for (int i = 0; i <= r.size(); i++) {
//                        List<Integer> t = new ArrayList<Integer>(r);
//                        t.add(i, n);
//                        res.add(t);
//                    }
//                }
//            }
//            return res;
//    }
//
//    static void bestScoreCostRouteInPermutation(List<List> PermuRoutes){
//        int min_path = Integer.MAX_VALUE;
//        int bestScore = 0;
//        for(List<Integer> route:PermuRoutes){
//
//            int tmpcost = 0;
//            int tmpscore = 0;
//            int k = start;
//            // 一条路径
//            int[] categoryCnt = new int[5];
//            Arrays.fill(categoryCnt,1);
//            double score = profit(0);
//            for (int i = 0; i <route.size() ; i++) {
//                tmpcost+=cost[k][route.get(i)];
//                score += profit(i) / categoryCnt[category[i]]/n*(cost[start][i]);
//                categoryCnt[category[i]]++;
//                k = route.get(i);
//
//            }
//        }
//    }
//
//
//    /**
//     * 返回这个点集最小路径的cost
//     * @param routes 一个点集的所有permutation路径
//     * @return
//     */
//    static int beforeTimelimit(List<List<Integer>> routes){
//        int min_path = Integer.MAX_VALUE;
//        bestroute= routes.get(0);
//        for(List<Integer> route:routes){
//            int curcost = 0;
//            int k = start;
//            for (int i = 0; i <route.size() ; i++) {
//
//                curcost+=cost[k][route.get(i)];
//                k = route.get(i);
//            }
//            curcost+=cost[k][start];
//            if(curcost>budget)continue;
//            if(min_path>curcost){
//                min_path = curcost;
//                bestroute = route;
//            }
//
//        }
////        System.out.println(bestroute);
////        System.out.println("min_cost:"+min_path);
//        return min_path;
//    }
//    static List<Integer> bestroute;
//
//
//
//    static void start(){
//
//        add();
//
//        System.out.println(Arrays.deepToString(cost));
//        List<List<Integer>> subpermutation = subset4permu();
//
////        HashMap<List<Integer>, Double> score = subPoisScore(subpermutation);
////        System.out.println(score);
//        double bestScore = 0;
//        List<Integer> outRoute = new ArrayList<>();
//        int outcost = Integer.MAX_VALUE;
//
//        for(List<Integer> subroute:subpermutation){
//            //尝试这个subset的所有路径
//            List<List<Integer>> permutation = permutation(subroute);
//            bestroute= new ArrayList<>();
//
//            HashMap<List<Integer>, Double> routeScore = routeScoreCategory(permutation);
//
//            int bestCost = beforeTimelimit(permutation);
//            if (bestCost<=budget) {
//                if(score.get(subroute)>=bestScore){
//                    if(score.get(subroute)==bestScore&&bestCost>outcost)continue;
//                    bestScore = score.get(subroute);
//                    outRoute = bestroute;
//                    outcost = bestCost;
//
//                }
//                System.out.println("----------");
//                System.out.println("少于"+budget+"分钟的点集 兴趣评分是");
//                System.out.println(subroute+" "+score.get(subroute));
//                System.out.println("最短路线是");
//                System.out.println(bestroute+" "+bestCost);
//                System.out.println("----------");
//
//            }
//
//
//        }
//        System.out.println("实验结果"+outRoute+" "+bestScore+" 花费 "+outcost);
//
//    }
////    static void tsp(int s,int mask){
////        int choosepoint = 1;
////        for (int i = 0; i < n; i++) {
////            int
////
////        }
////
////    }
//
//    public static void main(String[] args) {
//
//        List<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        start();
//
//
//
//
//
//
//    }
//}
