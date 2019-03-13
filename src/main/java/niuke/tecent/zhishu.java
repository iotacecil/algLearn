package niuke.tecent;

import java.util.Arrays;
import java.util.Scanner;

public class zhishu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean[] prime = new boolean[num+1];
        Arrays.fill(prime, true);
        for(int i = 2; i <= num; i++){
            if(prime[i]){
                // 将i的2倍、3倍、4倍...都标记为非素数
                for(int j = i * 2; j <= num; j =  j + i){
                    prime[j] = false;
                }
            }
        }
        // 11 -》5
        int cnt = 0;
        for(int i = 2;i<=num/2;i++){
                if(prime[i] && prime[num-i])cnt++;
        }
        System.out.println(cnt);
    }
}
