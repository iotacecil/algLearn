package gfg.tsp.readData;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class UserTimeInterval{
    String userId;
    //minutes
    int start;
    int end;
    int duration;
    int poiV;

    public UserTimeInterval(String userId, int start, int end, long duration, int poiV) {
        this.userId = userId;
        this.start = start;
        this.end = end;
        this.duration = (int)duration;
        this.poiV = poiV;
    }


    @Override
    public String toString() {
        return "UserTimeInterval{" +
                "userId='" + userId + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", duration=" + duration +
                ", poiV=" + poiV +
                '}';
    }
}

public class readUserTime {
    static void RriteInterval(List<UserTimeInterval> intervals){
        String wFile = "E:\\小论文\\数据\\Untitled Folder\\interval2modie.csv";

        BufferedWriter bw = null;
        FileWriter fw = null;
        String content = "This is the content writer in to a.txt file.\n";
        String content1 = "这是要写入的内容";
        try {
            fw = new FileWriter(wFile, false);
            bw = new BufferedWriter(fw);
            for(UserTimeInterval interval:intervals) {

                bw.write(interval.start+" ");
                bw.write(interval.end+"\n");
            }
            System.out.println("完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw != null)
                    bw.close();
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    static List<UserTimeInterval> buildInterval(){
        List<UserTimeInterval> intervals = new ArrayList<>();
        String csvFile = "E:\\小论文\\数据\\Untitled Folder\\Osaka_dur_poicnt.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat timetFormat = new SimpleDateFormat("HH:mm:ss");



        try {

            br = new BufferedReader(new FileReader(csvFile));
            String title = br.readLine();
            String blank = br.readLine();
            while ((line = br.readLine()) != null) {
                // use comma as separator
                line = line.replace("\"","" );

                String[] ls = line.split(cvsSplitBy);
//                    Date date = dateFormat.parse(ls[2]);
//                    Date start = timetFormat.parse(ls[4]);
//                    Date end = timetFormat.parse(ls[5]);
//                    long l = end.getTime() - start.getTime();
                LocalTime startLocal = LocalTime.parse(ls[4]);
             // 就是有人凌晨去酒吧
                LocalTime endLocal = LocalTime.parse(ls[5]);

                Duration dur = Duration.between(startLocal, endLocal);

                long minus = dur.toMinutes();
                if(minus<30)continue;
                UserTimeInterval interval = new UserTimeInterval(ls[1], startLocal.toSecondOfDay()/60, endLocal.toSecondOfDay()/60, dur.toMinutes(), Integer.parseInt(ls[6]));
                intervals.add(interval);



            }


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
//        System.out.println(intervals.size());
        return intervals;
    }
    public static void main(String[] args) {
        List<UserTimeInterval> intervals = readUserTime.buildInterval();
        System.out.println(intervals);
        RriteInterval(intervals);
        System.out.println(intervals.size());
    }
}
