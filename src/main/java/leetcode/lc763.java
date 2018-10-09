package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc763 {
    //45%
    public List<Integer> partitionLabels(String S) {
        List<Integer> rst = new ArrayList<>();
        //每个字母最后出现的index
        int[] last = new int[26];

        for(int i=0;i<S.length();i++){
          last[S.charAt(i)-'a'] = i;
        }
        int start=0,end=0;
        for(int i = 0;i<S.length();i++){
            //更新当前字母的区间
            end = Math.max(end,last[S.charAt(i)-'a']);
            if(i==end){
                rst.add(end-start+1);
                start = end+1;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        lc763 sl = new lc763();
        System.out.println(sl.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
