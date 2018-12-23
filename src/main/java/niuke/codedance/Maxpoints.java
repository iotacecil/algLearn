package niuke.codedance;

import java.io.*;
import java.util.*;

public class Maxpoints {

//    private static List<int[]> maxpoints(int[][] points,int n){
//        Arrays.sort(points,(a, b) ->  a[0]-b[0] != 0? a[0]-b[0]:a[1]-b[1]);
////        Arrays.sort(points, new Comparator<int[]>() {
////            @Override
////            public int compare(int[] a, int[] b) {
////                return a[0] - b[0];
////            }
////        });
////        System.out.println(Arrays.deepToString(points));
//        List<int[]> rst = new ArrayList<>(n);
//        int maxy = points[n-1][1];
//        for (int i = n-1; i>=0  ; i--) {
//            if(points[i][1] >= maxy){
//                rst.add(points[i]);
//                maxy = points[i][1];
//            }
//
//        }
//        return rst;
//    }


    public static void main(String[] args) throws IOException {

        int n = nextInt();
        long[][] points = new long[n][2];

        for (int i = 0; i <n ; i++) {
            points[i][0] = nextLong();
            points[i][1] = nextLong();
        }
        Arrays.sort(points,(a, b) ->  a[0]-b[0] != 0? (int)(a[0]-b[0]):(int)(a[1]-b[1]));
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                return a[0] - b[0];
//            }
//        });
//        System.out.println(Arrays.deepToString(points));
//        int[][] mpoints = new int[n][2];
        long maxy = points[n-1][1];
        for (int i = n-1; i>=0  ; i--) {
            if(points[i][1] >= maxy){
//                mpoints.add(points[i]);
                maxy = points[i][1];
            }else {
                points[i][0] = Integer.MIN_VALUE;
                points[i][1] = Integer.MIN_VALUE;
            }

        }

        for (int i = n-1; i >=0 ; i--) {
            if(points[i][0] == Integer.MIN_VALUE)continue;
            System.out.printf("%d %d\n",points[i][0],points[i][1]);
             }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    static StreamTokenizer in = new StreamTokenizer(br);
//    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    static char nextChar() throws IOException {
        in.nextToken();
        return in.sval.charAt(0);
    }

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    static float nextFloat() throws IOException {
        in.nextToken();
        return (float) in.nval;
    }

    static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }
}
