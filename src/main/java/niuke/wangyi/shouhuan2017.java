package niuke.wangyi;

import java.util.Scanner;

/*
3 2
1 2 3

+2 +1+2 +1




3 5 4
8 9 7


 */
public class shouhuan2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < k; i++) {
            int first = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = (arr[j] + arr[j + 1]) % 100;
            }
            arr[n - 1] = (arr[n - 1] + first) % 100;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i != n - 1)
                System.out.print(" ");

        }
    }
}
