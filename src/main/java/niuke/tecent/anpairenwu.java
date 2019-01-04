package niuke.tecent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
// n个机器 m个任务 一个机器一天只能完成一个任务
class Pair{
    int time;
    int level;

    public Pair(int time, int level) {
        this.time = time;
        this.level = level;
    }
}
public class anpairenwu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Pair[] machine = new Pair[n];
        for (int i = 0; i <n ; i++) {
            machine[i] = new Pair(sc.nextInt(),sc.nextInt());
        }
        Pair[] work = new Pair[m];
        for (int i = 0; i < m; i++) {
            work[i] = new Pair(sc.nextInt(),sc.nextInt());
        }
        Comparator<Pair> cmp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.time!=o2.time)return o2.time-o1.time;
                else return o2.level - o1.level;
            }
        };
        Arrays.sort(work,cmp);
        Arrays.sort(machine,cmp);
        // 当前工作i，符合的机器有多少台
        int[] dp = new int[101];
        long gain = 0;
        int cnt = 0;
        int j = 0;
        for (int i = 0; i <m ; i++) {
            // j不减 j能满足当前任务也能满足后面任务
            while (j < n && machine[j].time >= work[i].time){
                dp[machine[j].level]++;
                j++;
            }
            for (int k = work[i].level; k < 101; k++) {
                if(dp[k] != 0){
                    dp[k]--;
                    gain += 200*work[i].time + 3*work[i].level;
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt+" "+gain);
    }
}
