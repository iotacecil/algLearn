package niuke.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class shuzi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] split = sc.next().split("");
            Arrays.sort(split);
            StringBuilder sb = new StringBuilder();
            for(String s:split){
                sb.append(s);
            }
            Integer integer = Integer.valueOf(sb.toString());
            max = Math.max(max, integer);
        }
        System.out.println(max);
    }
}
