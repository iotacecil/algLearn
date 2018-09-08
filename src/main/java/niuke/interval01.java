package niuke;

import java.util.Scanner;

public class interval01 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            int maxLen = 1;
            int len = 1;
            for (int i = 1; i < str.length() ; i++) {
               if(str.charAt(i-1)!=str.charAt(i)){
                   len++;
                   maxLen = Math.max(len,maxLen );
               }else{
                   len = 1;
               }

            }
            System.out.println(maxLen);
        }
    }
}
