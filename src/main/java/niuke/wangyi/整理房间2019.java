package niuke.wangyi;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

//果一团杂物的4个点构成了一个面积不为0的正方形，我们说它是紧凑的。
public class 整理房间2019 {


    public static double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0]) && dist(p[0], p[3]) == dist(p[1], p[2]);
    }


//    判断4点是否是正方形
//    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
//
//        long[] dis = new long[6];
//        int[][] points = new int[4][2];
//        points[0] = p1;
//        points[1] = p2;
//        points[2] = p3;
//        points[3] = p4;
//        Set<Double>dist = new HashSet<>();
//        int cnt = 0;
//        for(int i = 0;i<3;i++){
//            for(int j = i+1;j<4;j++){
//
//                double dis2 = (points[i][0]-points[j][0])*(points[i][0]-points[j][0]) + (points[i][1]-points[j][1])*
//                        (points[i][1]-points[j][1]);
//                dist.add(dis2);
////                if(dis2<0){
////                    System.out.println( (points[i][0]-points[j][0])*(points[i][0]-points[j][0]) );
////                    System.out.println( (points[i][1]-points[j][1])*
////                            (points[i][1]-points[j][1]) );
////                }
//                dis[cnt++] = dis2;
//            }
//        }
//
//        if (dist.size()==2) {
//            Arrays.sort(dis);
//            System.out.println(Arrays.toString(dis));
//            System.out.println(dist);
//        }
//        return dist.size()==2;
//    }

    // 点 x1,y1绕点x0,y0 顺时针旋转k读之后的点
    public static int[] rotate(double k, int x1, int y1, int x0, int y0) {
        k = Math.toRadians(k);
        double x2 = (x1 - x0) * Math.cos(k) + (y1 - y0) * Math.sin(k) + x0;
        double y2 = -(x1 - x0) * Math.sin(k) + (y1 - y0) * Math.cos(k) + y0;
//        System.out.println(x2+" "+y2);
        return new int[]{(int) Math.round(x2), (int) Math.round(y2)};
    }

    @Test
    public void testrotate() {
//        System.out.println(Arrays.toString(rotate(180, -1 ,1, -9999 ,9999)));

        System.out.println();
        System.out.println(validSquare(rotate(2, -1, 1, -9999, 9999), rotate(2, -1, -1, 9998, 9998), rotate(2, -1, 1,
                9998, -9998), rotate(2, -1, -1, -9999, -9999)));
        System.out.println(validSquare(rotate(0, -1, 1, -9999, 9999), rotate(0, -1, -1, 9998, 9998), rotate
                (0, -1, 1,
                        9998, -9998), rotate(0, -1, -1, -9999, -9999)));
    }
    // 坐标逆时针旋转90度

    public static int[] rotate(int t, int x1, int y1, int x0, int y0) {


        for (int i = 0; i < t; i++) {
            int lastx1 = x1;
            x1 = x0 - (y1 - y0);
            y1 = y0 + (lastx1 - x0);
//            System.out.println(x1+" "+y1+" "+x0+" "+y0);
        }

        return new int[]{x1, y1};
    }

//    public static int len_2(int x1, int x2, int y1, int y2) {
//        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
//    }
//    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
//        HashSet<Integer> hs = new HashSet<>(Arrays.asList(dis(p1, p2), dis(p1, p3), dis(p1, p4), dis(p2, p3), dis(p2, p4), dis(p3, p4)));
//        return !hs.contains(0) && hs.size()==2; //One each for side & diagonal
//    }
//    static int dis(int[] a, int[] b){
//        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
//    }


//    private static long dis(int[] neePoint1, int[] neePoint2) {
//        long x = neePoint1[0] - neePoint2[0];
//        long y = neePoint1[1] - neePoint2[1];
//        return (x * x + y * y);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] a = new int[]{sc.nextInt(), sc.nextInt()};
            int[] ax = new int[]{sc.nextInt(), sc.nextInt()};
            int[] b = new int[]{sc.nextInt(), sc.nextInt()};
            int[] bx = new int[]{sc.nextInt(), sc.nextInt()};

            int[] c = new int[]{sc.nextInt(), sc.nextInt()};
            int[] cx = new int[]{sc.nextInt(), sc.nextInt()};
            int[] d = new int[]{sc.nextInt(), sc.nextInt()};
            int[] dx = new int[]{sc.nextInt(), sc.nextInt()};
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 4; l++) {
                            int[] ra = rotate(i, a[0], a[1], ax[0], ax[1]);
                            int[] rb = rotate(j, b[0], b[1], bx[0], bx[1]);
                            int[] rc = rotate(k, c[0], c[1], cx[0], cx[1]);
                            int[] rd = rotate(l, d[0], d[1], dx[0], dx[1]);
                           /*
                          -1 1 -9999 9999
-1 -1 9998 9998
-1 1 9998 -9998
-1 -1 -9999 -9999
2 2 2 2
[Node{a=-19997, b=19997, x=-9999, y=9999},
Node{a=19997, b=19997, x=9998, y=9998},
 Node{a=19997, b=-19997, x=9998, y=-9998},
 Node{a=-19997, b=-19997, x=-9999, y=-9999}]
8

                           [-1, 19997]
[19997, 19997]
[-1, -19997]
[-19997, -19997]
                            */

                            if (validSquare(ra, rb, rc, rd)) {
//                               System.out.println(i+" "+j+" "+k+" "+l);
//                               System.out.println(Arrays.toString(ra));
//                           System.out.println(Arrays.toString(rb));
//                           System.out.println(Arrays.toString(rc));
//                           System.out.println(Arrays.toString(rd));

                                min = Math.min(j + i + k + l, min);
                            }
                        }

                    }

                }

            }
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);

        }
    }
}
