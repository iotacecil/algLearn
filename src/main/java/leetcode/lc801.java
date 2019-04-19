package leetcode;

public class lc801 {
    public int minSwapDP(int[] A, int[] B) {
        int n = A.length;
        int[] swap = new int[n];
        int[] keep = new int[n];
        swap[0] = 1;
        for (int i = 1; i <n ; i++) {
            // 关键
            keep[i] = swap[i] = n;
            if(A[i-1] < A[i] && B[i-1]<B[i]){
                keep[i] = keep[i-1];
                swap[i] = swap[i-1] +1;
            }
            if(A[i-1] <B[i] && B[i-1] <A[i]){
                keep[i] = Math.min(keep[i],swap[i-1]);
                swap[i] = Math.min(swap[i],keep[i-1]+1);
            }
        }
        return Math.min(keep[n-1],swap[n-1]);
    }


        int ans;
    public int minSwap(int[] A, int[] B) {
        ans = A.length;
        dfs(A,B,1,0);
        return ans;
    }
    private void dfs(int[]A,int[]B,int idx,int cnt){
        if(cnt>=ans)return;
        if(idx == A.length){
            ans = Math.min(ans,cnt);
            return;
        }
        if(A[idx]>A[idx-1] && B[idx] > B[idx-1]){
            dfs(A,B,idx+1,cnt);
        }
        if(A[idx] > B[idx-1] && B[idx] > A[idx-1]){
            swap(A, B, idx);
            dfs(A,B,idx+1,cnt+1);
            swap(A,B,idx);
        }
    }
    private void swap(int[]A,int[]B,int i){
        int tmp = B[i];
        B[i] = A[i];
        A[i] = tmp;
    }

}
