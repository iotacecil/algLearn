package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc916 {
    /**
     * B都是A的子集
     * @param A
     * @param B
     * @return
     */
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b:B) {
            int[] bCount = count(b);
            for (int i = 0; i <26 ; i++) {
                bmax[i] = Math.max(bmax[i],bCount[i]);
            }
        }
        System.out.println(Arrays.toString(bmax));
        List<String>res = new ArrayList<>();
        search: for(String a:A){
            int[] aCount = count(a);
            for (int i = 0; i < 26; i++) {
                if(aCount[i]<bmax[i])continue search;
            }
            res.add(a);
        }
        return res;
    }
    private int[] count(String S){
        int[] ans = new int[26];
        for(char c:S.toCharArray()){
            ans[c-'a']++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] B = new String[]{"e","o"};
        lc916 sl = new lc916();
        System.out.println(sl.wordSubsets(A, B));
    }
}
