package leetcode;

import java.util.Arrays;

public class lc63 {
    public int uniquePathsWithObstacles(int[][] obs) {
        int len = obs[0].length;
        int[] res = new int[len];
        res[0]=1;
        for(int i =0;i<obs.length;i++){
            for(int j=0;j<obs[0].length;j++){
                //是障碍
                if(obs[i][j]==1){
                    res[j]=0;
                }else if(j>0){
                    res[j]+=res[j-1];
                }
            }
            System.out.println(Arrays.toString(res));

        }
        return res[len-1];}
    public static void main(String[] args) {
        lc63 sl = new lc63();
        System.out.println(sl.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

}
