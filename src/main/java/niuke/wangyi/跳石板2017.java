package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/*
当前处在编号为N的石板，他想跳到编号恰好为M的石板去

对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，
即跳到K+X(X为K的一个非1和本身的约数)的位置。
4->6->9->12->18->24+
 */
public class 跳石板2017 {

    //dp[i]steps[i]表示到达i号石板所需的最小步数。初始化为steps容器为INT_MAX。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i = n; i <= m; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    if (i + j <= m)
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    if (i + i / j <= m)
                        dp[i + i / j] = Math.min(dp[i + i / j], dp[i] + 1);
                }
            }
        }
        if (dp[m] == Integer.MAX_VALUE) System.out.println(-1);
        else
            System.out.println(dp[m]);

//        int cnt = 1;
//        int cur = n;
//        int ys = 0;
//        int curfar = cur+yueshu(cur);
//        int far = cur+yueshu(cur);
//        int idx = cur;
////curfar = 6 // far = 6
//
//        while (cur<m) {
//            // 6
//            curfar = Math.max(curfar,idx+yueshu(idx));
//            System.out.println(cur);
//            if(curfar>=m){
//                cnt++;
//                break;
//            }
//            idx++;
//            if(idx==m-1||cur>=far){
//                cur = far;
//                far = curfar;
//                cnt++;
//            }
//          //  System.out.println(cur);
//        }
//        System.out.println(cnt);


    }
}
