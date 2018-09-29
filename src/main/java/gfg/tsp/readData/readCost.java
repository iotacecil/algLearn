package gfg.tsp.readData;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;



public class readCost {




    //添加cost数据
    public static OsakaGraph buildOsaka(){


        String csvFile = "E:\\小论文\\数据\\DSTG\\data-ijcai15\\costProf-ijcai15\\costProfCat-OsakPOI-all.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";



        double[][] osakaCost= new double[29][29];
        for (double[] row : osakaCost) {
            Arrays.fill(row, -1);
        }
        int freqSum = 0;
        HashMap<Integer,Integer>poi2Category = new HashMap<>();
        double[] freq = new double[29];
        try {

            br = new BufferedReader(new FileReader(csvFile));
            String title = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                line = line.replace("\"","" );
//                System.out.println(line);

                String[] ls = line.split(cvsSplitBy);
                int from = Integer.parseInt(ls[0])-1;
                int to = Integer.parseInt(ls[1])-1;
                double dist = Double.parseDouble(ls[2]);
                double time = dis2time(dist);
                osakaCost[from][to] = time;
                if(from==0){
                    int popular = Integer.parseInt(ls[3]);
                    freqSum+= popular;
                    freq[to] = popular;
//                    poi2Category.put(to,cateId.get(ls[4]));
                }
                if(from==1&&to ==0){
                    int popular = Integer.parseInt(ls[3]);
                    freqSum+= popular;
                    freq[to] = popular;
//                    poi2Category.put(to,cateId.get(ls[4]));
                }
            }
            //修复数据 26
            final double[][] Osakapoi26={
                    {13.2,12.8},
                    {12.5,12.7},
                    { 6.98,7.23},
                    {15.9,15.4},
                    {4.07,4.13},

                    { 5.23,6.08},
                    {3.12,4.55},
                    {1.39,1.43},
                    {14,13.8},
                    {7.56,6.64},

                    {6.20,5.59},
                    {13.3,15},
                    {1.39,1.43},
                    {3.94,3.95},
                    {6.06,6.34},

                    {14.3,14},
                    {3.51,3.51},
                    {2.26,2.38},
                    {6.38,6.53},
                    {6.37,5.6},

                    {5.1,6.07},
                    {6.95,8.43},
                    {6.76,8.52},
                    {5.74,5.82},
                    {7.93,6.52},

                    {  0,0},
                    {7.80,8.60},
                    {3.66,3.60},
                    {9.06,9.82}
            };
            double[][] poi14cost = {{12.2,12.1},
                    {11.5,12.0},
                     {5.91,4.61},
                     {14.8,14.7},
                     {8.31,6.43},

                     {6.78,7.21},
                     {5.02,3.88},
                     {3.12,2.82},
                     {11.6,13.1},
                     {6.49,4.02},

                     {5.13,4.88},
                     {12.3,7.78},

                    {3.12,2.82},
                    {0,0},

                    {4.04,3.57},

                     {12,13.4},
                     {578,716},
                     {4.16,4.41},
                     {3.98,3.74},
                     {3.96,3.55},

                     {3.09,3.51},
                     {4.77,4.25},
                     {5.69,4.03},
                     {3.33,5.16},
                     {10.3,9.40},

                     {3.95,3.94},
                     {6.73,4.93},
                     {7.77,5.78},
                     {5.08,5.35}};

            for (int i = 0; i <=28 ; i++) {

                if(i!=25) {
                    double to26 = Osakapoi26[i][1] * 1000;
                    double toi = Osakapoi26[i][0] * 1000;


                    osakaCost[i][25] = dis2time(to26);
                    osakaCost[25][i] = dis2time(toi);
                }
                if(i!=13) {
                    double to13 = poi14cost[i][1] * 1000;
                    double toi = poi14cost[i][0] * 1000;
//                    System.out.println("将要修改" + osakaCost[i][13] + "为" + dis2time(to13));

                    osakaCost[i][13] = dis2time(to13);
                    osakaCost[13][i] = dis2time(toi);
                }
//                System.out.println("填充8到13");
//                System.out.println("原来"+osakaCost[i][12]+"填充"+osakaCost[i][7]);
                osakaCost[i][12] = osakaCost[i][7];
                osakaCost[12][i] = osakaCost[7][i];
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
//        System.out.println("所有poi popular和是"+freqSum);
        for (int i = 0; i <freq.length ; i++) {
            freq[i] /= freqSum;
        }
        OsakaGraph graph = OsakaGraph.build(osakaCost,freq);
        return graph;
    }
    private static double dis2time(double dist){
        // 假设 <1km 步行 速度为 83km/minute   >1km 车 260m/minute
        final double byFoot  = 83;
        final double byCar = 300;
        if (dist < 1000) dist /= byFoot;
        else dist /= byCar;
       return dist;

    }
    public static void main(String[] args) {
        OsakaGraph graph = readCost.buildOsaka();
        graph.PrintOsaka();
    }
}
