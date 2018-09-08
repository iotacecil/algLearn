package leetcode;

import java.util.*;

//Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
public class lc332 {
    public List<String> findItinerary(String[][] tickets) {
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        //要用addFirst
        LinkedList<String> rst = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        for(String[] t:tickets){
            graph.putIfAbsent(t[0],new PriorityQueue<>());
            graph.putIfAbsent(t[1],new PriorityQueue<>());
            //边
            graph.get(t[0]).add(t[1]);
        }
        System.out.println("start:"+graph);
        dfs("JFK",rst,graph);

        return rst;
    }
    private void dfs(String s,LinkedList<String> rst,Map<String,PriorityQueue<String>> graph){
        PriorityQueue<String> edge = graph.get(s);
        System.out.println(graph);

        while(edge!=null&&!edge.isEmpty()){
            //删掉这个边,拿出这个边另一点继续
            dfs(edge.poll(),rst,graph);


        }
        //没邻边了加到开头
        System.out.println(s);
        rst.addFirst(s);


    }

    public static void main(String[] args) {
        lc332 sl = new lc332();
//        sl.findItinerary(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"},{"SFO", "SJC"}, {"LHR", "SFO"}});
        sl.findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}});
    }
}
