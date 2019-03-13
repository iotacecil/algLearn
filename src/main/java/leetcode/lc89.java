package leetcode;

import java.util.*;

public class lc89 {
    int num = 0;
    public List<Integer> grayCodeBack(int n) {
        List<Integer> rst = new ArrayList<>();
        backtrack(rst, n );
        return rst;
    }

    private void backtrack(List<Integer> rst,int n){
        if(n ==0){
            rst.add(num );
            return;
        }
       else{
            backtrack(rst, n-1);
            num ^= (1<< n-1);
            backtrack(rst, n-1);
        }
    }

    public List<Integer> grayCode(int n) {
        int tmp = 0;
        List<Integer> rst = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<n;i++){
            rst.add(tmp);
            set.add(tmp);
            tmp|=(1<<i);
        }

        for(int i =0;i<n;i++){
            tmp^=(1<<i);
            if(!set.contains(tmp))
                rst.add(tmp);
        }
        return rst;
    }

    public static void main(String[] args) {
        lc89 sl = new lc89();
        System.out.println(sl.grayCodeBack(3));
    }
}
