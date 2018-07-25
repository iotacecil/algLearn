package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc207 {




    //100%
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] pre = new int[numCourses], pre2 = new int[numCourses];
        int[][] inv = new int[prerequisites.length][2];
        for(int i = 0; i < prerequisites.length; i++) {
            inv[i][1] = prerequisites[i][0];
            inv[i][0] = prerequisites[i][1];
        }
        for(int i = 0; i < numCourses; i++) {
            pre[i] = i;
            pre2[i] = i;
        }
        return loopCheck(prerequisites, pre) && loopCheck(inv, pre2);
    }
    private boolean loopCheck(int[][] prerequisites, int[] pre) {
        for(int[] pair : prerequisites) {
            int parent = pair[0], child = pair[1];
            while(pre[child] != child) {
                child = pre[child];
                if(child == parent) return false;
            }
            pre[parent] = child;
        }
        return true;
    }
    // 56%
    List[] graph_;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph_ = new ArrayList[numCourses];
       for(int i =0;i<numCourses;i++){
           graph_[i] = new ArrayList<Integer>();
       }
        for(int[] back:prerequisites){
            int pre = back[0];
            int lesson = back[1];
            graph_[lesson].add(pre);
        }
        System.out.println(Arrays.toString(graph_));
        //0没访问过，1正在访问，2 访问过了
        int[] visit = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            if(hasCircle(i,visit))return false;
        }
        return true;
    }
    private boolean hasCircle(int idx,int[] visited){
        if(visited[idx]==1)return true;
        if(visited[idx]==2)return false;
        visited[idx]=1;
        List<Integer> neib = graph_[idx];
        for(int i:neib){
            if(hasCircle(i,visited))return true;
        }
        visited[idx]=2;
        return false;

    }

    public static void main(String[] args) {
        lc207 sl = new lc207();
        System.out.println(sl.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
