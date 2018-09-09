package leetcode;




import java.util.*;

public class lc576 {
    class Pair<K,V>{
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    //42
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        //n = 4, endstate = 1111
        int endState = (1<<n)-1;
        Deque<Pair<Integer,Integer>> que = new ArrayDeque<>();
        boolean [][] visited = new boolean[n][1<<n];
        for(int i=0;i<n;i++){
            que.add(new Pair<>(i,1<<i));
        }
        int step =0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-->0){
                Pair<Integer, Integer> front = que.poll();
                Integer cur = front.key;
                Integer state = front.value;

                if(state == endState) return step;
                if(visited[cur][state])continue;
                visited[cur][state] = true;
                for(int next:graph[cur]){
                    que.add(new Pair<>(next,state|(1<<next)));
                }
            }
            step++;
        }
        return -1;
        }
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0},{0},{0}};
        int[][] graph2 = {{1,4},{0,3,10},{3},{1,2,6,7},{0,5},{4},{3},{3},{10},{10},{1,9,8}};
        lc576 sl = new lc576();
        System.out.println(sl.shortestPathLength(graph2));
    }
}
