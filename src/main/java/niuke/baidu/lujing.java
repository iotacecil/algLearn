package niuke.baidu;

import java.util.*;

public class lujing {
    class Node{
        int val;
        int idx;
        boolean end = false;
        List<Node> list = new ArrayList<>();

        public Node(int val,int idx) {
            this.idx = idx;
            this.val = val;
        }
    }
    int rst = Integer.MIN_VALUE;
    private void dfs(List<Node> graph,Node node,boolean[] marked,int tmp){
//        marked[node.idx] = true;
        for(Node next:node.list){
            if(marked[next.idx])continue;
            marked[next.idx] = true;
            System.out.println(tmp);
            if(next.end){
                System.out.println(Arrays.toString(marked));
                rst = Math.max(tmp*next.val, rst);
                System.out.println(rst);
            }
            dfs(graph,next,marked,tmp*next.val);
            marked[next.idx] = false;
        }
    }

    public int sum(int numNodes, List<Integer> values,List<List<Integer>> edges){
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i <numNodes ; i++) {
            Node node = new Node(values.get(i),i);
            graph.add(node);
        }
        Set<Integer> set = new HashSet<>();
        for (List<Integer> edge:edges) {
            graph.get(edge.get(0)-1).list.add(graph.get(edge.get(1)-1));
            graph.get(edge.get(1)-1).list.add(graph.get(edge.get(0)-1));
            set.add(edge.get(0)-1);
        }
        for (List<Integer> edge:edges) {
            if(!set.contains(edge.get(1)-1)){
                graph.get(edge.get(1)-1).end = true;
//                System.out.println(graph.get(edge.get(1)-1).idx);
            }
        }

        for(Node node:graph){
            if(node.end){
                boolean[] marked = new boolean[numNodes];
                marked[node.idx] = true;
                dfs(graph,node,marked,node.val);
            }
        }
        return rst;


    }
    public static void main(String[] args) {
        lujing sl = new lujing();
        ArrayList<Integer> values = new ArrayList<>();
        values.add(-1);
        values.add(2);
        values.add(3);
        values.add(2);
        List<List<Integer>> edges = new ArrayList<>();
        ArrayList<Integer> edge1 = new ArrayList<>();
        edge1.add(1);
        edge1.add(2);
        edges.add(edge1);

        ArrayList<Integer> edge2 = new ArrayList<>();
        edge2.add(1);
        edge2.add(3);
        edges.add(edge2);

        ArrayList<Integer> edge3 = new ArrayList<>();
        edge3.add(3);
        edge3.add(4);
        edges.add(edge3 );
        System.out.println(sl.sum(4, values, edges));
    }
}
