package niuke;

public class stonegame {
    int search(int l, int r, int[][] f, int[][] visit, int[][] sum) {

        if(visit[l][r] == 1) {
            return f[l][r];
        }

        if(l == r) {
            visit[l][r] = 1;
            return f[l][r];
        }

        f[l][r] = Integer.MAX_VALUE;
        for (int k = l; k < r; k++) {
            f[l][r] = Math.min(f[l][r], search(l, k, f, visit, sum) + search(k + 1, r, f, visit, sum) + sum[l][r]);
        }

        visit[l][r] = 1;
        return f[l][r];
    }

    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;

        // initialize
        int[][] f = new int[n][n];
        int[][] visit = new int[n][n];

        for (int i = 0; i < n; i++) {
            f[i][i] = 0;
        }

        // preparation
        int[][] sum = new int[n][n];
        for (int i = 0; i < 3; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }

        return search(0, n-1, f, visit, sum);
    }

    public static void main(String[] args) {
        int m = 3;
        int[] A = {1,7,2,2,5,9};
        stonegame sl = new stonegame();
        System.out.println(sl.stoneGame(A));
    }
}
