package luogu;

import java.util.Arrays;
import java.util.Scanner;
/*

小A有n枚硬币，现在要买一样不超过m元的商品，他不想得到找钱（多脏啊），
同时又不想带太多的硬币，且硬币可以重复，
现在已知这n枚硬币的价值，请问最少需要多少硬币就能组合成所有可能的价格？
 */
public class p2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i <n ; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);
        if(coins[0]!=1) System.out.println("No answer!!!");
        int sum = 2;
        int cnt = 1;
        while (sum<=m){
            for(int i = n-1;i>=0;i--){
                if(coins[i] <= sum+1)break;
            }
            sum+=coins[cnt++]+1;
        }
        if(sum <= m)
        System.out.println(cnt);
        else
            System.out.println("No answer!!!");
    }
}
