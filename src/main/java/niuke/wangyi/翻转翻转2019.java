package niuke.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
10
246821988 155498441
894573536 163830076
259233343 20643709
728170780 241950052
376272471 106603020
825937572 406163990
154596687 81424208
532226450 296892720
279434459 43814520
908568407 7386135
 */
public class 翻转翻转2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line1 = bf.readLine();
        int t = Integer.parseInt(line1);
        for (int i = 0; i < t; i++) {

            String[] line2 = bf.readLine().split(" ");
            long n = Long.parseLong(line2[0]);
            long m = Long.parseLong(line2[1]);
            if (n == 1) {
                if (m == 1) {
                    System.out.println(1);
                    continue;
                } else if (m == 2) {
                    System.out.println(0);
                    continue;
                } else {
                    System.out.println(m - 2);
                    continue;
                }
            } else if (m == 1) {
                if (n == 1) {
                    System.out.println(1);
                    continue;
                } else if (n == 2) {
                    System.out.println(0);
                    continue;
                } else {
                    System.out.println(n - 2);
                    continue;
                }
            } else {
                System.out.println((n - 2) * (m - 2));
            }

            //[0,0] (0,0) (0,1)(1,0)(1,1)
//            int[][] cnt = new int[n][m];
//            for (int i = 0; i <n ; i++) {
//                for (int j = 0; j <m ; j++) {
//                    cnt[i][j]+=1;
//                    for(int[] dir:dirs){
//                        int nx = dir[0]+i;
//                        int ny = dir[1]+j;
//                        if(nx<n&&nx>=0&&ny<m&&ny>=0)
//                        cnt[nx][ny]+=1;
//                    }
//
//                }
//
//            }
//
//            int rst = 0;
//            for (int i = 0; i <n ; i++) {
//                for (int j = 0; j <m ; j++) {
//                    if(cnt[i][j]%2!=0)rst++;
//
//                }
//
//            }
//            System.out.println(rst);

        }
    }
}
