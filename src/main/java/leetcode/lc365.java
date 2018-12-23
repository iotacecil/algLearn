package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class lc365 {
    //poj  是6次 但是最小公倍数只是4次(是不是只要+2?)
    public boolean canMeasureWaterGCD(int x, int y, int z) {
        if(z == 0)return true;
        if(x == 0 && y != z)return false;
        if(y == 0 && x != z)return false;
        if(x + y < z)return false;

        if(z % gcd(x,y) == 0){
            System.out.println(gcd(x,y));
            System.out.println(z/gcd(x,y ));
            return true;
        }else{
            return false;
        }
    }
    public static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
    public boolean canMeasureWaterBFS(int x, int y, int z) {
        if(z == 0)return true;
        if(x + y < z)return false;
        int total = x+y;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()){
            int n = q.poll();
            if(n + x <= total && set.add(n + x)){
                q.offer(n + x);
            }
            if(n + y <= total && set.add(n + y)){
                q.offer(n + y);
            }
            if(n - x >=0 && set.add(n -x)){
                q.offer(n-x);
            }
            if(n -y >=0 &&set.add(n - y)){
                q.offer(n - y);
            }
            if(set.contains(z)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        lc365 sl = new lc365();
        System.out.println(sl.canMeasureWaterGCD(5, 7, 11));
    }
}
