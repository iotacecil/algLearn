package other_oj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class hdu1848fast {
    //Wrong Answer
    static Scanner scan = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static int n, m, p;
    static int N = 10000;
    static int sg[] = new int[N + 1];
    static int fib[] = { 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610,
            987, 1597, 2584, 4181 };
    static int len = 18;
    static boolean vis[] = new boolean[N + 1];

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(vis, false);
            for (int j = 0; j < len; j++) {
                if (fib[j] > i)
                    continue;
                vis[sg[i - fib[j]]] = true;
            }
            for (int j = 0;; j++)
                if (!vis[j]) {
                    sg[i] = j;
                    break;
                }
        }

        while (true) {
            m = scan.nextInt();
            n = scan.nextInt();
            p = scan.nextInt();
            if (m == 0 && n == 0 && p == 0)
                break;
            int ans = sg[m] ^ sg[n] ^ sg[p];
            if (ans > 0)
                out.println("Fibo");
            else
                out.println("Nacci");
        }

        out.flush();
        out.close();
    }
}
