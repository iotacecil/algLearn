package niuke.wangyi;

import java.util.Scanner;

/*
小易有一个长度为n的整数序列,a_1,...,a_n。
然后考虑在一个空序列b上进行n次以下操作:
1 2 -> 21
213 -> 312
3124 -> 4213

 1 -> 1
1 2 -> 2 1

 */
public class 操作序列2018 {
    public static void reverse(int[] arr, int r) {
        int s = 0;
        while (s < r) {
            int tmp = arr[s];
            arr[s] = arr[r];
            arr[r] = tmp;
            s++;
            r--;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] b = new int[n];
        int s = 0;
        int e = n - 1;
        int i = n - 1;
        while (s <= e && i >= 0) {

            b[s++] = arr[i--];
            if (s <= e && i >= 0)
                b[e--] = arr[i--];


        }

        for (i = 0; i < n; i++) {
            if (i == n - 1) System.out.print(b[i]);
            else System.out.print(b[i] + " ");

        }


    }
}
