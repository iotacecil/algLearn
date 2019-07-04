package leetcode;

import java.util.TreeMap;

public class lc846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int v : hand) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        for (int k : cnt.keySet()) {
            int v = cnt.get(k);
            if (v == 0) continue;
            for (int i = 1; i < W; i++) {
                int nxt = k + i;
                if (!cnt.containsKey(nxt)) {
                    return false;
                } else {

                    cnt.put(nxt, cnt.get(nxt) - v);
                    System.out.println(cnt);
                    if (cnt.get(nxt) < 0) return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
//        TreeMap<Integer,Integer> tree = new TreeMap<>();
//        tree.put(3,2);
//        tree.put(1,2);
//        tree.put(4,2);
//        System.out.println(tree.keySet());
//        Iterator<Integer> iterator = tree.keySet().iterator();
//        Integer next = iterator.next();
//        iterator.remove();

        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int W = 3;
        lc846 sl = new lc846();
        System.out.println(sl.isNStraightHand(hand, W));
    }
}
