package javaquickTest.TimerLearn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTASK extends TimerTask{
    String name;
    int cnt=0;
    public MyTimerTASK(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if(cnt<9999) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            System.out.println(sf.format(calendar.getTime()));
            System.out.println("timerTask" + name);
            cnt++;
        }else{
            cancel();
            System.out.println("任务取消");
        }
    }
}
