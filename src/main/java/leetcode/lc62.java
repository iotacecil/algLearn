package leetcode;

import java.util.Arrays;

public class lc62 {
    public int uniquePaths(int m, int n) {
        if(m<0||n<0)return 0;
        if(m==1&&n==1)return 1;
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
    public int uniquePaths2(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j - 1];
            }
            System.out.println(Arrays.toString(res));
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        lc62 sl = new lc62();
        System.out.println(sl.uniquePaths2(7, 3));
    }

}
