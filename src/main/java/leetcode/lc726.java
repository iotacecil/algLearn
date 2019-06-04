package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class lc726 {
//    public String countOfAtoms2(String formula) {
//        Map<String,Integer> cnts = new HashMap<>();
//        Deque<String> stk = new ArrayDeque<>();
//        int n = formula.length();
//        int idx = 0;
//        while(idx<n){
//            char c = formula.charAt(idx);idx++;
//            if(c == '(')stk.push();
//        }
//    }
    public String countOfAtoms(String formula) {
        Map<String,Integer> cnts = new HashMap<>();
        Deque<String> stk = new ArrayDeque<>();
        int n = formula.length();
        int idx = 0;
        while(idx<n){
            String tmp = "";
            if(formula.charAt(idx) >='A' && formula.charAt(idx) <='Z'){
                tmp += formula.charAt(idx++);
            }
            if(idx < n&& formula.charAt(idx) >='a' && formula.charAt(idx) <='z'){
                tmp += formula.charAt(idx++);
            }
            int num = 0;
            while(idx <n && formula.charAt(idx) >= '0' && formula.charAt(idx) <= '9'){
                num *=10;
                num+=(formula.charAt(idx++)-'0');
            }
            System.out.println(tmp+" "+num);
            if(idx <n && (formula.charAt(idx) == '(' || formula.charAt(idx) ==')' )){
                stk.push(formula.charAt(idx)+"");

                idx++;

            }
            if(idx <=n && tmp.length() >0){
                if(!cnts.containsKey(tmp)){
                    cnts.put(tmp,0);
                }
                cnts.put(tmp,cnts.get(tmp)+num);
            }
            if(tmp.length() >0 )stk.push(tmp);
            if(idx <= n && stk.peek().equals(")")){
                while(!stk.isEmpty() && stk.peek().equals("(")){
                    String top = stk.pop();
                    if(!cnts.containsKey(top)){
                        cnts.put(top,0);
                    }
                    cnts.put(top,cnts.get(top)+num);
                }
            }
        }
        return cnts.toString();
    }

    public static void main(String[] args) {
        lc726 sl = new lc726();
        System.out.println(sl.countOfAtoms("Mg(OH)2"));
    }

}
