package bdstar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Time Limit Exceeded

//AA BB -> 保留问题1,2,12的集合有2对问卷 有1对问卷是不同的
// ABA BAB ABB ->1->2对问卷不同 12->2对不同
//2->[[1][12][2] +3 [13][123][23][3] +4[
public class zg1801 {
    //10个数的subset 取的时候取前m个的subset
    //
    static HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();


    static private List<List<Integer>> getsubstes(int m) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        //[]->[0],[0][1][10] ->[2]
        List<Integer> zero = new ArrayList<Integer>();
        zero.add(0);
        subsets.add(zero);
        map.put(0, subsets);
        for (int i = 1; i < 10; i++) {
            List<List<Integer>> thistime = new ArrayList<List<Integer>>(map.get(i - 1));
            for (int j = 0; j < map.get(i - 1).size(); j++) {
//                System.out.println(i+" "+j);
//                System.out.println(subsets.get(j));
                List<Integer> before = new ArrayList<Integer>(thistime.get(j));
                before.add(i);

                thistime.add(before);

//                System.out.println(before);
            }
            List<Integer> single = new ArrayList<Integer>();
            single.add(i);
            thistime.add(single);
            map.put(i, thistime);
        }
        return map.get(m);
    }


    // ABABABA BABABAAB
    //1 2 3
    private static boolean distinct(List<Integer> subset, String wj1, String wj2) {
        for (int i : subset) {
            if (wj1.charAt(i) != wj2.charAt(i)) {
//                System.out.println(subset);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
//        int T = 2;
        int Tcnt=1;
        while (Tcnt<=T) {
            //问卷数量
            int n = sc.nextInt();
            //问题数量

            int m = sc.nextInt();
            int k = sc.nextInt();
            //如果至少两对不同，问卷数量的组合数少于k return 0
            //如果只取一位，只有A,B ->  ABABABA->?几对不同？
            String[] wjs = new String[n];
            for (int i = 0; i < n; i++) {
                wjs[i] = sc.next();
            }
            // ABA BAB,ABA BAB ,ABA ABA
            //

//          问卷组合  12 13 14 .. 23 24... n-1 n



            //问卷数量的组合数
            //(1,2)->(ABA BAB,BAB ABB ..)+1
            //1 subset
            //问题集合subset

            int subsetcnt=0;
            for (List<Integer> subset : getsubstes(m-1)) {
                //对于这个问题组合能有几张问卷是不同的
                int cnt = 0;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i; j < n; j++) {
                        String wj1 = wjs[i];
                        String wj2 = wjs[j];
                        if (distinct(subset, wj1, wj2)) {
//                            System.out.println(i+" "+j);
                            cnt++;
                        }
                        if(cnt>=k)break;
                    }
                }
                if(cnt>=k)subsetcnt++;
            }
            System.out.println("Case #"+(Tcnt)+": "+subsetcnt);
            Tcnt++;

        }
    }

}
