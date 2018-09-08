package gfg;

//给定区间上的最小元素位置
public class RMQ {
    int f1(int[] a,int start,int end ){
        int len = a.length;
        int n = end-start+1;
        int[][] M = new int[n+1][n+1];
        for(int i =0;i<n;i++){
            M[i][0] =i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(a[M[i][j-1]]<a[j]){
                    M[i][j] = M[i][j-1];
                }else
                    M[i][j] =j;
            }

        }
        return M[0][n];
    }

    public static void main(String[] args) {
        RMQ rmq = new RMQ();
        System.out.println(rmq.f1(new int[]{2, 3, 4, 1, 6, 7, 8, 9, 1, 7}, 2, 7));
    }
}
