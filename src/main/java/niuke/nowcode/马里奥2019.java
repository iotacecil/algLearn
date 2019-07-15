package niuke.nowcode;

import java.util.Scanner;

/*
7 4
10 0 2 1 1 0 1

3
 */
public class 马里奥2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr[P - 1] == 0) System.out.println(-1);
        else {
            boolean[] visited = new boolean[N + 1];
            int cnt = dfs(arr, P - 1, visited);
            System.out.println(cnt);

        }
    }

    private static int dfs(int[] arr, int from, boolean[] visited) {
        if (from >= arr.length) return 0;
        visited[from] = true;
        int step = arr[from];
        if (step == 0) return -1;
        int min = Integer.MAX_VALUE;
        for (int i = Math.max(0, from - step); i <= Math.min(from + step, arr.length); i++) {
            if (visited[i]) continue;
            int jump = dfs(arr, i, visited);
            if (jump >= 0 && jump + 1 < min) {
                min = jump + 1;
            }

        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


}
