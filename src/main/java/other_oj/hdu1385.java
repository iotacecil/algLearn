package other_oj;

import java.util.Arrays;
import java.util.Scanner;

/**

 5 城市数
 path cost
 0 3 22 -1 4
 3 0 5 -1 -1
 22 5 0 9 20
 -1 -1 9 0 4
 4 -1 20 4 0
 //经过每个城市收税
 5 17 8 3 1
 //起点 终点
 1 3
 //起点 终点
 3 5
 //起点 终点
 2 4
 -1 -1
 0


 From 1 to 3 :
 Path: 1-->5-->4-->3
 Total cost : 21

 From 3 to 5 :
 Path: 3-->4-->5
 Total cost : 16

 From 2 to 4 :
 Path: 2-->1-->5-->4
 Total cost : 17


 http://acm.hdu.edu.cn/showproblem.php?pid=1385
 Wrong Answer 估计是格式问题(?
 */
public class hdu1385 {
    static int start,end,citynum;
    static int[][] cost;
    static int[] tax;
    static int[][] path;

    private static void floyd(){
        for (int i = 0; i <citynum ; i++) {
            for (int j = 0; j <citynum ; j++) {
                path[i][j] = j;
            }
        }
        for (int k = 0; k < citynum; k++) {
            for (int i = 0; i <citynum ; i++) {
                for (int j = 0; j <citynum ; j++) {
                    int tmp = cost[i][k]+cost[k][j]+tax[k];
                    if(cost[i][j]>tmp){
                        cost[i][j] = tmp;
                        path[i][j] = path[i][k];
                    }
                    else if(cost[i][j] == tmp){
                        if(path[i][j]>path[i][k])
                            path[i][j] = path[i][k];
                    }
                }

            }

        }
    }
    private static void print(int s,int e){
        System.out.print(s+1);
        while (e!=s){
            System.out.printf("-->%d",path[s][e]+1);
            s = path[s][e];
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         citynum= sc.nextInt();
         cost = new int[citynum][citynum];
         path = new int[citynum][citynum];
         tax = new int[citynum];

             for (int i = 0; i <citynum ; i++) {
                 for (int j = 0; j <citynum ; j++) {
                     cost[i][j] = sc.nextInt();
                     if(cost[i][j]==-1)cost[i][j] = 111111111;
                 }
             }
             for (int i = 0; i <citynum ; i++) {
                 tax[i] = sc.nextInt();
             }

        while (sc.hasNextInt()){
             start = sc.nextInt();
             end = sc.nextInt();
//             System.out.println(Arrays.deepToString(cost));
             if(start==-1&&end==-1)break;

             System.out.printf("From %d to %d :\n",start,end);
             System.out.print("Path: ");
             //起点终点不算
            floyd();
//             System.out.println(Arrays.deepToString(cost));

             print(start-1, end-1);
             System.out.printf("Total cost : %d\n",cost[start-1][end-1]);
            System.out.println();
         }
    }
}
