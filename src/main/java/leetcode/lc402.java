package leetcode;/*
Input: num = "1432219", k = 3
Output: "1219"

Input: num = "10200", k = 1
Output: "200"
 */

public class lc402 {
    public String remove(String num,int k){
        int digits = num.length()-k;
        char[] stack = new char[num.length()];
        System.out.println(stack);
        int top =0;
        for (int i = 0; i <num.length() ; i++) {
            char c = num.charAt(i);
            while(top>0&&stack[top-1]>c&&k>0){
                top-=1;
                k-=1;

            }
            System.out.println(c);
            stack[top++] = c;
        }
        //1002->002
        System.out.println(stack.length);
        System.out.println((int)stack[stack.length-1]);
        int idx = 0;
        while(idx<digits&&stack[idx]=='0')idx++;
        //去掉前面的0
        return idx==digits?"0": new String(stack,idx,digits-idx);

    }

    public static void main(String[] args) {
        lc402 sl = new lc402();
        System.out.println(sl.remove("10200", 1));
    }
}
