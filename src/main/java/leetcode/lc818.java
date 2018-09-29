package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

class Step{
    int po;
    int speed;

    public Step(int po, int speed) {
        this.po = po;
        this.speed = speed;
    }
}
public class lc818 {

    /**
     * 1 <= target <= 10000.
     * @param target
     * @return
     */
    public int racecar(int target) {
        Deque<Step> que = new ArrayDeque<>();
        Step first = new Step(0,1);
        que.add(first);
        HashSet<String> memo = new HashSet<>();
//        HashSet<Integer> bitmemo = new HashSet<>();
        memo.add("0_1");
        //不反着走
        memo.add("0_-1");
        int cnt = 0;
        while (!que.isEmpty()){
            int size = que.size();
            while (size-->0){
                Step cur = que.poll();
                int pos = cur.po;
                int speed = cur.speed;
                //加速
                {
                    int nextPo = pos + speed;
                    int nextSpeed = speed * 2;
                    Step next = new Step(nextPo, nextSpeed);
                    if (pos == target) return cnt + 1;
                    //剪枝 只有当前位置<2target,speed<2target
                if(Math.abs(next.speed)<2*target&&Math.abs(next.po)<2*target)
                    que.add(next);
                }
                //调头
                {
                    int nextSpeed = speed>0?-1:1;
                    Step next = new Step(pos,nextSpeed);
                    //防止回头的位置是已经执行过相同加速的
                    String key = pos+"_"+nextSpeed;
                    if(!memo.contains(key)){
                      que.add(next);
                      memo.add(key);
                    }
                }
            }
            cnt++;
        }
        return -1;

    }

    public static void main(String[] args) {
        lc818 sl = new lc818();
        int racecar = sl.racecar(3);
        System.out.println(racecar);
    }
}
