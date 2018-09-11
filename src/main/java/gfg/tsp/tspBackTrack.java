package gfg.tsp;

import java.util.PriorityQueue;

public class tspBackTrack {
    int n = 4;
    int budget = 400;
    int[][] cost = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
    };
    int[] weight = new int[]{2,3,5,7};
    //路径长度
    int cl = 0;
    //路径cost
    int fl = Integer.MAX_VALUE;

    /**
     * 下一个路径上的点是之前没有出现过的
     * @param k
     * @return
     */
    private boolean nextValue(int k){
        int i = 0;
        while(i < k){
            if(path[k] == path[i]){
                return false;
            }
            i += 1;
        }
        return true;
    }
    class profitNode{
        int id;
        int profit;
        int cost;
        //未来可能的最大profit
        int bound;
        int level;
        int[] path;

        public profitNode(int id, int profit, int cost) {
            this.id = id;
            //到现在的profit
            this.profit = profit;
            //到现在的cost
            this.cost = cost;
        }
    }
    int[] path = new int[n];
    int[] bastpath = new int[n];
    boolean[] marked = new boolean[n];
    //用fraction greedy找bound
    private int bound(profitNode u){
        if(u.cost>budget)return 0;
        int[] marked = u.path;
        return 0;

    }
    boolean isSafe(int curcost,int v,int[] path,int level){
        if(curcost+cost[path[level-1]][v]+cost[v][0]>budget)return false;
        for (int i = 0; i <path.length ; i++) {
            if(path[i]==v)return false;
        }
        return true;
    }
//    //排列树
//    private boolean dfs(int[] path,int level){
//        if(level == n){
//
//            return true;
//        }
//        for (int i = 1; i < n; i++) {
//
//            if(isSafe(, , , ))
//
//        }
//    }
    private void bfs(int k,int budget){
        PriorityQueue<profitNode> que = new PriorityQueue<>((node1,node2)->node2.profit/node2.cost - node1.profit/node1.cost);
        int cur = 0;
        for(int i =1;i<n;i++){
            que.add(new profitNode(i,cost[cur][i],weight[i]));
        }
        profitNode oneNode = new profitNode(-1, 0, 0);
        profitNode zeroNode = new profitNode(-1, 0, 0);
       int MaxProfit = 0;
        while (!que.isEmpty()){
           profitNode curNode = que.poll();

            //超了，或者已经0/1过了所有点,继续扩展同一层的节点
            if(curNode.cost+cost[curNode.id][0]>budget||curNode.level==n-1)continue;

            zeroNode.level = curNode.level+1;
            //访问这个点
            zeroNode.cost = curNode.cost+cost[curNode.id][zeroNode.level];
            zeroNode.profit = curNode.profit+weight[zeroNode.level];
            if(zeroNode.cost+cost[zeroNode.id][0]<=budget&&zeroNode.profit>MaxProfit)
                MaxProfit = zeroNode.profit;

        }
    }


//    public static void main(String[] args) {
//        int k = 1;
//        tspBackTrack sl = new tspBackTrack();
//        sl.bfs(k);
//    }
}
