//package gfg.tsp.readData;
//
//import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//
//class GmmgroupScore{
//    List<String> userIds;
//    HashMap<String,Double>score = new HashMap<>();
//
//    public GmmgroupScore(List<String> userIds, HashMap<String, Double> score) {
//        this.userIds = userIds;
//        this.score = score;
//    }
//
//    @Override
//    public String toString() {
//        return "GmmgroupScore{" +
//                "userIds=" + userIds +
//                ", score=" + score +
//                '}';
//    }
//}
//public class readGroupScore {
//    public static void main(String[] args) {
//        String csvFile = "E:\\小论文\\数据\\Untitled Folder\\OsakaPoiVisit.csv";
//        BufferedReader br = null;
//        String line = "";
//        String cvsSplitBy = ",";
//        try {
//
//            br = new BufferedReader(new FileReader(csvFile));
//            String title = br.readLine();
//
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//                // use comma as separator
//                line = line.replace("\"","" );
//
//                String[] ls = line.split(cvsSplitBy);
//                visit[Integer.parseInt(ls[1])-1] =(int) Double.parseDouble(ls[2]);
//            }
//            graph.visit = visit;
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
////            } catch (ParseException e) {
////                e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//
//}
