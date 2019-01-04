package niuke.tecent;

import java.util.Scanner;
//长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
public class gedan {
    public static void main(String[] args) {
        long mod = 1000000007;

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int a = sc.nextInt();
        int x = sc.nextInt();
        int b = sc.nextInt();
        int y = sc.nextInt();
        long[][] dp =new long[101][1001];
        int[] p = new int[201];
        // 展开成背包物品的输入
        dp[0][0] = 1;
        for (int i = 1; i <=x ; i++) {
            p[i] = a;
        }
        for (int i = x+1; i <=x+y ; i++) {
            p[i] = b;
        }
        // 一共有x+y个物品
        for (int i = 1; i <=x+y ; i++) {
            for (int j = 0; j <=k ; j++) {
                if(j >= p[i]){
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-p[i]]) % mod;
                }
                else
                    dp[i][j] = dp[i-1][j]%mod;
            }
        }
        System.out.println(dp[x+y][k]%mod);
//        System.out.println(qlist(k, a, x, b, y));
    }
   public static long qlist(int k,int a,int x,int b,int y){
        long mod = 1000000007;
        int max = 101;
        long[][] tri = new long[max][max];
        tri[0][0] = 1;
       for (int i = 1; i < max; i++) {
            tri[i][0] = 1;
           for (int j = 1; j <max ; j++) {
               tri[i][j] = (tri[i-1][j-1] + tri[i-1][j])%mod;
           }
       }
       long sum = 0;
       for (int i = 0; i <=k ; i++) {
           if(i % a == 0 && (k-i) % b ==0)
               sum += tri[x][i/a]*tri[y][(k-i)/b]%mod;
       }
       return sum % mod;
   }


}
