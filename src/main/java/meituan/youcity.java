package meituan;

import java.util.Scanner;

class city{
//    from
//    td //->y
//    cost = c;
}
public class youcity {
    static int n;
    static int m;
    static int[] from = new int[m];
    static int[] des = new int[m];

    static int[] cost = new int[m];
    static int[] start = new int[m];
    static int[] end = new int[m];
    private static int next(int lastend,int curcost,int from,int n){
        int mincost = Integer.MAX_VALUE;
        int sf = Integer.MAX_VALUE;
        int choose = -1;
        int choose2 = -1;
        int ss = sf;
        int city = 1;

        while (city <= n) {
            for (int i = 0; i < m; i++) {
                if (from == city&&start[i]>lastend) {//第一个城市 //第二个城市
                    if (start[i] < sf) {
                        sf = start[i];
                        choose = i;
                    } else if (start[i] > ss && start[i] - sf > 30) {
                        ss = start[i];
                        choose2 = i;
                    }

                }
                if (choose2 == -1 || choose == -1) System.out.println(-1);
                else if (choose != -1 && choose2 != -1 && end[choose] == n) {
                    mincost = Math.min(mincost, cost[choose]);
                }
            }
            lastend = end[choose2];
            city=des[choose];
        }
        return choose;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String ss = sc.next();
//        String ss2 = sc.next();
//        System.out.println(ss+" "+ss2);
        //city
         n = sc.nextInt();
        //train
         m = sc.nextInt();
//        System.out.println(n + " " + m);


        for (int i = 0; i < m; i++) {
            from[i] = sc.nextInt();
            des[i] = sc.nextInt();
            cost[i] = sc.nextInt();
            String[] st = sc.next().split(":");
            start[i] = Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
            st = sc.next().split(":");
            end[i] = Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);

//            String[] time =
//            start[i]=Integer.parseInt()
        }
        int city =1;
        int curcost = 0;
//        while()

    }

}
