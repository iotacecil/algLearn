package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class routeNumber {
    //AC
//    final static int M = 10000;
    public static long[][] mul(long[][] A,long[][] B){
        long[][] rst = new long[A.length][B[0].length];
        for (int i = 0; i <A.length ; i++) {
            for (int k = 0; k <B.length ; k++) {
                for (int j = 0; j <B[0].length ; j++) {
                    rst[i][j] = (rst[i][j]+A[i][k]*B[k][j]);
                }
            }
        }
        return rst;
    }
    public static long[][] pow(long[][] A,int n){
        long[][] rst =new long[A.length][A.length];
        for (int i = 0; i <A.length ; i++) {
            rst[i][i] = 1;
        }
        while (n>0){
            if((n&1)!=0){
                rst = mul(rst,A );
            }

            A = mul(A, A);
            n>>=1;
        }
        return rst;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] graph = new long[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        long[][] Gn = pow(graph, k);
        System.out.println(Gn[0][n-1]);


    }
}
