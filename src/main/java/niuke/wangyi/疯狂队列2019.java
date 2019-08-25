package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class 疯狂队列2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        Arrays.sort(h);
        int dif = h[n - 1] - h[0];
        int min = h[0];
        int max = h[n - 1];
        int left = 1;
        int right = n - 2;
        while (left < right) {
            dif += h[right] - min;
            dif += max - h[left];
            min = h[left];
            max = h[right];
            left++;
            right--;
//            System.out.println(h[n-1-i]-h[i]);
        }
        //04  1 3
        //n=5  [2]
        dif += Math.max(h[right] - min, max - h[left]);
        System.out.println(dif);
    }
}
