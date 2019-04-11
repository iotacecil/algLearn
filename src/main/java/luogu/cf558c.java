package luogu;

import java.util.Scanner;

public class cf558c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        int[][] memo = new int[n][max+1];
        for (int i = 0; i <n ; i++) {
            int num = arr[i];
            int move = 1;
            while (num>=0){
                memo[i][num] = move;
                num>>=1;
                move++;
                if(num == 0)break;
            }
            num = arr[i];
            move = 1;
            while (num<=max){
                memo[i][num] = move;
                num<<=1;
                move++;
            }
        }

        int rst = Integer.MAX_VALUE;
        for (int i = 0; i <=max ; i++) {

            int sum = 0;
            for (int j = 0; j <n ; j++) {
                if(memo[j][i]==0){
                    sum = 0;
                    break;
                }
                sum += memo[j][i]-1;
                if(j == n-1)
                    rst = Math.min(rst, sum);

            }
        }
        System.out.println(rst);

    }
}
