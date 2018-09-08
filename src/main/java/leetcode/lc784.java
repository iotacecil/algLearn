package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc784 {
    List<String> rst = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(S,0,"");
        return rst;
    }
    private void dfs(String s,int idx,String cur){
        if(idx==s.length()){
            rst.add(cur);
            return;
        }
        char idxchar = s.charAt(idx);
//        System.out.println((char)(idxchar ^ (1 << 5)));

//        System.out.println(idxchar);
//        System.out.println(idxchar-'a');
        System.out.println(Integer.toBinaryString(idxchar));
        System.out.println(Integer.toBinaryString((1<<5)));
        if(idxchar-'0'>=0&&idxchar-'0'<=9){
            dfs(s,idx+1,cur+idxchar);
        }else if(idxchar-'A'>=0&&idxchar-'A'<26){
            dfs(s,idx+1,cur+idxchar);
            dfs(s,idx+1,cur+(char)(idxchar^ (1 << 5)));
        }else if(idxchar-'a'>=0&&idxchar-'a'<26){
            dfs(s,idx+1,cur+idxchar);
            System.out.println((idxchar+'A'-'a'));
            System.out.println(idxchar);
            dfs(s,idx+1,cur+(char)(idxchar^ (1 << 5)));
        }

    }
    public static void main(String[] args) {
        lc784 sl = new lc784();
        System.out.println(sl.letterCasePermutation("a1b2"));
//        char a = 'B';
//        char b = '9';
//        System.out.println((char)(a+'A'-'a'));
//        System.out.println((char)(a+'a'-'A'));
//        System.out.println(b-'0');
    }
}
