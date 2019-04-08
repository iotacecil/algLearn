package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc224 {
    public int calculate(String s) {

        Deque<Integer> stk = new ArrayDeque<>();
        int rst = 0;
        int num = 0;
        // 下一个数的符号
        int sign = 1;
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c-'0';
            }else if(c == '+'){
                rst += sign*num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                rst += sign*num;
                num = 0;
                sign = -1;
                // 括号开始等于开启一个新的表达式逻辑
                // 并且最后存在rst里的只有括号前的值和括号前的符号
            }else if(c == '('){
                // 先放值再放符号
                stk.push(rst);
                stk.push(sign);
                // 括号开头第一个是正的
                sign = 1;
                // 关键
                rst = 0;
            }else if(c == ')'){
                // rst是当前括号中的表达式值
                rst += sign *num;
//                System.out.println(rst);
                num = 0;
                // 括号前的符号
//                System.out.println(stk);
                rst *= stk.pop();
//                System.out.println(rst);
                // 括号前表达式的值
                rst += stk.pop();
//                System.out.println(rst);

            }
        }
        // 没有遇到符号
        if(num !=0)rst+=sign*num;
        return rst;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        lc224 sl = new lc224();
        System.out.println(sl.calculate(s));
    }
}
