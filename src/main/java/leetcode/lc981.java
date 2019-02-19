package leetcode;
/*
输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
输出：[null,null,"bar","bar",null,"bar2","bar2"]
解释：
TimeMap kv;
kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
kv.get("foo", 1);  // 输出 "bar"
kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）
kv.set("foo", "bar2", 4);
kv.get("foo", 4); // 输出 "bar2"
kv.get("foo", 5); // 输出 "bar2"


 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
    Map<String,TreeMap<Integer,String>> M;
    /** Initialize your data structure here. */
    public TimeMap() {
        M = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!M.containsKey(key)){
            M.put(key,new TreeMap<>());
        }
        M.get(key).put(timestamp,value );
    }

    public String get(String key, int timestamp) {
        if(!M.containsKey(key))return "";
        TreeMap<Integer, String> tree = M.get(key);
        Integer prekey = tree.floorKey(timestamp);
        return prekey!=null?tree.get(prekey):"";

    }
}
public class lc981 {

}
