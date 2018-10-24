package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class lc279 {
    class Pair{
        int num;
        int time;
        // 这个this不能省略为什么
        Pair(int num,int time){
            this.num = num;
            this.time = time;
        }
    }
    // 15.9%
    // 不用结构体 用层数记 16%
    public int numSquares(int n) {
        Set<Integer> set = new HashSet<>();
        Pair start = new Pair(n,0);
        Deque<Pair> que = new ArrayDeque<>();
        que.add(start);
        while(!que.isEmpty()){
            Pair top = que.poll();

            // if(top.num == 0){
            //     return top.time;
            // }

            for(int i = 0; i*i <= n; i++){
                if(top.num - i*i == 0){
                    return top.time + 1;
                }
                else{
                    int next = top.num - i*i;
                    if(!set.add(next)){
                        continue;
                    }else{
                        que.add(new Pair(next , top.time + 1));
                    }
                }

            }

        }
        return -1;
    }

    public static void main(String[] args) {
        lc279 sl = new lc279();
        System.out.println(sl.numSquares(12));
    }
}
