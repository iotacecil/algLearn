package niuke.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class meituanBA {


    public static void main(String[] args) {
        class line {
            private int x;
            int y;
            boolean out;
            String t;

            public line(int x, int y, boolean out, String t) {
                this.x = x;
                this.y = y;
                this.out = out;
                this.t = t;
            }

            @Override
            public String toString() {
                return "line{" +
                        "x=" + x +
                        ", y=" + y +
                        ", out=" + out +
                        ", t='" + t + '\'' +
                        '}';
            }
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n+1][m+1];
        int k = sc.nextInt();
        List<line> lines = new ArrayList<>();
        for (int i = 1; i <=k ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int o = sc.nextInt();
            boolean out = o==1?true:false;

            line one = new line(x,y,out,sc.next());
            lines.add(one);
        }

        lines.sort((aa,bb)->aa.t.compareTo(bb.t));
//        System.out.println(lines);
        int cnt =0,max=0,t=0;
        for (int i = 1; i <= k; i++) {

            int x=lines.get(i-1).x;
            int y = lines.get(i-1).y;
//            System.out.println("x:"+x+"y:"+y);
            boolean in = !lines.get(i-1).out;
            if(in&&a[x][y]==0){
                a[x][y]++;
                cnt++;
            }else if(!in){
                a[x][y]--;
                if(a[x][y]==0){

                    cnt--;
                }
            }
            if(cnt>=max){
//                System.out.println("第"+i+"最大值是"+cnt);
                max = cnt;
                t = i;

            }

        }
      int[][] ab = new int[n+1][m+1];
        a=ab;
        for (int i = 1; i <=t ; i++) {
            int x=lines.get(i-1).x;
            int y = lines.get(i-1).y;

            a[x][y]=lines.get(i-1).out?-1:1;
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {

                System.out.print(a[i][j]);


            }
            System.out.println();
        }



    }
}


//
//        2 2 4
//        1 1 0 18:00:00.000
//        1 1 1 20:00:00.000
//        1 1 0 18:00:01.000
//        1 2 0 18:00:02.000
