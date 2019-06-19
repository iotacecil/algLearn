package niuke.codedance;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
坑 有N个pm pmid 不一定
3 3 6
1 1 1 2
1 2 10 1
1 3 2 2
2 1 1 2
2 3 5 5
3 3 2 2
 */
public class 任务调度2018 {
    static class Task {
        public Task(int id, int pm, int clock, int level, int cost) {
            this.id = id;
            this.pm = pm;
            this.clock = clock;
            this.level = level;
            this.cost = cost;
        }

        int id;
        int pm;
        int clock;
        int level;
        int cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //PM数量
        int N = sc.nextInt();
        // 程序员数量
        int M = sc.nextInt();

        int P = sc.nextInt();

/*
对于一个PM来说，最想实现的idea首先考虑优先等级高的，
相同的情况下优先所需时间最小的，还相同的情况下选择最早想出的，



 */
// 关键 先按时间排！ 空闲的程序员直接完成最早的任务
        PriorityQueue<Task> idea = new PriorityQueue<Task>((a, b) -> {
            if (a.clock == b.clock) {
                if (a.level == b.level) {
                    if (a.cost == b.cost) {
                        return a.clock - b.clock;
                    }
                    return a.cost - b.cost;
                }
                return a.level - b.level;
            }
            return a.clock - b.clock;
        }
        );

        PriorityQueue<Task> pq2 = new PriorityQueue<Task>();
        for (int i = 0; i < P; i++) {
            int pmid = sc.nextInt() - 1;
            int clock = sc.nextInt();
            int level = sc.nextInt();
            int cost = sc.nextInt();
            idea.add(new Task(i, pmid, clock, level, cost));

        }
//


        int[] clocks = new int[M];
//        System.out.println("程序员"+M);
//        System.out.println("clocks"+clocks.length);
        int[] rst = new int[P];

        // N个PM的最想做的任务 分配给M个程序员
//            for (int i = 0; i <M ; i++) {
        // 从这些pm中挑一个最短的
        int i = 0;
        Task best = null;
        // M个程序员
        for (int j = 0; j < M; j++) {
            if (!idea.isEmpty()) {
                Task tmp = idea.poll();
                int time = tmp.clock + tmp.cost;
                rst[tmp.id] = time;
                clocks[j] = time;
                P--;
            }
        }
        Arrays.sort(clocks);

            /*
// 每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,
// 然后从中挑选出所需时间最小的一个idea独立实现，
// 如果所需时间相同则选择PM序号最小的。
             */
        PriorityQueue<Task> wait = new PriorityQueue<>((a, b) -> {
            if (a.cost == b.cost) {
                return a.pm - b.pm;
            } else {
                return a.cost - b.cost;
            }
        });
        while (P > 0) {
            int mintime = clocks[0];
            // 所有可以执行的任务 根据程序员排序
            while (!idea.isEmpty() && idea.peek().clock <= mintime) {
                wait.add(idea.poll());
            }
            if (wait.isEmpty()) {
                Task target = idea.poll();
                // 这个还没等到的任务的结束时间就是这个任务的总时间
                int time = target.clock + target.cost;
                rst[target.id] = time;
                clocks[0] = time;
            } else {
                Task next = wait.poll();
                int time = mintime + next.cost;
                rst[next.id] = time;
                clocks[0] = time;
                // 其它任务都暂时不要了
                while (!wait.isEmpty()) {
                    idea.add(wait.poll());
                }
            }
            P--;
            Arrays.sort(clocks);

        }
        for (int t : rst) {
            System.out.println(t);

        }

        // int minclock = Integer.MAX_VALUE;
        //会查看每个PM尚未执行并且最想完成的一个idea,
        // 然后从中挑选出所需时间最小的一个idea独立实现
//                for (int j = 0; j <N ; j++) {
//                    for(Task task : idea[j]){
//                        if(task.clock <= clocks[i]){
////                            if(best == null || best.level<task.level || (best.level==task.level&&best.cost<task.cost)){
//                            if(best == null || (clocks[i]+best.cost>clocks[i]+task.cost) ||(best.cost==task.cost&&best
//                                    .pm>task
//                                    .pm)){
//                                best = task;
//                            }
//                        }
//                     //   minclock = Math.min(minclock,task.clock);
//                    }
//                }
//                if(best!=null){
//                    clocks[i]+=best.cost;
////                    System.out.println(best.id);
//                    rst[best.id] = clocks[i];
//                    P--;
//                   // idea[best.pm].remove(best);
////                    System.out.println(Arrays.toString(clocks));
//                }else{
////                    while (clocks[i]<minclock && i+1<N && clocks[i] <clocks[i+1])
//                    clocks[i]++;
//
//                }


    }
}
