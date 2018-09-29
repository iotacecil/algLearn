package gfg.tsp.readData;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class GmmgroupScore{
    List<String> userIds;
    HashMap<String,Double>score = new HashMap<>();

    public GmmgroupScore(List<String> userIds, HashMap<String, Double> score) {
        this.userIds = userIds;
        this.score = score;
    }

    @Override
    public String toString() {
        return "GmmgroupScore{" +
//                "userIds=" + userIds +
                ", score=" + score +
                '}';
    }
}
public class readGroupScore {
    //之后可以改进传入category数量
    public static Map<Integer,GmmgroupScore> groupScoreRead(){
        String csvFile = "E:\\小论文\\数据\\Untitled Folder\\gmm9CSgroupScore.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Map<Integer,GmmgroupScore> groups = new HashMap<>();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            String title = br.readLine();

            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                // use comma as separator
                line = line.replace("\"","" );
                HashMap<String,Double> score = new HashMap<>();

                String[] ls = line.split(cvsSplitBy,6);
//                System.out.println(Arrays.toString(ls));
                //暂时group
                String groupID = ls[0];
                score.put("Amusement", Double.parseDouble(ls[1]));
                score.put("Entertainment", Double.parseDouble(ls[2]));
                score.put("Historical", Double.parseDouble(ls[3]));
                score.put("Park", Double.parseDouble(ls[4]));
//                System.out.println(ls[5]);
                String users = ls[5].replace("\"", "");

                List<String> list = Arrays.asList(users.split(cvsSplitBy));
                GmmgroupScore newgroup = new GmmgroupScore(list, score);
//                System.out.println(newgroup);
//                System.out.println(groupID);
                groups.put(Integer.parseInt(groupID),newgroup);
            }
//            System.out.println(groups);
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
        return groups;
    }
    public static double[] catScoreNorm(HashMap<String,Double>score,HashMap<Integer,String>poiCate){
        double[] groupS = new double[29];
        HashMap<String,Integer> catPoiNum = new HashMap<>();
        catPoiNum.put("Entertainment",11 );
        catPoiNum.put("Amusement",6);
        catPoiNum.put("Historical",6);
        catPoiNum.put("Park",6);
        double sum = .0;
        for(String cat:score.keySet()){
            sum+=score.get(cat)*catPoiNum.get(cat);
        }
        for(Integer cat:poiCate.keySet()){
            groupS[cat]=score.get(poiCate.get(cat))/sum;
        }
        return groupS;
    }
    public static Map<Integer,double[]> groupPoiScore(){
        HashMap<Integer,double[]> rst = new HashMap<>();

        return rst;
    }

    public static void main(String[] args) {
        System.out.println("forPython Test");
//        OsakaGraph graph = readCost.buildOsaka();
//        Map<Integer, GmmgroupScore> group = readGroupScore.groupScoreRead();
//        for(GmmgroupScore onegroup:group.values())
//            System.out.println(Arrays.toString(readGroupScore.catScoreNorm(onegroup.score, graph.poi2Category)));


    }


}
