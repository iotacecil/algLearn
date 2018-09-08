package dsLearn;

import java.util.LinkedHashMap;

public class LinkedHashMapLearn {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>(0, 0.75f, false);
        LinkedHashMap<Integer, Integer> cache2 = new LinkedHashMap<>(0, 0.75f, true);
        for (int i = 0; i < 10; i++) {
            cache.put(i, i);
            cache2.put(i, i);

        }
        cache.get(6);
        cache2.get(6);
        System.out.println(cache.toString());
        System.out.println(cache2.toString());
    }

}
