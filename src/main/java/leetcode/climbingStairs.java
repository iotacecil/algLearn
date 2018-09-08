package leetcode;

public class climbingStairs {
//Fibonacci公式
    public static int fibFormula(int n){
        double sqrt5= Math.sqrt(5);
        double fibn = Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

        public static int climbStairs(int n) {
            int[][] q = {{1, 1}, {1, 0}};
            int[][] res = pow(q, n);
            return res[0][0];
        }
        public static int[][] pow(int[][] a, int n) {
            int[][] ret = {{1, 0}, {0, 1}};
            while (n > 0) {
                System.out.println("n&1:"+n+(n&1));
                //如果n是奇数
                if ((n & 1) == 1) {
                    ret = multiply(ret, a);
                }
                n >>= 1;
                a = multiply(a, a);
            }
            return ret;
        }
        public static int[][] multiply(int[][] a, int[][] b) {
            int[][] c = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
                }
            }
            return c;
        }


//        if(n==1)return 1;
//        int[] dp = new int[n+1];
//        dp[1]=1;
//        dp[2]=2;
//        for(int i =3;i<=n;i++){
//            dp[i] = dp[i-1]+dp[i-2];
//        }
//        return dp[n];


    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibFormula(3));
    }
}
