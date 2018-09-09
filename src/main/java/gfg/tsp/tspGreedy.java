package gfg.tsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tspGreedy {
    static int start = 0;
    static int budget = 3000;
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
    List<Integer> pois = new ArrayList<>();

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
        while (pois.size()>0&&curcost<=budget) {
            double curhigh = 0;
            int curnext = start;
            int remove = start;
            for (i = 0; i < pois.size(); i++) {
                double score = profit(pois.get(i)) / (cost[start][pois.get(i)]);
                if (score > curhigh) {
                    if(curcost+cost[start][pois.get(i)]+cost[pois.get(i)][0]>budget)continue;
                    curhigh = score;
                    curnext = pois.get(i);
                    remove = i;
                }
            }

            curcost+=cost[start][curnext];
            if(curcost>budget)break;
            path[c++]=curnext;
            outscore+=profit(curnext);
            start = curnext;
            pois.remove(remove);
        }

        path[c] =0;
        System.out.println(Arrays.toString(path));
        System.out.println(c);
        System.out.println("score"+outscore);
        System.out.println("cost"+(curcost+(i==0?0:cost[i][0])));
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
        sl.smallcase();
        sl.greedy();
    }
}
