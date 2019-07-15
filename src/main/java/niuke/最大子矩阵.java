package niuke;

import java.util.Scanner;

/*

4
0 -2 -7 0
9 2 -6 2
-4 1 -4  1
-1 8  0 -2


 */
public class 最大子矩阵 {


    public static int maxsubmatrix(int[][] matrix) {
        int rst = Integer.MIN_VALUE;
        // 从i行+到j行的max
        for (int i = 0; i < matrix.length - 1; i++) {
            int[] arr = matrix[i].clone();
            rst = Math.max(rst, maxsubstring(arr));
            for (int j = i + 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    arr[k] += matrix[j][k];
                    rst = Math.max(rst, maxsubstring(arr));
                }
            }

        }
        return rst;
    }

    private static int maxsubstring(int[] nums) {
        int rst = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            rst = Math.max(cur, rst);
        }
        return rst;

    }

    public static void main(String[] args) {

//        int[] arr = {-1,-2,3,4,-3,2,3};
//        System.out.println(maxsubstring(arr));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxsubmatrix(matrix));
//

//
//        int[][] dp = new int[n+1][n+1];
//        for (int i = 1; i <=n ; i++) {
//            for (int j = 1; j <=n ; j++) {
//                dp[i][j] = dp[i][j-1] + dp[i-1][j] -dp[i-1][j-1] + matrix[i-1][j-1];
//            }
//        }
//
//        int rst = Integer.MIN_VALUE;
//        for (int i = 1; i <=n ; i++) {
//            for (int j = 1; j <=n ; j++) {
//
//                for (int k = 0; k <i ; k++) {
//                    for (int l = 0; l <j ; l++) {
//                        rst = Math.max(rst,dp[i][j]-dp[k][j]-dp[i][l]+dp[k][l]);
//                    }
//
//                }
//
//            }
//
//        }
//
//        System.out.println(rst);
    }
}
