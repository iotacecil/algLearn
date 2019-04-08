package niuke.codedance;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”
 */
public class test2018_01 {
    class point{
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //0 0 0 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ps = new int[n][2];
        for (int i = 0; i < n; i++) {
            ps[i][0] = sc.nextInt();
            ps[i][1] = sc.nextInt();
        }
        List<int[]> rst = new ArrayList<int[]>();
        Arrays.sort(ps,(a,b)->(a[0]-b[0]==0)?a[1]-b[1]:a[0]-b[0]);
        int tmpx = ps[n-1][0];
        int tmpy = ps[n-1][1];
// 0,0 1,0
        for (int i = n-1; i >=0 ; i--) {
            if(ps[i][0] == tmpx){
                tmpy = ps[i][0];
            }else {
                rst.add(new int[]{tmpx,tmpy});
                tmpx = ps[i][0];
                tmpy = ps[i][1];
            }
        }

    }
}
