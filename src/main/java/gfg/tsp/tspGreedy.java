package gfg.tsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tspGreedy {
    static int start = 0;
    static int budget = 480;
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

    private void smallcase2(){
        n=10;

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

        visited = new int[]{36,21,33,48,45,48,39,37,25,43,};
        popular = new double[]{0.123264,0.0812708,0.627277,0.922849,0.834773,0.51677,0.812952,0.327586,0.504624,0.560625,};
        weight = new double[]{0.9035,0.131809,0.773522,0.47438,0.178228,0.757622,0.17774,0.662343,0.830317,0.271706,};
        for (int i = 0; i < n; i++) {

            pois.add(i);
        }


        add();

    }
    List<Integer> pois = new ArrayList<>();
    static boolean[] marked;
    static int[][] cost;
    static int[] visited ;
    static double[] popular ;
    static double[] weight ;
    static int[] poiIDs;
    static int n;
    static double ita = .5;
    static double profit(int poiID){
        return ita * popular[poiID] + (1 - ita) * weight[poiID];
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

    private void greedy(){
        int curcost = 0;
        int start =0;
        int[] path = new int[n+3];
        int c=0;
        path[c++]=0;
        double outscore = profit(0);
        int i=0;
        int curnext = start;
        while (curcost+cost[start][0]<=budget) {
            double curhigh = 0;
            //找到下一个poi
            for (i = 1; i < n; i++) {
                if(marked[i])continue;
                double score = profit(i) / (cost[start][i]);
                if (score >= curhigh) {
                    if(curcost+cost[start][i]+cost[i][0]>budget)continue;

                    curhigh = score;
                    curnext = i;
                }
            }
            if(curnext==start)break;

            System.out.println(curcost+"+to"+curnext +" cost: "+cost[start][curnext]);
            curcost+=cost[start][curnext];
            if(curcost+cost[curnext][0]>budget)break;
            path[c++]=curnext;
            marked[curnext] = true;
            outscore+=profit(curnext);
            start = curnext;
        }

        path[c] =0;
        curcost+=cost[curnext][0];
        System.out.println(Arrays.toString(path));
        System.out.println("score"+outscore);

        System.out.println("cost"+curcost);
        int total = 0;
        for (int j = 0; j <c; j++) {
            total+=cost[path[j]][path[j + 1]];
            System.out.print(path[j]+" "+path[j + 1]);
            System.out.println(" cost: "+cost[path[j]][path[j + 1]]+" ");

        }
        System.out.println(total);

    }

    public static void main(String[] args) {
        tspGreedy sl = new tspGreedy();
        sl.smallcase2();
        sl.greedy();
    }
}
