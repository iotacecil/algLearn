package courseBook.acmbook;

import java.util.Arrays;

public class p199 {
    /**
     * 求fib第n项对10^4 mod后的结果
     * 需要用到 快速幂运算
     * @param n
     * @return
     */


    final int M = 10000;
    public int[][] mul(int[][] A,int[][] B){
        int[][] rst = new int[A.length][B[0].length];
        for (int i = 0; i <A.length ; i++) {
            for (int k = 0; k <B.length ; k++) {
                for (int j = 0; j <B[0].length ; j++) {
                    rst[i][j] = (rst[i][j]+A[i][k]*B[k][j])%M;
                }
            }
        }
        return rst;
    }
    public  int[][] pow(int[][] A,int n){
        int[][] rst =new int[A.length][A.length];
        for (int i = 0; i <A.length ; i++) {
            rst[i][i] = 1;
        }
        while (n>0){
            System.out.println(Integer.toBinaryString(n));
            if((n&1)!=0){
                rst = mul(rst,A );
                System.out.println("乘A");
            }

            A = mul(A, A);
            System.out.println("翻倍");
            n>>=1;
        }
        return rst;
    }
//    static int memo[] ;
//    static int fib(int n){
//
//        if(n==0||n==1)return n;
//        if(memo[n] == -1)memo[n] = fib(n-1)+fib(n-2);
//        return memo[n];
//    }
    public static void main(String[] args) {
        int n = 5;
//        memo= new int[5];
//        Arrays.fill(memo,-1 );
        int[][] A = {{1,1},{1,0}};
        p199 sl = new p199();
        long start = System.currentTimeMillis();
        int[][] rst = sl.pow(A, n);
        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-start));
//        System.out.println(rst[1][0]);
        start = System.currentTimeMillis();
//        sl.fib(n);
        end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println();
//        System.out.println(Arrays.deepToString(sl.mul(A, A)));
//        System.out.println(Arrays.deepToString(sl.pow(A, 2)));
//        int[][] B = {{1},{0}};
    }
}
