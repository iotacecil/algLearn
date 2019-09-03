package niuke;

import java.util.Arrays;
import java.util.Scanner;
//cf557c
//http://codeforces.com/problemset/problem/557/C
public class 修理桌子 {
    static class desk{
        int h;
        int cost;

        public desk(int h, int cost) {
            this.h = h;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] h = new int[n];
        desk[] desks = new desk[n];
        for (int i = 0; i <n ; i++) {
            desks[i] = new desk(h[i],sc.nextInt());
        }

        Arrays.sort(desks,(a,b)->a.h==b.h?a.cost-b.cost:b.h-a.h);
        /*
        以某长度Li的桌腿作为最长桌腿，那么大于Li的桌腿全部砍去，小于的部分则砍去最少的，
        花费最小的桌腿，不断枚举Li，用基排的思想，复杂度n*d；
         */
        for (int i = 0; i <n ; i++) {


        }



    }
}
