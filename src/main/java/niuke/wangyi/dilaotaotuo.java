package niuke.wangyi;

import java.util.Scanner;

public class dilaotaotuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i <n ; i++) {
            String row = sc.next();
            for (int j = 0; j <n ; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        int stepn = sc.nextInt();
        int[][] steps = new int[stepn][2];
        for (int i = 0; i <stepn ; i++) {
            steps[i][0] = sc.nextInt();
            steps[i][1] = sc.nextInt();
        }

    }
//    public static int howstep(int n,int m ,int x0,int y0,char[][] map,int stepn,int[][] steps){
//
//
//    }
}
