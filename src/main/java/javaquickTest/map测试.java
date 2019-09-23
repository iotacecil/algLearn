package javaquickTest;

import java.util.HashMap;
import java.util.Map;

public class map测试 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a", 127);
        map.put("b", new Integer(127));
        map.put(null, null);
        System.out.println(map.get("a") == (map.get("b")));
    }
}
