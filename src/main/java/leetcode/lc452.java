import java.util.Arrays;

public class lc452 {
//    [[10,16], [2,8], [1,6], [7,12]]
//
//    Output:
//            2

    public static int findMinArrowShots2(int[][] points) {
        if (points == null) {
            return 0;
        }
        int shots = 0;
         Arrays.sort(points, (a, b) -> a[1] - b[1]);
        System.out.println(Arrays.deepToString(points));

        for (int i = 0; i < points.length; i++) {
            int current = points[i][1];
            shots++;
            System.out.println(i);
            while (i + 1 < points.length && points[i + 1][0] <= current && current <= points[i + 1][1]) {
                i++;
            }
        }
        return shots;
    }
public static void main(String[] args) {
    System.out.println(findMinArrowShots(new int[][]{{1, 3}, {2, 5}, {4, 7},{6,9}}));
}
    public static int findMinArrowShots(int[][] points) {
        if(points==null||points.length<1) return 0;

        int cnt =1;
        //按开始排序
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int begin = points[0][0];
        int end = points[0][1];
        for (int i = 0; i < points.length ; i++) {
            if(points[i][0]<=end){
                begin = points[i][0];
                if(points[i][1]<end)
                    end = points[i][1];
            }else{
                cnt++;
                begin = points[i][0];
                end = points[i][1];

            }
        }
        return cnt;
    }
}
