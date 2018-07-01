package leetcode;

import java.util.*;
import java.util.stream.Stream;

public class lc815 {
    // [[1, 2, 7], [3, 6, 7]]
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4,5));
        HashMap<Integer,List<Integer>> map = new HashMap<>();
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

    public static void main(String[] args) {
        int i = numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);



    }
}
