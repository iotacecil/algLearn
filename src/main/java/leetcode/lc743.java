package leetcode;

import java.util.*;

public class lc743 {
    //并不懂g是干嘛的
    //fast way 7ms
    public int networkDelayTimeDFSDjHeapFast(int[][] times, int N, int K) {
        int[][] g = new int[N][N];
        for(int[] row:g){
            Arrays.fill(row, -1);
        }
        for(int[] e:times){
            g[e[0]-1][e[1]-1] = e[2];
        }
        int[] l = new int[N];
        Arrays.fill(l,-1 );
        int[] dis = new int[N];
        Arrays.fill(dis,-1 );
        dis[K-1] =0;
        while (true){
            int minNode = -1;
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i <N ; i++) {
                if(dis[i]!=-1){
                    if(dis[i]<minCost){
                        minCost = dis[i];
                        minNode = i;
                    }
                }
            }
            if(minNode==-1)break;
            //下次不扩展这个点了
            l[minNode] = dis[minNode];
            dis[minNode] = -1;
            System.out.println("graph");
            for(int[] row:g){
                System.out.println(Arrays.toString(row));
            }
            for (int i = 0; i <N ; i++) {
                if(g[minNode][i]!=-1){
                    if(dis[i]==-1){
                        if(l[i]==-1)
                            dis[i] = l[minNode]+g[minNode][i];
                    }else{
                        dis[i] = Math.min(dis[i],l[minNode]+g[minNode][i]);
                    }
                }

            }
        }
        int min = Integer.MIN_VALUE;
        for(int i :l){
            if(i==-1)return -1;
            min = Math.max(min,i );
        }
        return min;
    }

        //too slow
    public int networkDelayTimeDFSDjHeap(int[][] times, int N, int K) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] edge:times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
        heap.add(new int[]{K,0});
        int[] dis = new int[N];
        Arrays.fill(dis,Integer.MAX_VALUE );
//        dis[K-1] = 0;
//        Map<Integer,Integer> dist = new HashMap<>();
        while (!heap.isEmpty()){
            int[] minnext = heap.poll();
            int d = minnext[1],node = minnext[0];
            if(dis[node-1]!=Integer.MAX_VALUE)continue;
            dis[node-1] = d;
            if(graph.containsKey(node)){
                for(int[] edge:graph.get(node)){
                    if(dis[edge[0]-1]!= Integer.MAX_VALUE)
                        heap.add(new int[]{edge[0],d+edge[1]});
                }
            }
        }
//        if(dist.size()!=N)return -1;
        int ans = 0;
        for(int cost:dis) {
            if (cost == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cost);
        }
        return ans;
    }

        /**
         *
         * @param times
         * @param N
         * @param K
         * @return
         */
    public int networkDelayTimeDFSDj(int[][] times, int N, int K) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] edge:times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        int[] dis = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K-1]=0;
        boolean[] marked = new boolean[N+1];
        while (true){
            int candNode =-1;
            int canDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N ; i++) {
                //最近的点
                if(!marked[i]&&dis[i-1]<canDist){
                    canDist = dis[i-1];
                    candNode = i;
                }
            }
//            System.out.println(candNode);
            if(candNode<0)break;
            marked[candNode] = true;
            //最近点的邻接
            if(graph.containsKey(candNode))
                for(int[] next:graph.get(candNode))
                    dis[next[0]-1] = Math.min(dis[next[0]-1],dis[candNode-1]+next[1]);
//            System.out.println(Arrays.toString(dis));
        }
        int ans = 0;
        for(int cost:dis){
            if(cost==Integer.MAX_VALUE)return -1;
            ans= Math.max(ans,cost);
        }
        return ans;
    }



    /**
     * dfs Hashmap6% 改成数组11% 124ms
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTimeDFS(int[][] times, int N, int K) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] edge:times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        //只是为了加速， 不排序2.8% 352ms
        for(int node:graph.keySet()){
            Collections.sort(graph.get(node),(a,b)->a[1]-b[1]);
        }
        dis = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dfs(graph,K,0);
        int ans = 0;
        for(int cost:dis){
            ans = Math.max(ans,cost);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    //用于记录到某点的距离，如果到这个点花费的时间已经超过记录的最小值了，不对这个点dfs了。
    int[] dis;
    private void dfs(Map<Integer,List<int[]>> graph,int node,int elased){
        if(elased>=dis[node-1])return;
        dis[node-1]=elased;
        if(graph.containsKey(node)){
            for(int[] nei:graph.get(node))
                dfs(graph,nei[0],elased+nei[1]);
        }
    }

    /**Bellman Ford
     * 从K点广播给N个点需要的最少时间
     * @param times u到v花费w秒 1 <= w <= 100.
     * @param N N will be in the range [1, 100].
     * @param K
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        int max_time = 100*101;
        int[] dis = new int[N];
        int rst = Integer.MIN_VALUE;
        Arrays.fill(dis,max_time);
        //起点
        dis[K-1] = 0;
        //其他N-1个点
        for (int i = 1; i <N ; i++) {
            //遍历n次边的数组
            for(int[] edge:times){
                int u = edge[0]-1;
                int v = edge[1]-1;
                int w = edge[2];
                //动态规划
                dis[v] = Math.min(dis[v],dis[u]+w);
            }

        }
        for(int cost:dis){
            rst = Math.max(cost,rst );
        }
        return rst == max_time?-1:rst;
    }

    /**
     * 弗洛伊德 任意两点的最短路径
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTimeF(int[][] times, int N, int K) {
        int max_time = 100*101;
        //二维数组 表示i到j的最短路径
        int[][] dis = new int[N][N];
        for(int[] d:dis){
            Arrays.fill(d,max_time);
        }
        for(int[] time:times){
            dis[time[0]-1][time[1]-1] = time[2];
        }
        for (int i = 0; i <N ; i++) {
            dis[i][i] =0;
        }
        for (int k = 0; k <N ; k++)
            for (int i = 0; i <N ; i++)
                for (int j = 0; j <N ; j++)
                    //三维动态规划
                    dis[i][j] = Math.min(dis[i][j],dis[i][k]+dis[k][j]);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <N ; i++) {
            if(dis[K-1][i]>=max_time)return -1;
            ans = Math.max(ans,dis[K-1][i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        lc743 sl = new lc743();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(sl.networkDelayTimeDFSDjHeapFast(times, 4, 2));
    }
}
