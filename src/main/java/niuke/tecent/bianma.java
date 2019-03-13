package niuke.tecent;

import java.util.LinkedList;
import java.util.Scanner;

public class bianma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        int rst = 0;
        if(n>0)
            rst += (str.charAt(0)-'a')*(25*25*25+25*25+25+1);
        if(n>1)
            rst += (str.charAt(1)-'a')*(25*25+25+1)+1;
        if(n>2)
            rst += (str.charAt(2)-'a')*(25+1)+1;
        if(n>3)
            rst += (str.charAt(2)-'a')+1;
        LinkedList<Integer> list = new LinkedList<>();
        
        System.out.println(rst);
    }
}










































