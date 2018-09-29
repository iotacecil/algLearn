package gfg.tsp.readData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

public class readVisiteTime {
    public static OsakaGraph graphaddVisit(){
        //添加 visit数据
        OsakaGraph graph = readCost.buildOsaka();
        String csvFile = "E:\\小论文\\数据\\Untitled Folder\\OsakaPoiVisit.csv";
        BufferedReader br = null;
        String line = "";
        int[] visit = new int[29];
        Arrays.fill(visit,-1 );
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            String title = br.readLine();

            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                // use comma as separator
                line = line.replace("\"","" );

                String[] ls = line.split(cvsSplitBy);
                visit[Integer.parseInt(ls[1])-1] =(int) Double.parseDouble(ls[2]);
            }
            graph.visit = visit;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
//            } catch (ParseException e) {
//                e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return graph;
    }
    public static void main(String[] args) {
        OsakaGraph osaka = readVisiteTime.graphaddVisit();
        osaka.PrintOsaka();
    }
}
