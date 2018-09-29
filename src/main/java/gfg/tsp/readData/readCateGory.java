package gfg.tsp.readData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class readCateGory {
    private static HashMap<String,Integer> cateStr2Int(){
        HashMap<String,Integer> id = new HashMap<>();
        id.put("Amusement",0 );
        id.put("Entertainment",1 );
        id.put("Historical",2 );
        id.put("Park",3 );
        return id;
    }
    public static OsakaGraph buildCat(){
        OsakaGraph osaka = readVisiteTime.graphaddVisit();

        String csvFile = "E:\\小论文\\数据\\Untitled Folder\\OsakaPoiTheme.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        HashMap<String, Integer> cateId = cateStr2Int();
//        HashMap<Integer,Integer> poi2cate= new HashMap<>();
        int[] category = new int[29];
        int[] cateCnt = new int[4];
        try {

            br = new BufferedReader(new FileReader(csvFile));
            String title = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                line = line.replace("\"", "");
                String[] ls = line.split(cvsSplitBy);
                category[Integer.parseInt(ls[1])-1] = cateId.get(ls[2]);
//                poi2cate.put(Integer.parseInt(ls[1]),cateId.get(ls[2]) );
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

       for(int i:category){
            cateCnt[i]++;
       }
       osaka.catcnt = cateCnt;
        osaka.category = category;
//       osaka.poi2Category = poi2cate;
        return osaka;
    }

    public static void main(String[] args) {
        OsakaGraph graph = readCateGory.buildCat();
        graph.PrintOsaka();
    }
}
