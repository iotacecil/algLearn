package leetcode;

import java.util.*;

public class lc815right {
    public static void main(String[] args) {
//        int i = numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);
//        System.out.println(i);
        int[][] routes = {{0,1,6,16,22,23},{14,15,24,32},{4,10,12,20,24,28,33},{1,10,11,19,27,33},{11,23,25,28},{15,20,21,23,29},{29}};
        int[][] routes2 = {{1,7},{3,5}};
        lc815right sl = new lc815right();
        System.out.println(sl.numBusesToDestination(routes, 4, 21));


    }
    public int numBusesToDestination(int[][] routes, int S, int T) {
//        if(routes==null||routes.length<1||S==T)return 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[routes.length];
        for(int i =0;i<routes.length;i++){
            //1->1 2->1 7->1,2
            for(int j : routes[i]){
                List<Integer> tmp = map.getOrDefault(j,new ArrayList<>());

                tmp.add(i);
                map.put(j,tmp);
            }
        }
        System.out.println(map);
        Queue<Integer> que =new LinkedList<>();
        que.add(S);
        int bus = 0;
        int testcnt=0;
        while(!que.isEmpty()){
            int size = que.size();
            ++bus;
            //这一圈连通分量，在一辆车上
            while(size!=0){
                int pop = que.poll();


                List<Integer> part = map.get(pop);
                //可能这辆车有个站也在其它连通分量
                for(int car : part){
                    // System.out.println(visited.get(car));
                    if(visited[car])continue;

                    visited[car]=true;
                    //发现了其它连通分量
                    for(int t :routes[car]){
                        if(T==t)return bus;
                        que.add(t);
                    }

                }


                size--;
            }
        }
        //没有找到
        return -1;

    }
}
