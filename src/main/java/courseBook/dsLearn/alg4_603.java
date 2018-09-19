package courseBook.dsLearn;

import com.sun.javafx.collections.NonIterableChange;

public class alg4_603 {
    /**
     * 后缀数组
     */

    /**
     * 最长公共前缀 暴力
     * @param s
     * @param t
     * @return
     */
    private static int lcp(String s,String t){
        int N = Math.min(s.length(),t.length() );
        for (int i = 0; i <N ; i++) {
            if(s.charAt(i)!=t.charAt(i))return i;
        }
        return N;
    }
    //最长重复子串

    public static void main(String[] args) {

        System.out.println(lcp("acctgttaac", "accgttaa"));
    }
}
