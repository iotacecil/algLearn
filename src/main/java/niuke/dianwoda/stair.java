package niuke.dianwoda;

public class stair {
    public int f(int n){
        if(n <=2)return n;
        if(n == 3)return 4;
        return f(n-1) + f(n-2) + f(n-3);
    }
    public int f2(int n){
        int[] dp = new int[n+1];
        dp[0] =1;
        dp[1] =1;
        dp[2] =2;
        dp[3] =4;
        for (int i = 4; i <n+1 ; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 15;
        stair sl = new stair();
        System.out.println(sl.f2(15));
    }
}
