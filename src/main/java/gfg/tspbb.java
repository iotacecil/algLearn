//package main.java.gfg;
//
//public class tspbb {
//    int n = 4;
//    static final int MV =Integer.MAX_VALUE;
//    int[][] cost = {
//            {0, 10, 15, 20},
//            {10, 0, 35, 25},
//            {15, 35, 0, 30},
//            {20, 25, 30, 0}
//    };
//    int[] cur_path = new int[n+1];
//    boolean[] visited = new boolean[n+1];
//    //到i的最小边
//    int firstMin(int i){
//        int min = MV;
//        for (int k = 0; k < n; k++) {
//            if(cost[k][i]<min&&i!=k)
//                min = cost[i][k];
//        }
//        return min;
//    }
//
//    //第二小的边
//    int secondMin(int i){
//        int first = MV,second = MV;
//        for (int j = 0; j < n; j++) {
//            if(i==j)continue;
//            if(cost[j][i]<=first){
//                second = first;
//                first = cost[j][i];
//            }else if(cost[j][i]<=second&&cost[j][i]!=first)
//                second = cost[j][i];
//        }
//        return second;
//    }
//
//
//    void TSP(){
//        int cur_bound = 0;
//        for (int i = 0; i <n; i++) {
//            cur_bound += firstMin(i)+secondMin(i);
//        }
//        //奇数变成整数 /2+1
//        cur_bound = ((cur_bound&1)!=0)?cur_bound/2+1:cur_bound/2;
//        visited[0] = true;
//        cur_path[0] = 0;
//        TSP(cur_bound,0,1,cur_path);
//    }
//
//    int curr_res = 0;
//    int final_res = 0;
//    void TSP(int cur_bound,int cur_weight,int level,int[] cur_path){
//        //终止条件
//        if(level == n){
//            if(cost[cur_path[level-1]][cur_path[0]]!=0){
//                curr_res +=cur_weight+cost[cur_path[level-1]][cur_path[0]];
//            }
//            if(curr_res<final_res)final_res = curr_res;
//            return;
//        }
//        for(int i =0;i<n;i++){
//            if(cost[cur_path[level-1]][i]!=0&&visited[i]==false){
//                int tmp = cur_bound;
//                cur_weight += cost[cur_path[level-1]][i];
//                if(level == 1){
//                    cur_bound -= (firstMin(cur_path[level-1])+firstMin(i))
//                }else{
//
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//}