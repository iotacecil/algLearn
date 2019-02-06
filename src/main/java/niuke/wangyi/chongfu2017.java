package niuke.wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class chongfu2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        int[] rst = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (!set.contains(arr[i])) {
                rst[cnt++] = arr[i];
                set.add(arr[i]);
            }
        }

        for (int i = cnt - 1; i >= 0; i--) {

            System.out.print(rst[i]);

            if (i != 0) System.out.print(" ");

        }
    }
}
