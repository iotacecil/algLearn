package other_oj;
//https://blog.csdn.net/NOIAu/article/details/78222748
//4 5 1 4
//
//2 1 2 1
//
//3 4 3 1
//
//2 3 1 2
//
//3 1 1 4
//
//2 4 2 4
import java.util.*;

public class BicriterialRoute {
    class Line{
        int to;
        int nxt;
        int flow;
        int tim;
    }
    int n,m;
    int up = 10000;
    int[] head = new int[606];
    int tail=0;
    int[][] dis = new int[106][106*106];

    int inf=0;
    boolean[][] vis = new boolean[106][106*606];
    int S=0,T=0;
    Line[] line = new Line[606*2];
    private void add_line(int from,int to,int flow,int tim){
        line[++tail].nxt = head[from];
        line[tail].to =to;
        line[tail].tim = tim;
        line[tail].flow = flow;
        head[from] = tail;

    }
    class pair<T,F>{
        private int first;
        private int second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }
    Queue<pair<Integer,Integer>> q = new ArrayDeque<>();
    private void SPFA(){

        for (int i = 0; i <dis.length ; i++) {
            for (int j = 0; j <dis[0].length ; j++) {
                dis[i][j] =15;
            }

        }
        inf = dis[0][0];
        pair<Integer,Integer> map = new pair<>(S,0);

        q.add(map);
        dis[S][0] = 0;vis[S][0] =true;
        while(!q.isEmpty()){
            pair<Integer,Integer> tmp = q.poll();
            int u = tmp.first;
            int flowu = tmp.second;
            vis[u][flowu] = false;
            for(int i=head[u];i!=0;i=line[i].nxt){
                int v = line[i].to;
                int flowv = flowu+line[i].flow;
                if(flowv<=up){
                    if(dis[v][flowv]>dis[u][flowu]+line[i].tim){
                        dis[v][flowv] = dis[u][flowu]+line[i].tim;
                        if(vis[v][flowv])continue;
                        q.add(new pair<>(v,flowv));
                        vis[v][flowv]=true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int S = sc.nextInt();
        int T = sc.nextInt();

        BicriterialRoute br = new BicriterialRoute();

        br.SPFA();
        int minn = br.inf;
        System.out.println(minn);
        int cnt = 0;
        System.out.println(br.up);
        for (int i = 0; i <=br.up ; i++) {
            if(br.dis[T][i]<minn){
                minn = br.dis[T][i];
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
