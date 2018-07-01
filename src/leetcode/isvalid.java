package leetcode;

import java.util.Hashtable;
import java.util.Map;

class Solution4 {
    public boolean isValid(String s) {
//        Map<Character,Character> map = new Hashtable<>();
//        map.put('{','}');
        int len = s.length();

        char[] stack =new char[len];
        int top=0;
        for(int i =0;i<len;i++){
           if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('){
               stack[top]=s.charAt(i);
               top++;



           }else if(top>0&&((s.charAt(i)=='}'&&(stack[top-1]=='{'))||
                   (s.charAt(i)==')'&&(stack[top-1]=='('))||
                   (s.charAt(i)==']'&&(stack[top-1]=='[')))){

               top--;


           }else {
               stack[top]=s.charAt(i);
               top++;
           }

        }
        if(top!=0||s.charAt(0)==']'||s.charAt(0)==')'||s.charAt(0)=='}')return false;

        return true;
    }
}
public class isvalid {
    public static void main(String[] args){
        String a="(])";
        String b="[}";
        String c="[]";
        Solution4 sl = new Solution4();
        System.out.println(sl.isValid(a));
        System.out.println(sl.isValid(b));
        System.out.println(sl.isValid(c));

    }
}
