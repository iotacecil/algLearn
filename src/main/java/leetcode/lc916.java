package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc916 {
    /**
     * B都是A的子集 应该改count的
     * @param A
     * @param B
     * @return
     */
    public List<String> wordSubsets(String[] A, String[] B) {
        int n = A.length;
        int m = B.length;
        List<String> rst = new ArrayList<>();
        t:
        for(int i = 0;i< n ;i++){
            String tmp = A[i];

            int bi = 0;
            while( bi < m){
                int next = tmp.indexOf(B[bi]);
                if(next < 0)continue t;
                tmp = tmp.substring(0,next);
                bi++;
            }
            if(bi == m)rst.add(A[i]);
        }
        return rst;
    }

    public static void main(String[] args) {

        String[] A = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] B = new String[]{"lo","eo"};
        lc916 sl = new lc916();
        System.out.println(sl.wordSubsets(A, B));
    }
}
