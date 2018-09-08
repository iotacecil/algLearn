package leetcode;

import java.util.PriorityQueue;

public class lc378 {
    private int getLessEqual(int[][] matrix,int val){
        int res = 0;
        int n = matrix.length,i=n-1,j=0;
        //从左下方开始
        while (i>=0&&j<=n){
            if(matrix[i][j]>val)i--;
            else{
                res+=i+1;
                j++;
            }
        }
        return res;
    }
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0],hi = matrix[n-1][n-1];
        while (l<=hi){
            int mid = (hi-l)/2+l;
            int cnt = getLessEqual(matrix,mid);
            if(cnt<k) l=mid+1;
            else hi =mid-1;
        }
        return l;
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(k);
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                que.offer(matrix[i][j]);

            }

        }
        for (int i = 0; i <k-1 ; i++) {
            que.poll();
        }
        return  que.peek();
    }
    public static void main(String[] args) {
        lc378 sl = new lc378();
        System.out.println(sl.kthSmallest2(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));


    }
}
