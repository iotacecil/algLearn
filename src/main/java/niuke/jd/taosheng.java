package niuke.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
input
6
3 2
2 1
4 3
5 2
6 1

output
4
 */
public class taosheng {
    static class Node{
        int val;
        List<Integer> nexts;

        public Node(int val) {
            this.val = val;
            this.nexts = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 邻接表
        Node[] graph = new Node[n];
        for (int i = 0; i <n ; i++) {
            graph[i] = new Node(i);
        }
        for (int i = 0; i <n-1 ; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[v-1].nexts.add(w-1);
            graph[w-1].nexts.add(v-1);
        }
        int max = 0;
        // 计算根节点的所有相邻点 的最大深度
        List<Integer> roots = graph[0].nexts;
        for(Integer root : roots){
            int count = getEdgeCnt(graph,root,0);
            max = Math.max(max, count);
        }
        System.out.println(max+1);
    }
    //dfs遍历计算子节点(边）个数
    private static int getEdgeCnt(Node[] graph, Integer root, int i) {
        int cnt = 0;
        List<Integer> nexts = graph[root].nexts;
        // 忽略到 父节点 i 的边
        cnt += nexts.size()-1;
        for(Integer next:nexts){
            if(next == i)continue;
            cnt += getEdgeCnt(graph, next, root);
        }
        return cnt;
    }

}
