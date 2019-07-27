package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;

//个工作可以被多个人选择。
//在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作
public class 牛牛找工作2019 {
    public static void main(String[] args) {

//        int[] arrrr ={1,3,4,5,6,7};
//        System.out.println(-(Arrays.binarySearch(arrrr, 2)+1));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] work = new int[n][2];
        // 难度 报酬
        for (int i = 0; i < n; i++) {
            work[i][0] = sc.nextInt();
            work[i][1] = sc.nextInt();
        }
        //按难度排序
        Arrays.sort(work, (a, b) -> a[0] - b[0]);
        //更新报酬，当前难度只保留能获得的最大报酬
        for (int i = 1; i < n; i++) {
            work[i][1] = Math.max(work[i][1], work[i - 1][1]);
        }
        //然后应该对每个难度二分查找floor的报酬


        int[] user = new int[m];
        int[] best = new int[m];
        for (int i = 0; i < m; i++) {
            user[i] = sc.nextInt();
        }
        int[] nandu = new int[n];
        for (int i = 0; i < n; i++) {
            nandu[i] = work[i][0];
        }
//        System.out.println(Arrays.toString(nandu));
        for (int i = 0; i < m; i++) {
            int i1 = Arrays.binarySearch(nandu, user[i]);
            if (i1 < 0) {
                i1 = -(i1 + 1) - 1;
            }
//            System.out.println(i1);
            if (i1 < 0) System.out.println(-1);
            else
                System.out.println(work[i1][1]);

        }

    }
}
