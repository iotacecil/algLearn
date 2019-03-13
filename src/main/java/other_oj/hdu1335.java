package other_oj;

import java.util.Scanner;

public class hdu1335 {
    static String convert(String str,int base,int r){
        StringBuilder sb = new StringBuilder();
        String hexs = "0123456789ABCDEF";
        int n = str.length()-1;
        int tmp = 0;
        int idx = 0;
        while (n >= 0){
            tmp += char2int(str.charAt(n--))*((int)Math.pow(base,idx++ ));
            while (tmp >= r) {
                sb.append(tmp % r);
                tmp /= r;
            }
        }
        return sb.reverse().toString();
    }
    static int char2int(char c){
        if(c >='0'&& c<='9')return c-'0';
        else if(c >='A' && c<='F')return c-'A';
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(convert(sc.next(), sc.nextInt(), sc.nextInt()));
        }
    }
}
