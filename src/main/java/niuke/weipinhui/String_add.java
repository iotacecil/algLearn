package niuke.weipinhui;

import java.util.Scanner;

//输入两个字符串，如"1101", "1100"
//"11001"
//求两个字符串相加的结果，加法计算方法以二进制方式计算，并返回对应的字符串结果。
public class String_add
{
    static int id;


    public String add(String a, String b){
        int aa = Integer.parseInt(a, 2);
        int bb = Integer.parseInt(b, 2);

        return Integer.toBinaryString(aa+bb);


    }

    public static void main(String[] args) {
        String_add sl = new String_add();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(sl.add(s1, s2));
    }
}
