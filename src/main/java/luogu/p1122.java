package luogu;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
7
1
1
1
1
1
1
1
1 3
2 3
6 4
7 4
4 5
3 5
0 0

 */
public class p1122 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n+1];
        int[] ru = new int[n+1];
        int[] fa = new int[n+1];
        for (int i = 0; i <n ; i++)
            score[i] = sc.nextInt();
        for (int i = 0; i <n-1 ; i++) {
            int s = sc.nextInt();
            int f = sc.nextInt();
            ru[f]++;
            fa[s] = f;
        }
        Queue<Integer> que = new ArrayDeque<>();
//0 不来， 1 来
        int maxval = 0;
        int[][] dp = new int[n+1][2];
        for (int i = 1; i <=n ; i++) {
            if(ru[i] == 0){
                que.add(i);
            }
        }
        while (!que.isEmpty()){
            int size = que.size();
            while (size-->0) {
                Integer son = que.poll();
                dp[son][1] += score[son];
                int f = fa[son];
                ru[f]--;
                if(ru[f] ==0)que.add(f);
                dp[f][0] = Math.max(dp[f][0]+dp[son][1], dp[f][0] +dp[son][0]) ;
                dp[f][1] += dp[son][0];

                maxval = Math.max(Math.max(maxval, dp[son][0]),dp[son][1] );
            }

        }
        System.out.println(maxval);



    }
}
