package niuke.aiqiyi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class stacklen {
    public static void main(String[] args) {
        Deque<Character> stk = new ArrayDeque<>();
        int len = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i) == '('){
                stk.push('(');
            }
            if(str.charAt(i) == ')'){
                len = Math.max(len, stk.size());
                stk.pop();
            }
        }
        System.out.println(len);
    }
}
