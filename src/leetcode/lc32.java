package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc32 {
//    public int longestValidParentheses(String s) {
//        int max = 0;
//        int[] dp = new int[s.length()];
//        for (int i = 1; i < s.length() ; i++) {
//            if(s.charAt(i)==')'){
//                if(s.charAt(i-1)=='('){
//                    //（）（）
//                    dp[i] = (i>=2?dp[i-2]:0)+2;
//                    //（）（ dp[1]=2
//                    //())) i=3,dp[i-1]=0 ()))(
//                    //dp[3]=dp[2]+
//                }else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]+1)=='('){
//                    dp[i] = dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
//                }
//            }
//
//
//        }

    public int longestValidParentheses(String s) {
        int maxns = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i <s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                System.out.println(stack.pop());

                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxns = Math.max(maxns,i-stack.peek());
                }
            }

        }
        return maxns;
//        int left=0,right=0,maxlen=0;
//        for(int i =0;i<s.length();i++){
//            if(s.charAt(i)=='('){
//                left++;
//            }else{
//                right++;
//            }
//            if(left==right){
//                maxlen = Math.max(maxlen,2*right);
//            }else if(right>left){
//                right=left=0;
//            }
//        }
//        left=right=0;
//        for(int i =s.length()-1;i>=0;i--){
//            if(s.charAt(i)=='('){
//                left++;
//            }else{
//                right++;
//            }
//            if(left==right){
//                maxlen = Math.max(maxlen,2*right);
//            }else if(left>right){
//                right=left=0;
//            }
//        }
//        return maxlen;

    }

    public static void main(String[] args) {
        lc32 sl = new lc32();
        System.out.println(sl.longestValidParentheses("()"));
    }
}
