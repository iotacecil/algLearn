package niuke;

import java.util.Scanner;

public class long01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int len = s.length();
        int cnt =1;
        int maxcnt = 1;
        if(len==1) System.out.println(1);
       for(int i =0;i<s.length()-1;i++){

           if(s.charAt(i)==s.charAt(i+1)){
               cnt=1;
               continue;
           }
           else {
               cnt++;
               maxcnt=maxcnt>cnt?maxcnt:cnt;
           }

       }
        System.out.println(maxcnt);

    }
}
