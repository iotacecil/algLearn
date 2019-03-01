package niuke.pdd;

import java.util.Arrays;
import java.util.Scanner;

public class liuyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }


        int m = sc.nextInt();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = sc.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);

        int i = n-1;
        int j = m-1;
        int cnt=0;
        while (i>=0&&j>=0){
            if(h[i] <= w[j]){
                j--;
                i--;
                cnt++;
            }else{
                i--;
            }
        }
        System.out.println(cnt);
    }
}
