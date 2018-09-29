package gfg.tsp.readData;

import java.util.Arrays;
import java.util.HashMap;

public class OsakaGraph {

    public static int v=29;
    public double[][] osakaCost= new double[v][v];
    public int[] poiID = new int[v];
    public int categoryNum =4;
        //   HashMap<String,Integer> categoryID;
        public int[] catcnt= new int[categoryNum];
//    public  HashMap<Integer,Integer> poi2Category;
    public int[] category = new int[v];
    public double[] frequent;
    public  int[] visit;

        public static gfg.tsp.readData.OsakaGraph CntCat(gfg.tsp.readData.OsakaGraph graph, HashMap<Integer,Integer>poi2cat, int[] catCnt){
            graph.catcnt = catCnt;
//            graph.poi2Category = poi2cat;
            return graph;
        }

        public static gfg.tsp.readData.OsakaGraph build(double[][] osakaCost, double[] frequent) {
            gfg.tsp.readData.OsakaGraph graph = new gfg.tsp.readData.OsakaGraph();
            for (int i = 0; i <v ; i++) {
                graph.poiID[i] = i+1;
            }
            graph.osakaCost = osakaCost;
//        graph.poi2Category = poi2Category;
            graph.frequent = frequent;


            return graph;
        }
        public static gfg.tsp.readData.OsakaGraph addVisit(gfg.tsp.readData.OsakaGraph graph, int[] visit){
            graph.visit = visit;
            return graph;
        }

        public OsakaGraph() {
            for (double[] row : osakaCost) {
                Arrays.fill(row, -1);
            }
        }

        private void print2d(double[][] osakaCost){
            for(double[] row:osakaCost){
                for(double val:row){

                    System.out.printf("%.2f\t",val);
                }
                System.out.println();
            }
        }


        public void PrintOsaka() {
            System.out.println("Osaka一共有"+v+"个点\n");
            print2d(osakaCost);
            System.out.println("每个点的popular是"+Arrays.toString(frequent));
            System.out.println(Arrays.toString(category));
            for (int i = 0; i <catcnt.length ; i++) {
                System.out.printf("第%d种cate有%d个poi",i,catcnt[i]);
            }

            System.out.println("visit");
            System.out.println(Arrays.toString(visit));

        }

}
