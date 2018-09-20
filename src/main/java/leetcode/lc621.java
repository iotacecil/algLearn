package leetcode;

import java.util.*;

public class lc621 {

    public int leastIntervalPQ(char[] tasks, int n) {

            int[] map = new int[26];
            for (char c: tasks)
                map[c - 'A']++;
            PriorityQueue < Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
            for (int f: map) {
                if (f > 0)
                    queue.add(f);
            }
            int time = 0;
            while (!queue.isEmpty()) {
                int i = 0;
                List < Integer > temp = new ArrayList < > ();
                while (i <= n) {
                    if (!queue.isEmpty()) {
                        if (queue.peek() > 1)
                            temp.add(queue.poll() - 1);
                        else
                            queue.poll();
                    }
                    time++;
                    if (queue.isEmpty() && temp.size() == 0)
                        break;
                    i++;
                }
                for (int l: temp)
                    queue.add(l);
            }
            return time;
        }


        //21 ms, faster than 42.23%
    public int leastIntervalMy(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c:tasks){
            count[c-'A']++;
        }
        Arrays.sort(count);
        int time = 0;
        while(count[25]>0){

            count[25]--;
            time++;
            //1,1 ->1,0 这个任务不等冷却了，直接下一个
            if(count[25]==0){
                Arrays.sort(count);

                continue;

            }
            for(int i=1;i<=n&&i<26;i++){
                if(count[25-i]>0)count[25-i]--;
                time++;

            }
            Arrays.sort(count);

        }
        return time;
    }
    //Runtime: 14 ms, faster than 46.79% of
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c:tasks){
            map[c-'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        //数量最多那个
        while (map[25]>0){
            //先执行一个最大的
            int i =0;
            //再执行n个
            while (i<=n){
//                已经没有任务在等待了
                if(map[25]==0)break;
                if(i<26&&map[25-i]>0)map[25-i]--;
                time++;
                //如果没了就空着
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        lc621 sl = new lc621();
        System.out.println(sl.leastIntervalPQ(tasks, 50));
    }
}
