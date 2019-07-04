package niuke.codedance;

import java.util.Scanner;

/*

https://www.nowcoder.com/questionTerminal/448127caa21e462f9c9755589a8f2416
1 1 1 1 2 2 3 3 5 6 7 8 9
4 7
 */
public class 雀魂启动2019 {
    private static boolean check(int[] tmp) {
        for (int i = 1; i < 10; i++) {
            if (tmp[i] >= 2) {
                tmp[i] -= 2;
                if (canHu(tmp)) {
                    return true;
                }
                tmp[i] += 2;
            }

        }
        return false;
    }

    private static boolean canHu(int[] tmp) {
        for (int i = 1; i < 10; i++) {
            if (tmp[i] >= 3) {
                tmp[i] -= 3;
                if (canHu(tmp)) {
                    return true;
                }
                tmp[i] += 3;
            }

            if (tmp[i] > 0) {
                if (i + 2 < 10 && tmp[i + 1] > 0 && tmp[i + 2] > 0) {
                    tmp[i]--;
                    tmp[i + 1]--;
                    tmp[i + 2]--;
                    if (canHu(tmp)) {
                        return true;
                    }
                    tmp[i]++;
                    tmp[i + 1]++;
                    tmp[i + 2]++;
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    // 123 123 123 123 88
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[10];
        for (int i = 0; i < 13; i++) {
            int num = sc.nextInt();
            cnt[num]++;
        }

        for (int i = 1; i < 10; i++) {
            if (cnt[i] < 4) {
                int[] tmp = new int[10];
                System.arraycopy(cnt, 0, tmp, 0, 10);
                tmp[i]++;
                if (check(tmp)) {
                    System.out.print(i + " ");
                }

            }

        }
    }
}
