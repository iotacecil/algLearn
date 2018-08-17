package niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class wy1804 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i <m ; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[v].add(w);
            graph[w].add(v);
        }


    }
}
