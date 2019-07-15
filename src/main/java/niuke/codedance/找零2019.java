package niuke.codedance;

import java.util.Scanner;

/*
链接：https://www.nowcoder.com/questionTerminal/944e5ca0ea88471fbfa73061ebe95728?orderByHotValue=0&mutiTagIds=134_665&page=1&onlyReference=false
来源：牛客网

Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为
N(0<N≤1024)的商品，请问最少他会收到多少硬币？
输入
200
输出
17
说明
花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。
 */
public class 找零2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        N = 1024-N;
        int cnt = 0;
        int[] coint = {64,16,4,1};
        int idx = 0;
        while (N>0){
            int tmp = N/coint[idx];
//            System.out.println(N);
            cnt += tmp;
            N -= tmp * coint[idx];
            idx++;
        }
        System.out.println(cnt);
    }
}
