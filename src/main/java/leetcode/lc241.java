package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc241 {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> rst = new ArrayList<>();
        boolean isNumber = true;
        for(int i =0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                isNumber = false;
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for(int x:left){
                    for(int y:right){
                        if(c=='-'){
                            rst.add(x-y);
                        }else if(c=='+'){
                            rst.add(x+y);
                        }else if(c=='*'){
                            rst.add(x*y);
                        }
                    }
                }
            }
        }
        if(isNumber)rst.add(Integer.valueOf(input));
        return rst;

    }

    public static void main(String[] args) {
        diffWaysToCompute("2*3-4*5");

    }
}
