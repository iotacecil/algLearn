package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;
/*


36
7 -15 31 49 -44 35 44 -47 -23 15 -11 10 -21 10 -13 0 -20 -36 22 -13 -39 -39 -31 -13 -27 -43 -6 40 5 -47 35 -8 24 -31 -24 -1
3 31


47
-41 -5 -10 -31 -44 -16 -3 -33 -34 -35 -44 -44 -25 -48 -16 -32 -37 -8 -33 -30 -6 -18 -26 -37 -40 -30 -50 -32 -5 -41 -32 -12 -33 -22 -14 -34 -1 -41 -45 -8 -39 -27 -23 -45 -10 -50 -34
6 3
 */
//AC
//https://www.nowcoder.com/questionTerminal/661c49118ca241909add3a11c96408c8
// 相邻两个学生的位置编号不相差超过d
public class hechangturan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();
        long res = maxability(n, arr, k, d);
        System.out.println(res);
    }
    public static long maxability(int n,long[]arr,int k,int d){
        long[][] fmax = new long[k+1][n];
        long[][] fmin = new long[k+1][n];
        long res = Integer.MIN_VALUE;
        fmax[1] = arr.clone();
        fmin[1] = arr.clone();
          //选2-k个人
            for (int j = 2; j <=k ; j++) {
                for (int i = 0; i <n ; i++) {
                // 遍历上次层结果的[i-d,i)
                for (int l = i-1; l>=0&&l>=i-d ; l--) {
                    // 前面以l结尾的最大和最小
                    fmax[j][i] = Math.max(fmax[j][i],Math.max(fmax[j-1][l]*arr[i],fmin[j-1][l]*arr[i]) );
                    fmin[j][i] = Math.min(fmin[j][i],Math.min(fmax[j-1][l]*arr[i],fmin[j-1][l]*arr[i]) );
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            res = Math.max(res, fmax[k][i]);
        }
        return res;
    }
}
