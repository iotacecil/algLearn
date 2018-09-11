package gfg;

public class hamiltback {
    //无向图 每个点1次
    final int V = 5;
    int path[];
    //v能够加到环中
    boolean isSafe(int v,int[][] graph,int[] path,int pos){
        //如果和path上一个点没有边
        if(graph[path[pos-1]][v]==0)return false;
        for (int i = 0; i < pos ; i++) {
            //路径中已经有过这个点
            if(path[i] == v)return false;
        }
        return true;
    }

    boolean hamUtil(int[][] graph,int[] path,int pos){
        //所有点都访问过了
        if(pos ==V){
            //并且能够回到0
            if(graph[path[pos-1]][path[0]]==1)return true;
            else return false;
        }
        for (int v = 1; v <V ; v++) {
            if(isSafe(v,graph , path, pos)){
                path[pos] = v;
                if(hamUtil(graph, path, pos+1))
                    return true;
            }
            path[pos] = -1;

        }
        return false;
    }
    int hamCycle(int[][] graph){
        path = new int[V];
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }

        path[0] =0;
        if(hamUtil(graph,path,1) == false){
            System.out.println("不存在");
            return 0;
        }
        printpath(path);
        return 1;

    }
    void printpath(int[] path){
        for (int i = 0; i <V ; i++) {
            System.out.print(" "+path[i]+" ");
        }
        System.out.println(path[0]);
    }
    public static void main(String[] args) {
        hamiltback sl = new hamiltback();
        int[][] graph1 = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        sl.hamCycle(graph1);

    }
}
