package niuke.tecent;

import java.util.Scanner;

public class 小Q的排序 {
    //12346 5 ->
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (arr[0] == min || arr[n - 1] == max) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }


    }
}
