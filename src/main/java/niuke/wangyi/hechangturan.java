package niuke.wangyi;

import java.util.Scanner;
/*
1
29
1 13

29

36
7 -15 31 49 -44 35 44 -47 -23 15 -11 10 -21 10 -13 0 -20 -36 22 -13 -39 -39 -31 -13 -27 -43 -6 40 5 -47 35 -8 24 -31 -24 -1
3 31


47
-41 -5 -10 -31 -44 -16 -3 -33 -34 -35 -44 -44 -25 -48 -16 -32 -37 -8 -33 -30 -6 -18 -26 -37 -40 -30 -50 -32 -5 -41 -32 -12 -33 -22 -14 -34 -1 -41 -45 -8 -39 -27 -23 -45 -10 -50 -34
6 3


链接：https://www.nowcoder.com/questionTerminal/661c49118ca241909add3a11c96408c8
来源：牛客网

49
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49
10 50


链接：https://www.nowcoder.com/questionTerminal/661c49118ca241909add3a11c96408c8
来源：牛客网

36
-33 -12 45 -43 10 13 48 -36 38 -38 -50 -5 -10 -30 19 17 -21 -16 27 17 -49 -17 -44 39 -12 33 1 -34 28 -23 -13 20 11 -1 37 36
9 1

对应输出应该为:

31383780480000

你的输出为:

3555705600000
 */
//AC
//https://www.nowcoder.com/questionTerminal/661c49118ca241909add3a11c96408c8
// 相邻两个学生的位置编号不相差超过d
public class hechangturan {
    static long[][][] dp;

    private static long[] dfs(long[] arr, int idx, int d, int k) {
        if (k > 0 && idx >= arr.length) return new long[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        else if (k == 0) return new long[]{arr[idx], arr[idx]};

        if (dp[idx][k][0] != 0) return dp[idx][k];

        long rstmax = Integer.MIN_VALUE;
        long rstmin = Integer.MAX_VALUE;

        for (int j = 1; j <= d; j++) {
            if (idx + j < arr.length) {
                long[] next = dfs(arr, idx + j, d, k - 1);
                if (next[0] != Integer.MIN_VALUE && next[1] != Integer.MAX_VALUE) {
                    //关键，还要和当前arr[idx]取最大？？？？
                    rstmax = Math.max(rstmax, Math.max(arr[idx], Math.max(arr[idx] * next[0], arr[idx] * next[1])));
                    rstmin = Math.min(rstmin, Math.min(arr[idx], Math.min(arr[idx] * next[1], arr[idx] * next[0])));
//                        System.out.println(arr[idx]+" "+rstmax+" "+rstmin);
                }

            }

        }
        dp[idx][k][0] = rstmax;
        dp[idx][k][1] = rstmin;


        return new long[]{rstmax, rstmin};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();
        long res = 0;
        dp = new long[n + 1][k + 1][2];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(arr, i, d, k - 1)[0]);

        }
//        long res = maxability(n, arr, k, d);
        System.out.println(res);
    }
    public static long maxability(int n,long[]arr,int k,int d){
        long[][] fmax = new long[k+1][n];
        long[][] fmin = new long[k+1][n];
        long res = Integer.MIN_VALUE;
        fmax[1] = arr.clone();
        fmin[1] = arr.clone();
          //选2-k个人
            for (int j = 2; j <=k ; j++) {
                for (int i = 0; i <n ; i++) {
                // 遍历上次层结果的[i-d,i)
                for (int l = i-1; l>=0&&l>=i-d ; l--) {
                    // 前面以l结尾的最大和最小
                    fmax[j][i] = Math.max(fmax[j][i],Math.max(fmax[j-1][l]*arr[i],fmin[j-1][l]*arr[i]) );
                    fmin[j][i] = Math.min(fmin[j][i],Math.min(fmax[j-1][l]*arr[i],fmin[j-1][l]*arr[i]) );
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            res = Math.max(res, fmax[k][i]);
        }
        return res;
    }
}
