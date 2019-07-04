package niuke.codedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 毕业旅行2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i <n ; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j <n ; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }

        }
    }
}
