package ConcurBook;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Point{
    public final int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class DelegatingVehicleTracker {

    private final ConcurrentHashMap<String,Point> locations;
    //键值都不可变
    private final Map<String, Point> unmodifiableMap;

    // 所有对point的操作都委托给CHM
    public DelegatingVehicleTracker(Map<String, Point> points){
        locations = new ConcurrentHashMap<String, Point>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
        System.out.println("初始化"+points+" "+locations+" "+ unmodifiableMap);
    }
    // 不可修改但却实时的位置 指向可变状态的引用
    public Map<String, Point> getLocations(){
//        return Collections.unmodifiableMap(new HashMap<>(locations));
        System.out.println(Thread.currentThread().getName()+"查看当前car");
        System.out.println(locations);
        System.out.println(unmodifiableMap);
        return unmodifiableMap;

    }

    // 返回一个不可变的副本
    public Point getLocation(String id){
        return locations.get(id);
    }

    // 可修改 B线程修改了，A 返回这个
    public void setLocation(String id ,int x,int y){
        if (locations.replace(id,new Point(x, y)) == null) {
            throw new IllegalStateException("invalid vehicle name:"+id);
        }
        System.out.println(Thread.currentThread().getName()+"修改了id"+id);
    }

    class ModiMap implements Runnable{

        private Thread t;
        private String threadName;

        ModiMap( String name) {
            threadName = name;
            System.out.println("Creating " +  threadName );
        }

        public void run() {
            System.out.println("Running " +  threadName );
            try {
                for(int i = 4; i > 0; i--) {
                    System.out.println("Thread: " + threadName + ", " + i);
                    // 让线程睡眠一会
                    Thread.sleep(50);
                }
            }catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }

        public void start () {
            System.out.println("Starting " +  threadName );
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
        }
    }
    public static void main(String[] args) {
        Map<String,Point> cars = new HashMap<>();
        cars.put("car1",new Point(113,22) );
        cars.put("car2",new Point(13,55) );
        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(cars);
        new Thread(()-> System.out.println(tracker.getLocations())).start();

        new Thread(()->tracker.setLocation("car1",10 ,2 )).start();

        new Thread(()-> System.out.println(tracker.getLocations())).start();



    }
}
