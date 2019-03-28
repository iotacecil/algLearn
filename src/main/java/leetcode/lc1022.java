package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lc1022 {
    /// 11111    2 x 4 x 5 x 6 7ok 9 11 111 11111
    public int smallestRepunitDivByK(int K) {
        if(K == 1)return 1;
        if(K%2 == 0 || K%5 == 0 )return -1;
        Set<Integer> set = new HashSet<>();
        int n = 1;
        int len  = 1;
//        set.add(n%K);
        while (true){
            n = (n*10+1)%K;
            if(set.contains(n))return -1;
            len++;
//            if(n<K)continue;
//            if(set.contains(n%K))return -1;
            if(n ==0)return len;
            else set.add(n);
        }

    }

    public static void main(String[] args) {
        lc1022 sl = new lc1022();
        System.out.println(sl.smallestRepunitDivByK(3));
    }
}
