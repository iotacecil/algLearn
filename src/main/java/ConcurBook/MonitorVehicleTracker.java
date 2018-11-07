package ConcurBook;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 可变point类
 */
@NotSafe
class MutablePoint{
    public int x,y;

    public MutablePoint(){x=0;y=0;}

    public MutablePoint(MutablePoint p){
        this.x = p.x;
        this.y = p.y;
    }
}
//基于监视器模式的车辆追踪
// 线程安全的 因为所有的Map对象和可变的Point对象都没发布，返回位置都是用copy复制的，
public class MonitorVehicleTracker {
    //每台车用String标识 且有个坐标xy
    private final Map<String,MutablePoint> locations;
    public  MonitorVehicleTracker(Map<String,MutablePoint> locations){
        this.locations = deepCopy(locations);
    }
    public synchronized Map<String,MutablePoint> getLocations(){
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id){
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }


    public synchronized void setLocation(String id, int x, int y){
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalStateException("no such id :"+id);
        }

        loc.x = x;
        loc.y = y;
    }

    private static  Map<String, MutablePoint> deepCopy(
            Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();

        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        // 只能防止容器对象被修改，不能防止容器内的可变对象被修改
        return Collections.unmodifiableMap(result);
    }
}
