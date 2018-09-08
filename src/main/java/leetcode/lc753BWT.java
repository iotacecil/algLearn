package leetcode;

import java.util.Arrays;

//todo
//不明白怎么回事
public class lc753BWT {
    public String crackSafe(int n, int k) {
        int M = (int) Math.pow(k, n-1);
        int[] P = new int[M * k];
        for (int i = 0; i < k; ++i)
            for (int q = 0; q < M; ++q)
                P[i*M + q] = q*k + i;
        System.out.println(Arrays.toString(P));
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M*k; ++i) {
            int j = i;
            while (P[j] >= 0) {
                ans.append(String.valueOf(j / M));
                int v = P[j];
                P[j] = -1;
                j = v;
            }
        }
        System.out.println(ans.toString());

        for (int i = 0; i < n-1; ++i)
            ans.append("0");
        return new String(ans);
    }

    public static void main(String[] args) {
        lc753BWT sl = new lc753BWT();
        sl.crackSafe(6,4);
    }
}
