package niuke.pdd;

import java.util.Scanner;

public class 美妙的约会2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0;
//        int right = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) left++;
                // if(arr[i]<arr[j])right++;

            }

        }
//        for (int i = n-1; i >=1 ; i--) {
//            for (int j = i-1; j >=0 ; j--) {
//                if(arr[i]<arr[j])right++;
//                // if(arr[i]<arr[j])right++;
//
//            }
//
//        }

//        System.out.println(left+right);
//        System.out.println(Math.min(left,right));
        System.out.println(left);
    }
}
