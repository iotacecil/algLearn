package gfg;

import java.util.Arrays;

public class sortedMatrix {
    /**
     * 从右上角开始，比右上角大则向下，小则向左
     * @param matrix 行列都排序的二维数组中查找
     * @param k
     * @return
     */
    public int[] findInMatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int i =0,j = matrix.length-1;
        while (i<n&&j>=0){
            if(matrix[i][j] == k)return new int[]{i,j};
            else if(matrix[i][j]>k)j--;
            else i++;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        sortedMatrix sl = new sortedMatrix();
        int[][] matrix = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        System.out.println(Arrays.toString(sl.findInMatrix(matrix, 29)));
    }
}
