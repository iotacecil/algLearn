package niuke.pdd;

import java.util.Scanner;

public class 美妙的约会2019 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < 2 * n; i += 2) {
            if (arr[i + 1] == arr[i]) continue;
            for (int j = i + 1; j < 2 * n; j++) {
                if (arr[j] == arr[i]) {
//                    System.out.println(j);

                    cnt += (j - i - 1);
                    int tmp = arr[j];
                    //k=4  k>0
                    for (int k = j; k > i; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[i + 1] = tmp;
                }

            }
        }

        System.out.println(cnt);
    }
}
