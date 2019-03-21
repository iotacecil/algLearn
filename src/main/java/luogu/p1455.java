package luogu;

import java.util.*;

public class p1455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int w = sc.nextInt();
        int[] c = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int i = 0; i <m ; i++) {
            int vi = sc.nextInt();
            int vj = sc.nextInt();
            if (!map.containsKey(vi)) {
                map.put(vi, new HashSet<>());
            }
            if (!map.containsKey(vj)) {
                map.put(vj, new HashSet<>());
            }

            map.get(vi).add(vj);
            map.get(vj).add(vi);
        }




    }
}
