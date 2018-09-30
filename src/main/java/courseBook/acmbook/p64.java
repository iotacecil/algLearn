package courseBook.acmbook;

public class p64 {
    public int LIS(int[] a,int n){
        //dp[i] 以ai为末尾的LIS长度
        int[] dp = new int[n+1];
        int res = 0;
        for (int i = 0; i <n ; i++) {
            //只包含ai的子序列
            dp[i] = 1;
            for (int j = 0; j <i ; j++) {
                if(a[j]<a[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                res = Math.max(dp[i],dp[j]+1 );
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] a = {4,2,4,1,5};
        p64 sl = new p64();
        System.out.println(sl.LIS(a, n));
    }
}
