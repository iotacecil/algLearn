package gfg.tsp;

import java.util.Arrays;
/*
lower bound:quality of solution
upper bound: run time
 */
public class tspbb {
    int n = 4;
    static final int MV = Integer.MAX_VALUE;
    int[][] cost = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
    };
    int[] cur_path = new int[n + 1];
    boolean[] visited = new boolean[n + 1];

    //到i的最小边
    int firstMin(int i) {
        int min = MV;
        for (int k = 0; k < n; k++) {
            if (cost[k][i] < min && i != k)
                min = cost[i][k];
        }
        return min;
    }

    //第二小的边
    int secondMin(int i) {
        int first = MV, second = MV;
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            if (cost[j][i] <= first) {
                second = first;
                first = cost[j][i];
            } else if (cost[j][i] <= second && cost[j][i] != first)
                second = cost[j][i];
        }
        return second;
    }


    void TSP() {
        // 初始化bound
        int cur_bound = 0;
        for (int i = 0; i < n; i++) {
            cur_bound += firstMin(i) + secondMin(i);
        }
        //奇数变成整数 /2+1
        cur_bound = ((cur_bound & 1) != 0) ? cur_bound / 2 + 1 : cur_bound / 2;
        visited[0] = true;
        Arrays.fill(cur_path, -1);
        cur_path[0] = 0;
        TSP(cur_bound, 0, 1, cur_path);
    }

    int[] final_path;
    int curr_res = 0;
    int final_res = 0;

    void TSP(int cur_bound, int cur_weight, int level, int[] cur_path) {

        //终止条件
        if (level == n) {
            //更新final
            if (cost[cur_path[level - 1]][cur_path[0]] != 0) {
                curr_res += cur_weight + cost[cur_path[level - 1]][cur_path[0]];
            }
            if (curr_res < final_res) {
                final_path = cur_path.clone();
                final_res = curr_res;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cost[cur_path[level - 1]][i] != 0 && visited[i] == false) {
                int tmp = cur_bound;
                //访问i
                cur_weight += cost[cur_path[level - 1]][i];
                if (level == 1) {
                    //？？
                    cur_bound -= (firstMin(cur_path[level - 1]) + firstMin(i) / 2);
                } else {
                    cur_bound -= (secondMin(cur_path[level - 1]) + firstMin(i) / 2);
                }
                if (cur_bound + cur_weight < final_res) {
                    cur_path[level] = i;
                    visited[i] = true;
                    TSP(cur_bound, cur_weight, level + 1, cur_path);
                }
                // 减枝 并重置回原来的cur_weight,cur_bound
                // 不访问i
                cur_weight -= cost[cur_path[level - 1]][i];
                cur_bound = tmp;
                Arrays.fill(visited, false);
                for (int j = 0; j < visited.length; j++) {
                    if (j <= level - 1) visited[cur_path[j]] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        tspbb sl = new tspbb();
        sl.TSP();
        System.out.println(sl.final_res);
        System.out.println(Arrays.toString(sl.final_path));
    }
}
