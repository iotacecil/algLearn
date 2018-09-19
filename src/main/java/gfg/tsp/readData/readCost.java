package gfg.tsp.readData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

class OsakaGraph{
    static int v=29;
    double[][] osakaCost= new double[29][29];
    int[] poiID = new int[29];
   HashMap<Integer,String> poi2Category;
   double[] frequent;



    public static OsakaGraph build(double[][] osakaCost,HashMap<Integer, String> poi2Category, double[] frequent) {
        OsakaGraph graph = new OsakaGraph();
        for (int i = 0; i <v ; i++) {
            graph.poiID[i] = i+1;
        }

        graph.osakaCost = osakaCost;
        graph.poi2Category = poi2Category;
        graph.frequent = frequent;
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
        System.out.println(Arrays.toString(frequent));
        System.out.println(poi2Category);

    }
}
public class readCost {
    public static OsakaGraph buildOsaka(){
        String csvFile = "E:\\小论文\\数据\\DSTG\\data-ijcai15\\costProf-ijcai15\\costProfCat-OsakPOI-all.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        double[][] osakaCost= new double[29][29];
        for (double[] row : osakaCost) {
            Arrays.fill(row, -1);
        }
        HashMap<Integer,String>poi2Category = new HashMap<>();
        double[] freq = new double[29];
        try {

            br = new BufferedReader(new FileReader(csvFile));
            String title = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                line = line.replace("\"","" );

                String[] ls = line.split(cvsSplitBy);
                int from = Integer.parseInt(ls[0])-1;
                int to = Integer.parseInt(ls[1])-1;
                osakaCost[from][to] = Double.parseDouble(ls[2]);
                if(from==0){
                    freq[to] = Integer.parseInt(ls[3]);
                    poi2Category.put(to,ls[4]);
                }
                if(from==2&&to ==1){
                    freq[to] = Integer.parseInt(ls[3]);
                    poi2Category.put(to,ls[4]);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        OsakaGraph graph = OsakaGraph.build(osakaCost,poi2Category,freq);
        return graph;
    }

    public static void main(String[] args) {
        OsakaGraph graph = readCost.buildOsaka();
        graph.PrintOsaka();
    }
}
