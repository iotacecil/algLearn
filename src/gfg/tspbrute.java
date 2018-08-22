package gfg;

import java.util.*;

public class tspbrute {

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


    //start =0 生成1,2,3->[[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
   private static List<List<Integer>> subpermutation(){
        List<List<Integer>> rst = new ArrayList<>();
        back(rst,new ArrayList<>(),1);
        return rst;
   }
    static int[] poiIDs= {0,1,2,3,4};

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
    static int n = 5;
    static double ita = .5;
    static double[][] dp = new double[1<<n][n];
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
    static int start = 0;
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
            return res;

    }

    static int budget = 150;

    static int beforeTimelimit(List<List<Integer>> routes){
        int min_path = Integer.MAX_VALUE;
        bestroute= routes.get(0);
        for(List<Integer> route:routes){
            int curcost = 0;
            int k = start;
            for (int i = 0; i <route.size() ; i++) {
                curcost+=cost[k][route.get(i)];
                k = route.get(i);
            }
            curcost+=cost[k][start];
            if(min_path>curcost){
                min_path = curcost;
                bestroute = route;
            }

        }
//        System.out.println(bestroute);
//        System.out.println("min_cost:"+min_path);

        return min_path;
    }
    static List<Integer> bestroute;

    static void start(){
        add();
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
