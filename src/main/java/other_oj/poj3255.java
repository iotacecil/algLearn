package other_oj;
// R条道路N个路口 双向通行 为1到N的次短路径

/*

Sample Input

4 4
1 2 100
2 4 200
2 3 250
3 4 100
Sample Output

450
Hint

Two routes: 1 -> 2 -> 4 (length 100+200=300) and 1 -> 2 -> 3 -> 4 (length 100+250+100=450)

 */

import java.util.*;

class Edge{
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
public class poj3255 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        Map<Integer,List<Edge>> map = new HashMap<Integer,List<Edge>>();
        for (int i = 0; i <E ; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            if(!map.containsKey(from)){
                map.put(from,new ArrayList<Edge>());
            }
            if(!map.containsKey(to)){
                map.put(to,new ArrayList<Edge>());
            }
            map.get(from).add(new Edge(to,weight));
            map.get(to).add(new Edge(from,weight));
        }
        dijkstra(map,N,E);

    }
/*
单源 最短路径
dist[i] 从s出发到终点i的最短路径。初始值INF ,dist[s] = 0
 */
    private static void dijkstra(Map<Integer,List<Edge>> map,int N,int E){
        Queue<Edge> heap = new PriorityQueue<Edge>(E*2,(a,b)->a.weight-b.weight);
        int[] dist = new int[N+1];
        int[] second = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(second, Integer.MAX_VALUE);
        dist[1] = 0;
        heap.add(new Edge(1,0));
        while (!heap.isEmpty()){
            Edge e = heap.poll();
            int to = e.to;
            int weight = e.weight;
            // 用这个到to的dist更新所有to邻的dist dist 如果第二小都比这个
            if(second[to] < weight)continue;
            for (int i = 0; i < map.get(to).size(); i++) {
                Edge next = map.get(to).get(i);
                int dis = weight+next.weight;
                // 更新最小
                if(dist[next.to] > dis){
                    int tmp = dist[next.to];
                    dist[next.to] = dis;
                    dis = tmp;
                    heap.add(new Edge(next.to,dist[next.to]));
                }
                // 只更新次小 也要入队 因为可能会扩展新的次小
                if(second[next.to] >dis && dist[next.to] <dis){
                    second[next.to] = dis;
                    heap.add(new Edge(next.to,second[next.to]));
                }
            }
        }
        System.out.println(second[N]);
    }

}
