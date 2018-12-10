package niuke.weipinhui;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Matric_k_min {

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> que = new PriorityQueue(k);
        for(int[] row:matrix){
            for(int x :row){
                que.add(x);
            }
        }
        for(int i = 0;i<k-1;i++){
            que.poll();
        }
        return que.peek();
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(kthSmallest(matrix, k));
    }
}
