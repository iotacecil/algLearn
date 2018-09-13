package courseBook.dsLearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dfsroute {
    public static int degree(Map<Integer,List<Integer>> graph,int v){
        int degree = 0;
        for(int w :graph.get(v)){
            degree++;
        }
        return degree;
    }
    public static int maxDegree(Map<Integer,List<Integer>> graph){
        int max = 0;
        for(int v:graph.keySet()){
            max = Math.max(degree(graph,v ),max);
        }
        return max;
    }
    public static int numberOfSelfLoops(Map<Integer,List<Integer>> graph){
        int cnt = 0;
        for(int v:graph.keySet()){
            for(int w:graph.get(v)){
                if(v==w)cnt++;
            }
        }
        return cnt/2;
    }
    public static String toString(Map<Integer,List<Integer>>graph){
        StringBuilder s =new StringBuilder();
        s.append(graph.size());
        s.append("个顶点");
        for(int v=0;v<graph.size();v++){
            s.append(v);
            s.append(":");
            for (int w:graph.get(v))
                s.append(w+" ");
            s.append("\n");
        }
        return s.toString();

    }
    public static void main(String[] args) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        List<Integer> nei = new ArrayList<>();
        nei.add(1 );
        graph.put(0,nei );
        System.out.println(toString(graph));

    }
}
