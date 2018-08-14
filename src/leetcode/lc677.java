package leetcode;

import java.util.HashMap;

public class lc677 {
    HashMap<String,Integer> map;
    HashMap<String,Integer> tree;
    public lc677() {
         map = new HashMap<>();
        tree=new HashMap<>();

    }
    public void insert(String key, int val) {
        val -= map.getOrDefault(key,0);

        StringBuilder s = new StringBuilder();
        for (char c:key.toCharArray()) {
            s.append(c);

            tree.put(s.toString(), tree.getOrDefault(s.toString() ,0) + val);

        }
        map.put(key,map.getOrDefault(key,0)+val);




    }

    public int sum(String prefix) {
        return map.getOrDefault(prefix,0);
    }

    public static void main(String[] args) {
        lc677 sl = new lc677();
        sl.insert("aa",3);
        sl.insert("aa",2);

    }
}
