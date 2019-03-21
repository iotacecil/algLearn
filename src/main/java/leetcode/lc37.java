package leetcode;

public class lc37 {
    public int subarraysDivByK(int[] A, int K) {
        int n = A.length;
        int rst = 0;
        int[] presum = new int[n+1];
        //[1]-[0] = pre[0:1)
        for(int i =0;i<n;i++){
            presum[i+1] = presum[i]+A[i];
        }
        int[] mod = new int[K];
        for(int p:presum){
            mod[p%K]++;
        }
        for(int c:mod){
            rst += (c*(c-1))/2;
        }
        return rst;
    }
    public static void main(String[] args) {
        System.out.println((-2)%3);
        System.out.println(((-2)%3)+3);
        System.out.println((((-2)%3)+3)%3);
    }
}
