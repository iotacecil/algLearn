package leetcode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class lc22 {
//    public List<String> generateParenthesis(int n) {
//
//    }
//    private void dfs(int n,String tmp,List<String> rst,int idx,int left){
//        if(idx == n){
//            rst.add(tmp );
//        }
//        // (()  left = 2 idx = 2 ((
//        for (int i = 0; i < n; i++) {
//            if()
//
//        }
//
//    }
public static void main(String[] args) throws UnsupportedEncodingException {
    String str = "华1a2B";

    //gbk汉字对应两个字节
    byte[] gbks = str.getBytes("gbk");
    System.out.println(Arrays.toString(gbks));
    System.out.println(str.substring(0, 2));
}
}
