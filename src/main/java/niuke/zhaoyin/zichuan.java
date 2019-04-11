package niuke.zhaoyin;

import java.util.Scanner;

public class zichuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean notfound = true;
            int n = s.length();
            // abab len = 4 len = 2
            for(int len = n/2;len>0;len--){
                if(n%len == 0){
                    String tmp =  s.substring(0,len);
                    String rst = tmp;
                    // i<2
                    for(int i = 0;i<(n/len)-1;i++){
                        rst+= tmp;
                    }
                    if(rst.equals(s)) {
                        System.out.println(tmp);
                        notfound = false;
                        break;
                    }
                }
            }
            if(notfound)
        System.out.println("false");
        }

    }

