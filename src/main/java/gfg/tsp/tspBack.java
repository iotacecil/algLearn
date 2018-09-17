package gfg.tsp;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class tspBack {
    public void init(int nn,int bg){
        Arrays.fill(categoryCnt, 1);

        budget = bg;
        n = nn;
        Random rnd = new Random(1024);
        cost = new int[n][n];
//       visited =new int[n];
        popular = new double[n];
        weight = new double[n];
        used = new boolean[n];
        visited = new int[n];
        category = new int[n];
        cataScore= new double[]{0.123264,0.0812708,0.627277,0.922849,0.434333};


        for (int i = 0; i <n ; i++) {

            for (int j = 0; j <n ; j++) {
                if(i==j){
//                    cost[i][j] = rnd.nextInt(30)+20;
                    cost[i][j] = 0;
                    visited[i] = rnd.nextInt(30)+20;
                    continue;
                }
                cost[i][j] = rnd.nextInt(50)+50;
            }
            weight[i] = rnd.nextDouble();
            category[i] = rnd.nextInt(4)+1;
            popular[i] = rnd.nextDouble();
        }
//        System.out.println(Arrays.deepToString(cost));
//       System.out.println("以上是输入");
    }
    void initSmasll(){
        n = 10;
        budget = 300;
        Arrays.fill(categoryCnt, 1);
        cost = new int[][]{
//            { 0, 10, 15, 20,40 },
//            { 10, 0, 35, 25,20 },
//            { 15, 35, 0, 30,25 },
//            { 20, 25, 30, 0,45 },
//            { 30, 10, 15, 20,0 }
                {0,50,98,59,86,68,84,79,80,68},
                {77,0,71,67,84,81,87,76,85,72},
                {90,83,0,90,91,89,50,92,63,61},
                {95,85,54,0,68,66,75,85,81,80},
                {100,90,84,81,0,77,58,73,84,72},
                {84,50,64,96,67,0,69,76,70,92},
                {65,54,75,81,62,72,0,55,59,71},
                {85,57,52,99,57,86,63,0,81,93},
                {65,65,57,60,93,94,52,96,0,53},
                {65,62,58,64,90,54,77,91,55,0},
        };
        category= new int[]{1,2,3,4,1,2,3,4,1,2};
        used = new boolean[n];
        popular =new double[] {0.9035,0.131809,0.773522,0.47438,0.178228,0.757622,0.17774,0.662343,0.830317,0.271706,};
        visited =new int[]{36,21,33,48,45,48,39,37,25,43,};
        weight = new double[]{0.123264,0.0812708,0.627277,0.922849,0.834773,0.51677,0.812952,0.327586,0.504624,0.560625,};
        cataScore= new double[]{0.123264,0.0812708,0.627277,0.922849,0.434333};
    }
     static int n;

    boolean[] used;
     static  int[][] cost;
    static int[] category;
    static double[] cataScore;

    static double[] popular;
    static int budget;
    static int[] visited;
    static double[] weight ;
    static double ita = .5;
    static double profit(int poiID){
//        return ita * popular[poiID] + (1 - ita) * weight[poiID];
        return ita*popular[poiID]+(1-ita)*cataScore[category[poiID]];
    }

    public void mincost(){

    }
    static double bestScore=0;
    static List<Integer> bestRoute;
    static int bestCost = 0;


        static int[] categoryCnt = new int[5];

        private double scoreInRoute(int[] count,int from,int to){
            return profit(to) / ((double)count[category[to]]/n*(cost[from][to]+visited[to]));
        }
    public void tspback(List<Integer> route,int tmpc,double score,int idx){

        if(idx>=n-1){

            return;
        }
        for (int i = 1; i <n ; i++) {
            if(used[i]) continue;
            if(tmpc+cost[route.get(route.size()-1)][i]+visited[i]+cost[i][0]>budget)continue;
            if(score+profit(i) / categoryCnt[category[i]]/n*(cost[route.get(route.size()-1)][i])<bestScore)continue;


            tmpc+=(cost[route.get(route.size()-1)][i]+visited[i]);
//            System.out.println("visit : "+i+" cost "+tmpc);

//            score+= profit(i) / ((double)categoryCnt[category[i]]/n*(cost[route.get(route.size()-1)][i]+visited[i]));
            score+=scoreInRoute(categoryCnt,route.get(route.size()-1) ,i );
//            System.out.println("from "+route.get(route.size()-1)+ " to "+ i+" "+scoreInRoute(categoryCnt,route.get(route.size()-1) ,i ));
//            System.out.println(route.get(route.size()-1)+" scoreTo: " + i+" "+  profit(i) / ((double)categoryCnt[category[i]]/n*(cost[route.get(route.size()-1)][i]+visited[i])));
//            System.out.println("profit:"+ profit(i)  +"partScore: "+(double)categoryCnt[category[i]]/n*(cost[route.get(route.size()-1)][i]+visited[i]));
            categoryCnt[category[i]]++;

            used[i] = true;
            route.add(i);
            if(score>=bestScore){
//                System.out.println(Arrays.toString(categoryCnt));
                bestRoute = new ArrayList<>(route);
                bestScore = score;
                bestCost = tmpc+cost[route.get(route.size()-1)][0];
//                System.out.println(bestRoute);
//                System.out.println(bestScore);
            }
            tspback(route,tmpc,score,idx+1);

            route.remove(route.size()-1);
            categoryCnt[category[i]]--;
            tmpc-=(cost[route.get(route.size()-1)][i]+visited[i]);
            score-=scoreInRoute(categoryCnt,route.get(route.size()-1) ,i );
            used[i] = false;

        }
//        System.out.println(idx);
//        System.out.println(route);

    }
    int costTest(List<Integer> route){
//        System.out.println("route: "+route);

        int rssst = cost[0][route.get(0)]+visited[route.get(0)];
//        System.out.println(visited[0]);
        int i;
        for( i =0;i<route.size()-1;i++){
            System.out.println(route.get(i)+" "+route.get(i+1)+" "+cost[route.get(i)][route.get(i+1)]+"visited: "+visited[route.get(i+1)]);
            rssst+=cost[route.get(i)][route.get(i+1)]+visited[route.get(i+1)];
        }
//        System.out.println(route.get(route.size()-1)+" to "+ cost[route.get(route.size()-1)][0]);

        rssst+=cost[route.get(route.size()-1)][0];

        return rssst;
    }

    public static void main(String[] args) {
        tspBack sl = new tspBack();
//        System.out.println(sl.costTest(Arrays.asList(0, 8, 6)));
        sl.init(29,960);
        ArrayList<Integer> route = new ArrayList<>();
        route.add(0);
        System.out.println(profit(0));
        //29 个点 960分钟  3137
        long start = System.currentTimeMillis();
        sl.tspback(route,visited[0] ,profit(0) ,0 );
        System.out.println("运行时间："+(System.currentTimeMillis() - start));

//
        System.out.println("best"+sl.bestRoute);
        System.out.println(sl.bestCost);
        System.out.println(sl.costTest(sl.bestRoute));
        System.out.println(sl.bestScore);
    }
}
