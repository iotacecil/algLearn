package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUsimple {
    private LinkedHashMap<Integer,Integer> map;
    private final int capacity;


    public LRUsimple(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true)
        {
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size()>capacity;
            }
        };
    }
    public int get(int key){
        return map.getOrDefault(key,-1);
    }
    public void set(int key,int value){
        map.put(key,value);
    }

}
