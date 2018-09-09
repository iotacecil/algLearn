package leetcode;

import java.util.Arrays;

public class lc785 {
    public boolean isBipartite2(int[][] graph) {
        int[] co = new int[graph.length];
        Arrays.fill(co,-1);
        for (int i = 0; i < graph.length; i++) {
            if(co[i]==-1&&!valid(graph,0,i,co)){
                return false;
            }
        }
        return true;
    }
    private boolean valid(int[][] graph,int colorr,int cur,int[] co){
        System.out.println(Arrays.toString(co));
    if(co[cur]!=-1){
            return co[cur] ==colorr;
        }
        co[cur] = colorr;
        for (int next :graph[cur]) {
            if(!valid(graph,1-colorr,next,co)){
                System.out.println(next+" "+Arrays.toString(graph[cur])+"不行"+(1-colorr)+Arrays.toString(co));
                return false;
            }
        }
        return true;
    }
//按照算法4上的为什么不对？
    //todo
        private boolean[] marked;
    private boolean[] color;
    private boolean isTowColor = true;
    public boolean isBipartite(int[][] graph) {
//        Map<Integer,List<Integer>> graphmap = new HashMap<>();
//        for(int[] edge:graph){
//            graphmap.putIfAbsent(edge[0],new ArrayList<>());
//            graphmap.putIfAbsent(edge[1],new ArrayList<>());
//            graphmap.get(edge[0]).add(edge[1]);
//            graphmap.get(edge[1]).add(edge[0]);
//        }
        marked = new boolean[graph.length];
        color = new boolean[graph.length];
        for (int i=0;i<graph.length;i++) {
            if(!marked[i])dfs(graph,i);

        }
        return isTowColor;

    }
    private void dfs(int[][] graph,int v){
        System.out.println(Arrays.toString(marked));
        System.out.println(Arrays.toString(color));
        marked[v]=true;
        for(int w:graph[v]){
            if(!marked[w]){
                color[w]=!color[v];
                dfs(graph,w);
            }
            else if(color[w]==color[v])isTowColor=false;
        }
    }

    public static void main(String[] args) {
        lc785 sl = new lc785();
        System.out.println(sl.isBipartite2(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(sl.isBipartite2(new int[][]{{1,3}, {0,2}, {1,3}, {0,2}}));
    }
}
