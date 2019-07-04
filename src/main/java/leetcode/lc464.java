package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc464 {
    int[] state;
    int M;
    Map<Integer,Boolean> hmap = new HashMap<>();
    public boolean canIWin(int m, int d) {
        if((1+m)*m/2<d)return false;
        M = m;
        state = new int[m+1];
        return canwin(d,0);


    }

    HashMap<Integer, Boolean> used = new HashMap<>();

    public boolean canIWin2(int max, int total) {
        if (used.containsKey(total)) return used.get(total);
        if (total >= 0 && total <= max) {
            used.put(total, true);
            return true;
        } else if (total < 0) {
            used.put(total, false);

            return false;
        }
        for (int i = 1; i <= max; i++) {
            // 对方不能赢
            if (!canIWin(max, total - i)) {
                used.put(total, true);
                return true;
            }
        }
        used.put(total, false);
        return false;
    }


    private boolean canwin(int d,int visited){

        if(hmap.containsKey(visited))return hmap.get(visited);
        for(int i =1;i<M+1;i++){
            int mask = (1<<i);

            if((mask&visited)==0||(i>=d)||!canwin(d-i,mask|visited)){
                hmap.put(visited,true);
                return true;
            }

            state[i]=0;
        }

        hmap.put(visited,false);
        return false;
}

//    int[] state;
//    public boolean canIWin(int m, int d) {
//        if((1+m)*m/2<d)return false;
//
//        state = new int[m+1];
//        return canwin(d,new HashMap<String,Boolean>());
//
//
//    }
//    private boolean canwin(int d, Map<String,Boolean> hmap){
//        String key = Arrays.toString(state);
//        if(hmap.containsKey(key)){
//            return hmap.get(key);
//        }
//        for(int i =1;i<state.length;i++){
//            if(state[i]==0){
//                state[i]=1;
//                if(d-i<=0||!canwin(d-i,hmap)){
//                    hmap.put(key,true);
//                    state[i]=0;
//                    System.out.println("选了i赢了:"+i);
//                    return true;
//                }
//                System.out.println("没赢下一个"+i);
//                state[i]=0;
//            }
//        }
//        System.out.println(hmap);
//        hmap.put(key,false);
//        return false;
//    }

    public static void main(String[] args) {
     lc464 sl = new lc464();
        System.out.println(sl.canIWin2(10, 40));
        System.out.println(sl.used);

    }

}
