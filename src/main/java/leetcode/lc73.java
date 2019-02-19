package leetcode;

import java.util.Arrays;

public class lc73 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        //用第一行和第一列 记录 所有行，所有列的0的个数。
        // 第一行，第一列要不要变0可以存一个在[0][0]上，另一个用一个变量,
        boolean col0 = false;
        for (int i = 0; i < n; i++) {
            // 不用考虑[0][0]，如果[0][0]本身是0，则0行全0. 只需考虑[0]列上有没有本身是0的。
            if(matrix[i][0] == 0)col0 = true;
            for (int j = 1; j <m ; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0] =  0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=1 ; j--) {
                if(matrix[i][0] ==0 || matrix[0][j] ==0){
                    matrix[i][j] = 0;
                }
            }
            // 注意一行完了再变第一列
            if(col0)matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        lc73 sl = new lc73();
        sl.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
