package niuke.jd;

import java.util.Scanner;

public class 还原2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//3 0 1  ->i<=3&&1>=i&&3<=i
        //3 0 0 1 i>=3  i<=max(3,j)|j<=i j<=max(1,i)
//        for (int i = 0; i <n ; i++) {
//            if(arr[i]==0)
//
//        }
    }
}
