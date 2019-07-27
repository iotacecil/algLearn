package niuke.wangyi;

import java.util.Scanner;

public class 藏宝图2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String pattern = sc.next();
        int i = 0;
        int j = 0;

        while (i < str.length() && j < pattern.length()) {
            if (i < str.length() && str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else i++;

        }
        if (j == pattern.length()) {
            System.out.println("Yes");

        } else {
            System.out.println("No");

        }


    }
}
