package luogu;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
最小生成树 prim
4 5
1 2 2
1 3 2
1 4 3
2 3 4
3 4 3
 */
public class p3366 {
    static  int maxm = 200001;
    static  int maxn = 5001;
    static class Edge{
        int v,w,next;

        // to
        public Edge(int v, int w, int next) {
            this.v = v;
            this.w = w;
            this.next = next;
        }
    }


    static void add(Edge[] e,int u,int v,int w,int cnt,int[] head){
        e[cnt] = new Edge(v,w,head[u]);
//        e[cnt].v = v;
//        e[cnt].w = w;
//        e[cnt].next = head[u];
        head[u] = cnt;
    }

    static int prim(Edge[]e,int[]head){
        int sum = 0;
        int[] dist = new int[maxn+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist[1] = 0;
        pq.add(new int[]{0,1});
        int pcnt = 0;
        boolean[] visited = new boolean[maxn+1];
        while (!pq.isEmpty() && pcnt < maxn){
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];
            if(visited[u])continue;
            pcnt++;
            sum += d;
            visited[u] = true;
            // u 节点的所有边
            for(int i = head[u];i!=0;i = e[i].next){
                //如果u->w <
                if(e[i].w < dist[e[i].v]){
                    dist[e[i].v] = e[i].w;
//                    System.out.println("v:"+e[i].v+"u:"+u);
                    pq.add(new int[]{dist[e[i].v],e[i].v});
                }
            }
        }
        if(pcnt == maxn)return sum;
        else return -1;


    }

    /*
    5 6
    1 2 0
    1 3 0
    4 5 0
    3 2 10
    1 4 6
    3 5 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        maxm = m + k;
        maxn = n;
        Edge[] es = new Edge[(maxm+1)<<1];
        int[] head = new int[maxn+1];
        int[] dis = new int[maxn+1];
        int cnt = 1;
        for (int i = 0, u, v, w; i <m ; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            w = 0;
            add(es, u, v, w, cnt, head);
            cnt++;

            add(es, v, u, w, cnt, head);
            cnt++;

        }

        for (int i = 0, u, v, w; i < k; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            add(es, u, v, w, cnt, head);
            cnt++;

            add(es, v, u, w, cnt, head);
            cnt++;

        }
        System.out.println(prim(es, head));


    }
}
