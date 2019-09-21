package niuke.didi;

import java.util.Scanner;

// 连续子串和
public class 给定整数序列求连续子串最大和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int n = strs.length;
        int max = Integer.parseInt(strs[0]);
        int rst = Integer.parseInt(strs[0]);
        //-23  17 -7
        // 0   17 10
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(strs[i]);
            max = Math.max(max + num, num);

            rst = Math.max(max, rst);
//            System.out.println(max + " "+rst);
        }
        System.out.println(rst);
    }
}
