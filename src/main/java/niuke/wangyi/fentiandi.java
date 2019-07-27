package niuke.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.nowcoder.com/questionTerminal/fe30a13b5fb84b339cb6cb3f70dca699
//得这16部分中value最小的那个尽可能的大
//分割田地的方法是横竖各切三刀，分成 16 份
/*
4 4
3332
3233
3332
2323
对于一个值，怎么判断能不能横竖切三刀，使16块的value都大于等于k呢
 */
public class fentiandi {
//
private static int cal(int[][] dp, int x1, int y1, int x2, int y2) {
    return dp[x2][y2] - dp[x1][y2] - dp[x2][y1] + dp[x1][y1];
}

    public static boolean valid(int[][] dp, int mid) {
        int n = dp.length - 1;
        int m = dp[0].length - 1;
        for (int i = 1; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int cut = 0;
//[0-i) [i,j) [j,k) [k-n)
                    // int i0 =0, i1=0,i2=0,i3=0;
                    int y1 = 0;
                    for (int l = 1; l <= m; l++) {
                        int i0 = cal(dp, 0, y1, i, l);
                        int i1 = cal(dp, i, y1, j, l);
                        int i2 = cal(dp, j, y1, k, l);
                        int i3 = cal(dp, k, y1, n, l);
//                        for (int o = 0; o <i ; o++) {

//                            i0+=graph[o][l];
//                        }
//                        for (int o = i; o <j ; o++) {
//                            i1+=graph[o][l];
//                        } for (int o = j; o <k ; o++) {
//                            i2+=graph[o][l];
//                        }for (int o = k; o <n ; o++) {
//                            i3+=graph[o][l];
//                        }
//    >| > | > | >|
                        if (i0 >= mid && i1 >= mid && i2 >= mid && i3 >= mid) {
                            cut++;
                            if (cut >= 4) return true;

                            y1 = l;
                        }
                    }


                }

            }

        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int sum = 0;
        int[][] graph = new int[n][m];

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (int j = 0; j < m; j++) {
                int score = s.charAt(j) - '0';
                graph[i][j] = score;
                sum += score;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + graph[i - 1][j - 1] - dp[i - 1][j - 1];
            }

        }


        int l = 0;
        int h = sum;
        //0 1 ->mid = 0 ok->l = 1,h=1 mid = 1 no h=1
        while (l <= h) {
            int mid = (l + h) / 2;

            // mid =2 true
            if (valid(dp, mid)) {
                l = mid + 1;
            } else h = mid - 1;


            //flase -> h = 3
        }

        System.out.println(l - 1);

/*
4 4
3332
3233
3332
2323
 */


    }


}
