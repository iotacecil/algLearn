package niuke.qh360;

import java.util.Arrays;
import java.util.List;

/*
5 6

1 2 3 5 6

3

2

1

4

5

6
 */
public class renwuliebiao {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = Arrays.asList(4,5,6);
        List<Integer> l3 = Arrays.asList();
        String[] split = "a,b,c".split(",");
        System.out.println("[a,b,c]".replaceAll("[\\[|\\]]", ""));
        System.out.println(split[0].charAt(0));


    }
//   static class tmptask{
//        int com;
//        int idx;
//
//        public tmptask(int com, int idx) {
//            this.com = com;
//            this.idx = idx;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[] ques = new int[N];
//        for (int i = 0; i <N ; i++) {
//            ques[i] = sc.nextInt();
//        }
//        PriorityQueue<tmptask> tmps = new PriorityQueue<>((a,b)->a.com-b.com);
//        for (int i = 0; i <M ; i++) {
//            tmps.add(new tmptask(sc.nextInt(),i));
//        }
//        PriorityQueue<Integer> slots = new PriorityQueue<>();
//
//        Arrays.sort(ques);
//        int[]rst = new int[M];
//        for (int i = 0; i <N ; i++) {
//            if(i>0)
////            System.out.println(ques[i-1]+" "+ques[i]+" "+tmps.peek().com);
//            while ((i==0&&ques[i]>tmps.peek().com`)||(i>0 &&ques[i]>ques[i-1]+1&&tmps.peek().com < ques[i])){
//                System.out.println(tmps.peek().com);
//                rst[tmps.peek().idx] = tmps.peek().com;
//                tmps.poll();
//            }
//
//        }
//        for (int i = 0; i <M ; i++) {
//            System.out.println(rst[i]);
//
//        }
//
//    }
}
