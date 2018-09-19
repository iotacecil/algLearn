package gfg.tsp;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class tspGreedy {
    static int start = 0;
    static int budget = 3000;

        public void init(int number,int bg){
            budget = bg;
            n = number;
            Random rnd = new Random(1024);
            cost = new int[n][n];
//       visited =new int[n];
            marked = new boolean[n];
            visited = new int[n];

            popular = new double[n];
            weight = new double[n];
            category = new int[n];
            categoryCnt = new int[5];
            Arrays.fill(categoryCnt,1);
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++) {
                    if(i==j){
//                        cost[i][j] = rnd.nextInt(30)+20;
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
            categoryCnt[category[0]]+=1;
            cataScore= new double[]{0.123264,0.0812708,0.627277,0.922849,0.434333};


//       System.out.println(Arrays.deepToString(distance));
//       System.out.println(Arrays.toString(popular));
//       System.out.println(Arrays.toString(weight));
//       System.out.println("以上是输入");
        }

    private void smallcase(){
        cost = new int[][]{
                { 0, 10, 15, 20,40 },
                { 10, 0, 35, 25,20 },
                { 15, 35, 0, 30,25 },
                { 20, 25, 30, 0,45 },
                { 30, 10, 15, 20,0 }};
        visited = new int[] {30,50,20,10,5};
        popular = new double[]{.4,.2,.3,.1,.3};
        weight = new double[]{.2,.2,.3,.3,.5};
        poiIDs= new int[]{0,1,2,3,4};
        n = 5;
        for (int i = 0; i < n; i++) {

            pois.add(i);
        }


        add();
    }

    private void smallcase2(int bg){
        n=10;
        budget = bg;
       cost= new int[][]{
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
//
        };


        marked = new boolean[n];
        //假设只有5种
        categoryCnt = new int[5];
        Arrays.fill(categoryCnt,1);
        category = new int[]{1,2,3,4,1,2,3,4,1,2};
        visited = new int[]{36,21,33,48,45,48,39,37,25,43,};
         cataScore= new double[]{0.123264,0.0812708,0.627277,0.922849,0.434333};

        weight = new double[]{0.123264,0.0812708,0.627277,0.922849,0.834773,0.51677,0.812952,0.327586,0.504624,0.560625,};
        popular = new double[]{0.9035,0.131809,0.773522,0.47438,0.178228,0.757622,0.17774,0.662343,0.830317,0.271706,};
//        for (int i = 0; i < n; i++) {
//
//            pois.add(i);
//        }
//
//
//        add();

    }
    double[] cataScore;
    List<Integer> pois = new ArrayList<>();
    static boolean[] marked;
    static int[][] cost;
    static int[] visited ;
    static double[] popular ;
    static double[] weight ;
    static int[] poiIDs;
    static int n;
    static double ita = .5;
    //
    int[] category;
    int[] categoryCnt;

    double profit(int poiID){
        return ita * popular[poiID] + (1-ita)*cataScore[category[poiID]];
    }

    private  void add(){
        for (int i = 0; i <cost.length ; i++) {
            for (int j = 0; j <cost[0].length ; j++) {
                // 最后从5回到0不应该是add之后的距离 第一列应该只有[0][0]要add 其他都是原本距离

                if(j==0&&i!=0)continue;
                cost[i][j]+=visited[j];
            }
        }
    }

/**
     * @param count
     * @param from
     * @param to
     * @return
     */
    private double scoreInRoute(int[] count,int from,int to){
        ;
        return profit(to) / ((double)count[category[to]]/n*(cost[from][to]+visited[to]));
    }

    public void greedy(){
        int curcost = visited[0];
        categoryCnt[category[0]] +=1;
        int start =0;
        int[] path = new int[n+3];
        int c=0;
        path[c++]=0;
//        double outscore = profit(0);
        double outscore =0;
        int i=0;
        marked[0] = true;
        int curnext = start;
        //下一个poi中最高分
        //找到下一个poi
        int costback = 0;

        while (curcost<=budget){
            curcost -= costback;
            costback = 0;
            /**
             * 找到最优下一个点
             */
            double curhigh = 0;
            for (i = 1; i < n; i++) {
                if (marked[i]) continue;
    //                double score = profit(i) / categoryCnt[category[i]]/n*(cost[start][i]);
                double score = scoreInRoute(categoryCnt, start, i);

//                System.out.println(start+" to "+i+" "+score);
                if (score >= curhigh) {
                    if (curcost + cost[start][i] + visited[i] + cost[i][0] > budget) continue;

                    curhigh = score;
                    curnext = i;
                }
            }
            costback = cost[curnext][0];
            if(marked[curnext])break;
            //回路
            curcost+=(cost[start][curnext]+visited[curnext]+costback);

//            System.out.println("当前总score :"+outscore+" 当前回路花费 "+curcost+" \n" +
//                    "当前最高 from "+start+" to "+curnext +" cost: "+cost[start][curnext]+visited[curnext]+" \n" +
//                    "访问了c"+category[curnext]+"这种score是"+(double)scoreInRoute(categoryCnt, start,curnext ));
//            System.out.println(Arrays.toString(path)+"花费"+(curcost));

//            if(curcost+cost[curnext][0]>budget)break;


            path[c++]=curnext;
            marked[curnext] = true;
            //改
            outscore+=scoreInRoute(categoryCnt, start,curnext );
            categoryCnt[category[curnext]]++;
            start = curnext;
        }

        path[c] =0;
        curcost+=cost[curnext][0];
        System.out.println("next: "+curnext+" "+cost[curnext][0]);
        System.out.println(Arrays.toString(path));
        System.out.println("最后score"+outscore);

        System.out.println("最后cost"+curcost);
//
//
        System.out.println("-----------");
//        int total = visited[path[0]];
//        for (int j = 0; j <c; j++) {
//            if(path[j+1]==0)
//                total+=(cost[path[j]][path[j + 1]]);
//            else
//            total+=(cost[path[j]][path[j + 1]]+visited[path[j+1]]);
////            System.out.print(path[j]+" "+path[j + 1]);
////            System.out.println(" cost: "+cost[path[j]][path[j + 1]]+" vi "+path[j+1]+" "+visited[path[j+1]]+" total: "+total);
//
//
//        }
//        System.out.println(total);

    }
//     double[] oneRouteScoreCost(List<Integer> route){
//
//        int tmpcost =visited[0];
////        int tmpscore = 0;
//        int k = start;
//        // 一条路径
//        int[] categoryCnt = new int[5];
//        Arrays.fill(categoryCnt,1);
//        categoryCnt[category[0]]+=1;
//        double score = profit(0);
//        for (int i = 0; i <route.size() ; i++) {
//            tmpcost+=cost[k][route.get(i)];
////            System.out.println("from: "+ k + " to: "+ route.get(i)+" cost : "+ cost[k][route.get(i)]);
//            if(tmpcost>budget)return new double[]{budget,-1};
////            score += (profit(route.get(i)) / ((double)categoryCnt[category[route.get(i)]]*(cost[k][route.get(i)]))/n);
//            score+=scoreInRoute(categoryCnt,k,route.get(i));
//            System.out.println("from "+k+" To: "+route.get(i) +" score " + scoreInRoute(categoryCnt,k,route.get(i)));
//
//            categoryCnt[category[route.get(i)]]++;
//            k = route.get(i);
////            System.out.println("当前总score :"+score+" 当前花费 "+tmpcost+" from "+k+" to "+route.get(i) +" cost: "+cost[k][route.get(i)]+" 访问了c"+category[route.get(i)]+"这种score是"+profit(route.get(i)) / categoryCnt[category[route.get(i)]]/n*(cost[k][route.get(i)]));
//
//        }
//        tmpcost+=cost[route.get(route.size()-1)][0];
////        System.out.println("last: "+cost[route.get(route.size()-1)][0]);
//        if(tmpcost>budget)return new double[]{budget,-1};
//
//        return new double[]{tmpcost,score};
//    }

    public static void main(String[] args) {
        tspGreedy sl = new tspGreedy();
        /**
         * [0, 17, 14, 18, 15, 9, 13, 16, 7, 12, 19, 2, 20, 23, 11, 10, 21, 24, 6, 3, 28, 22, 4, 25, 5, 1, 26, 27, 0, 0, 0, 0]
         最后score2.1218893714686846
         最后cost2915
         */
        for (int i = 500; i < 3000; i+=50) {
            sl.init(29, i);
            System.out.println(i+"budget");

//        sl.smallcase2(400);
//        System.out.println(Arrays.toString(sl.oneRouteScoreCost(Arrays.asList(3, 2, 5, 8, 6, 7, 4, 9, 1))));

            long a = System.currentTimeMillis();
            sl.greedy();
            long b = System.currentTimeMillis();
//            long c = b - a;
            System.out.println("运行时间为:" + (b-a));//输出运行时间
        }
    }
}
