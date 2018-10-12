package courseBook.acmbook;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p217 {
    static Map<Integer,List<Integer>> build_G(int[][] graph){
        int n = graph.length;
        Map<Integer,List<Integer>> G = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(graph[i][j]==0)continue;
                G.putIfAbsent(i,new ArrayList<>());
                G.putIfAbsent(j,new ArrayList<>());
                G.get(i).add(j);
                G.get(j).add(i);
            }

        }
        return G;
    }

    void add_edge(int u,int v){

    }

    public static void main(String[] args) {
        //[i][j] 计算机i能处理任务j
        int[][] graph = {{1,1,0},
                {1,0,1},
                {0,1,0}};


    }
}
