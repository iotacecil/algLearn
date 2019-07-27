package niuke.jd;

import java.util.Scanner;

/*
含有连续两个s作为子串的最短字符串。
 注意两个s可能有重叠部分。例如,"ababa"含有两个"aba".
 abracad abra
         abra cadabra

  a a -> aa
  aba
    aba ->ababa
 */
public class 两个子串2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        int over = len - 1;
        // if  aa == aa -> aaa
        boolean find = false;
        while (over > 0) {
            if (str.substring(0, over).equals(str.substring(len - over, len))) {
                System.out.println(str + str.substring(over, len));
                find = true;
                break;
            }
            over--;
        }
        if (!find) {
            System.out.println(str + str);
        }

    }
}
