package leetcode;

import java.util.*;

public class lc815 {
    public static void main(String[] args) {
        int i = numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);
        System.out.println(i);
        int[][] routes = {{0,1,6,16,22,23},{14,15,24,32},{4,10,12,20,24,28,33},{1,10,11,19,27,33},{11,23,25,28},{15,20,21,23,29},{29}};
        lc815 sl = new lc815();
        System.out.println(sl.numBusesToDestination2(routes, 4, 21));


    }

    public int numBusesToDestination2(int[][] routes, int S, int T) {
        Map<Integer,List<Integer>> stop2bus = new HashMap<>();
        for(int i =0;i<routes.length;i++){
            for(int stop :routes[i]){
                List<Integer> buses = stop2bus.getOrDefault(stop,new ArrayList<>());

                buses.add(i);
                stop2bus.put(stop,buses);
            }
        }

        System.out.println(stop2bus);
        boolean[] marked = new boolean[routes.length];
        int cnt =0;
        Deque<Integer> que = new ArrayDeque<>();
//        que.poll();
//        que.pop();
        que.add(S);

        while(!que.isEmpty()){
            int size = que.size();
            ++cnt;
            System.out.println("cnt++");
            while(size-->0){
                int cur = que.poll();
                System.out.println(cur+" "+stop2bus.get(cur));
                for(int bus:stop2bus.get(cur)){
                    if(marked[bus])continue;

                    marked[bus]=true;
                    for(int stop:routes[bus]){
                        if(stop==T)return cnt;
                        que.add(stop);
                    }
                }
            }
        }
        return -1;
    }






    // [[1, 2, 7], [3, 6, 7]]
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4,5));

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Deque<Integer> que2 = new ArrayDeque<>();

        Queue<Integer> que = new LinkedList<>();
        List<Integer> orDefault = map.getOrDefault(1, new ArrayList<>());
        orDefault.add(1);
        map.put(1,orDefault);
        List<Boolean> visited = new ArrayList<>(2);
        System.out.println("visited"+visited);

        que.add(1);
      que.add(2);
        Integer poll = que.poll();
        System.out.println(que);


        for(int i =0;i<routes.length;i++) {
            for (int j : routes[i]) {
                List<Integer> carid = map.getOrDefault(j, new ArrayList<>());
                carid.add(i);
                map.put(j,carid);


            }
        }



        //1 find S in routes[i]
        //2 find T in routes[j]
        //3 if(find 交集(route[i],route[j)) cnt++;
        //4 else
        //  for num = 1-n-2
        //      for(i=except(i,j))routes[i]
        //         if(交集) cnt++
        // else return -1;

        // graph:
        // [[1, 2, 7], [3, 6, 7]]
        /*
           {1:[2,7],2:[1,7],7:[1,2,3,6],3:[6,7],6:[3,7]}
         */

return 1;
    }


}
