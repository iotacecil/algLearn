package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lc939 {
    public int minAreaRect(int[][] points) {
        Set<Integer> pset = new HashSet<>();
        for(int[] p : points){
            pset.add(p[0]*100000 + p[1]);
        }
        int n = points.length;
//        Arrays.sort(points,(a, b) -> a[0] - b[0] !=0? a[0] - b[0] :a[1]-b[1]);
//        System.out.println(Arrays.deepToString(points));
        int ma = Integer.MAX_VALUE;
        for(int i =0;i < n-1;i++){
            for(int j = i + 1;j<n;j++){
                if(points[j][0] == points[i][0] || points[j][1] == points[i][1])continue;
                if(pset.contains(points[i][0]*100000 + points[j][1])&&pset.contains(points[j][0]*100000 + points[i][1])){
                    ma = Math.min(ma,Math.abs((points[j][0] - points[i][0]) * (points[j][1] - points[i][1])));
                }
            }
        }
        return ma;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}};
        lc939 sl = new lc939();
        System.out.println(sl.minAreaRect(points));
    }
}
