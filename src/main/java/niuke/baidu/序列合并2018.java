package niuke.baidu;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 序列合并2018 {
    static class node {
        int nn;
        int f;
        int ai;

        // n f 第 ai个公式
        public node(int nn, int f, int ai) {
            this.nn = nn;
            this.f = f;
            this.ai = ai;
        }
    }

    private static int cal(int[][] a, int i, int nn) {
        int f = a[i][0] * nn;
        for (int j = 1; j < 7; j++) {
            f = (f + a[i][j]) * nn;
        }
        f += a[i][7];
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[][] a = new int[k][8];
        int ns = 1;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 8; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int n = sc.nextInt();

        PriorityQueue<node> maxheap = new PriorityQueue<>((aa, b) -> aa.f - b.f);
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            int f = cal(a, i, 1);
            maxheap.add(new node(1, f, i));
        }

//        List<Integer> list = new ArrayList<>();
        while (cnt != n - 1) {
            node min = maxheap.poll();
            cnt++;
            int nxtnn = min.nn + 1;
            int i = min.ai;
            int f = cal(a, i, nxtnn);
            node nxt = new node(nxtnn, f, i);
            maxheap.add(nxt);
        }

        System.out.println(maxheap.poll().f);


    }
}
