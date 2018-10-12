package leetcode;

public class lc74 {
    //5.9%
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length<1|| matrix[0].length<1)return false;
        int n = matrix.length*matrix[0].length;
        int col = matrix[0].length;
        int start = -1,end = n;
        while (start + 1 < end){
            int mid = start + (end-start) / 2;
            int r = mid / col;
            int c = mid % col;
            if(matrix[r][c]==target)return true;
            else if(matrix[r][c] < target){
                start = mid;
            }else end = mid;
        }
        return start>=0&&matrix[start/col][start%col]==target ;
    }

    public static void main(String[] args) {
        int[][] A = {{1}};
        lc74 sl = new lc74();
        System.out.println(sl.searchMatrix(A, 0));
    }
}
