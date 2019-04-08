package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc20 {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!stk.isEmpty()&& ((stk.peek() == '{' && c == '}') ||
                    (stk.peek() == '[' && c == ']') ||
                    (stk.peek() == '(' && c == ')'))){

                    stk.pop();
            }else{
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        lc20 sl = new lc20();
        System.out.println(sl.isValid("([}"));
    }
}
