package courseBook.acmbook;

import sun.nio.cs.ext.MacHebrew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class edge{
    int to;
    int cap;
    int rev;

    public edge(int to, int cap, int rev) {
        this.to = to;
        this.cap = cap;
        this.rev = rev;
    }
}
//0 1 10
//0 2 2
public class p211 {
    static int n;
    static boolean[] used;
    static Map<Integer,List<edge>> graph;
    public void add_edge(int from,int to,int cap){
        if(!graph.containsKey(from)){
            graph.put(from, new ArrayList<>());
        }
        graph.get(from).add(new edge(to,cap,graph.get(to).size()));
        graph.get(to).add(new edge(from,0,graph.get(from).size()-1));
    }
    public int dfs(int v,int t,int f){
        if(v == t) return f;
        used[v] = true;
        for (edge e: graph.get(v)) {
            if(!used[e.to] && e.cap > 0){
                int d = dfs(e.to,t, Math.min(f, e.cap));
                if(d>0){
                    e.cap -= d;
//                    graph.get(e.to).get(e.rev) += d;
                }
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        n = 5;
        used = new boolean[5];
        int[][] edges = {{0,1,10},
                {0,2,2},
                {1,2,5},
                {1,3,6},
                {3,2,3},
                {2,4,5},
                {3,4,8}};
        graph = new HashMap<>();

    }
}
