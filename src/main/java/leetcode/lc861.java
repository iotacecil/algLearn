package leetcode;

public class lc861 {
    public int matrixScore(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        for(int[] row :A){
            if(row[0] == 0){
                for(int i = 0;i < m;i++){
                    row[i] = 1-row[i];
                }
            }
        }
        int sum = 0;
        for(int i = 0;i < m;i++){
            int col0cnt = 0;

            for(int j = 0;j < n;j++){
                if(A[j][i] == 0)col0cnt++;
                if(j == n-1 && col0cnt >(n/2)){
                    sum += col0cnt * (1 << (m - 1 -i));
                }else{
                    sum += (n - col0cnt) * (1 << (m - 1 -i));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {

    }
}
