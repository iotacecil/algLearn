package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> rst = new ArrayList<>();
        int[] last = new int[26];

        for(int i=0;i<S.length();i++){
          last[S.charAt(i)-'a'] = i;
        }
        int start,end;
        return rst;
    }

    public static void main(String[] args) {
        lc763 sl = new lc763();
        System.out.println(sl.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
