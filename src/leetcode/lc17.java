package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
//回溯法
public class lc17 {

    //DFS 边是对应的字母 结点是数字
    //状态变量l当前求解多少位,cur当前的拼接，最后的结果
    static String[] phone = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    public static List<String> lf(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null||digits.length()==0){
            return res;
        }
        dfs(res,digits,"",0);
        return res;
    }
        private static void dfs(List<String> res,String digit,String s,int index){
        if(index == digit.length()){
            //3. 直到没有数字
            res.add(s);
            return;
        }
        //1.拿到第i位的字母
        String letters = phone[digit.charAt(index)-'2'];
        for(char end :letters.toCharArray()){
            //2.添加1位
//            s+=end;
            dfs(res,digit,s+end,index+1);
//            s=s.substring(0,s.length()-1);
        }
    }
        //BFS n个滚动数组
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();//i位的解
        ans.add("");
        for(char dig :digits.toCharArray()){
            //i+1位的解
            List<String> tmp=new ArrayList<>();
            for(String s:ans) {
                for (char c : phone[dig - '2'].toCharArray()) {
                    //对2对应的[a,b,c]每个字母后面追加3对应的[d],[e],[f]
                    tmp.add(s+c);
                }
            }
            ans=tmp;
        }
        return ans;
    }
    public static List<String> ana(String digits){
        Deque<String> res = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        if(digits==null||digits.length()==0){

            return list;
        }
        res.add("");
        for(char dig :digits.toCharArray()) {
            while (!res.isEmpty()) {
                String t = res.remove();
                for (char s : phone[dig - '2'].toCharArray()) {
                    res.add(t + s);
                }
            }
        }
        List l = (List)res;
        return l;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
        System.out.println(lf("234"));


    }


}
