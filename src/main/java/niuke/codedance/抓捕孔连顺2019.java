package niuke.codedance;
/*
. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
 */
/*
        9 33332
        7 8 12 14 26 29 31 33 35
        */
//

import java.util.Arrays;
import java.util.Scanner;

public class 抓捕孔连顺2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] bd = new int[N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int wz = sc.nextInt();
            if (idx > 0 && wz == bd[idx - 1]) continue;
            bd[idx++] = wz;
        }
        N = idx;
        long mod = 99997867;
        // 1 2 3 4
        //[3,2,1,0] 右边有多少个在D 范围里的数字
        int[] right = new int[N];
        int i = 0;
        int j = i + 2;
        while (i < N) {
            while (j < N && bd[j] <= bd[i] + D) j++;
            right[i] = j - 1 - i;
            i++;

        }
        System.out.println(Arrays.toString(right));
//        Arrays.sort(bd);
        //1+3 <=4 ok 1->2,3,4 n = 3 3*2/2=3
        //2+3 <=5 ok 2->3,4  n = 2  c22->
        //1 2 3 4 i = 0 j= 5
        long rst = 0;
        for (int cnt : right) {
            if (cnt >= 2)
                rst += (cnt * (cnt - 1) / 2 % mod);
        }


        System.out.println(rst);

    }
}
