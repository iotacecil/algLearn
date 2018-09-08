package leetcode;

import java.util.Arrays;

public class lc48 {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length-1;
        int top =0;
        int bot = matrix.length-1;
        int n = matrix.length;
        while (n>1){
            for (int i =0;i<n-1;i++){
                //1
                int tmp = matrix[top][left+i];
                //7->1
                matrix[top][left+i]=matrix[bot-i][left];
                //9->7
                matrix[bot-i][left]=matrix[bot-i][right];
                //3->9
                matrix[bot-i][right]=matrix[top+i][right];
                //1->3
                matrix[top+i][right]=tmp;
            }
            top--;
            bot++;
            left++;
            right--;
            n-=2;

        }


    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{

                {1,2,3},
                {4,5,6},
                {7,8,9}

        };
        lc48 sl = new lc48();
        sl.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
