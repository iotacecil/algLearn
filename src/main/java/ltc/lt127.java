package ltc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//拓扑排序
//对于图中的每一条有向边 A -> B , 在拓扑排序中A一定在B之前.
//拓扑排序中的第一个节点可以是图中的任何一个没有其他节点指向它的节点.
class DirectedGraphNode {
        int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 };
public class lt127 {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        int[] degree = new int[graph.size()];
        for(DirectedGraphNode node:graph){
            for(DirectedGraphNode neigh:node.neighbors){
                degree[neigh.label]++;
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<>();
        for (int i = 0; i <degree.length ; i++) {
            if(degree[i] == 0)
                q.offer(graph.get(i));
        }
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        while (!q.isEmpty()){
            DirectedGraphNode cur = q.poll();
            res.add(cur);
            for(DirectedGraphNode  neigh:cur.neighbors){
                if(--degree[neigh.label]==0){
                    q.offer(neigh);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
