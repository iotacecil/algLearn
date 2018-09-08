package gfg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//        5 2
//        4 3 3
//        2 2 7
//        样例输出
//        1 4 3 2 5
public class cspcommkey {

    //按1，2，3哪一列排序？
    private static void Sort(int[][] a,int i){
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[i]==o2[i])return o1[0]-o2[0];
                return o1[i]-o2[i];

            }
        });
    }

    static int res[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //教室数量
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[][] = new int[k][3];
        for (int i = 0; i < k ; i++) {
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
            //结束时间
            a[i][2]=sc.nextInt()+a[i][1];
        }
        int as[][] =a.clone();
        int ae[][] =a.clone();
        Sort(as,1);
        Sort(as,2);
        res = new int[n+1];
        //钥匙架 5把钥匙
        for (int i = 0; i <res.length ; i++) {
            res[i]=i;

        }
        int t = 0;
        int s = 0,e=0;
        while(t++<10101){

        }

    }
}
