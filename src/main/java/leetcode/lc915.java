package leetcode;


public  class lc915 {
    /**
     * Max(left)<=Min(right)  localMax<=next
     * @param A
     * @return
     */
    public int simple(int[]A){
        //left max
        int localMax = A[0];
        int parti = 0;
        //[paiti+1,end]>leftMax
        int max = localMax;
        for (int i = 1; i < A.length; i++) {
            if(localMax>A[i]){
                localMax = max;
                parti = i;
            }else max = Math.max(max, A[i]);
        }
        return parti+1;
    }
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] maxL = new int[n];
        int[] minR = new int[n];
        int m = A[0];
        for (int i = 0; i <n ; i++) {
            m = Math.max(m, A[i]);
            maxL[i] = m;
        }
        m = A[n-1];
        for (int i = n-1; i >=0 ; i--) {
            m = Math.min(m, A[i]);
            minR[i] = m;
        }
        for (int i = 1; i <n ; i++) {
            if(maxL[i-1]<=minR[i])return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] in = new int[]{5,0,3,8,0,9};
        lc915 sl = new lc915();
        System.out.println(sl.simple(in));

    }
}