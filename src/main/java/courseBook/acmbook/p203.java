package courseBook.acmbook;

import java.util.Arrays;

public class p203 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int[][] graph = {
                {0,1,1,0},

                {0, 0, 1, 0},

                {0, 0, 0, 1},

                {1 ,0 ,0 ,0}
        };
        p199 sl = new p199();
        int[][] Gn = sl.pow(graph, k);
        int cnt  =0;

        for (int[] it:Gn) {
            for(int i:it){
                cnt+=i;
            }

        }
        System.out.println(cnt);
    }
}
