package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class 塔right {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        Arrays.sort(a);
        for (int i = 0; i < k; i++) {
            a[0] = a[0] + 1;
            a[n - 1] = a[n - 1] - 1;
            Arrays.sort(a);
        }
        System.out.println(a[n - 1] - a[0] + " " + k);

    }
}
