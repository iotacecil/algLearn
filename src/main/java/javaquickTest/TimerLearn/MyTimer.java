package javaquickTest.TimerLearn;

import java.util.Calendar;
import java.util.Timer;

public class MyTimer {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        MyTimerTASK myTimerTASK = new MyTimerTASK("业务逻辑");
        MyTimerTASK task2 = new MyTimerTASK("task2");
        Calendar calendar = Calendar.getInstance();

        timer.scheduleAtFixedRate(myTimerTASK, calendar.getTime(),200);
        timer.scheduleAtFixedRate(task2, calendar.getTime(),200);


        //定时任务
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//        System.out.println(sf.format(calendar.getTime()));
//        calendar.add(Calendar.SECOND,3 );
//        MyTimerTASK myTimerTASK = new MyTimerTASK("业务逻辑");
//        timer.schedule(myTimerTASK, calendar.getTime(),20L);
//        System.out.println("计划时间"+sf.format(myTimerTASK.scheduledExecutionTime()));
//        System.out.println(timer.purge());
//
//        Thread.sleep(2000L);
//        myTimerTASK.cancel();
//        System.out.println(timer.purge());



    }
}
