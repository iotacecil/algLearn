package niuke.pdd;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
/*
输入
复制
5 5
02111
01a0A
01003
01001
01111
输出
复制
7
 */

public class migong {
    static class Node {
        int x;
        int y;
        int key;

        public Node(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;

        }

        @Override
        public String toString() {
            return "node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", keys=" + key +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] Graph = new char[n][m];
        int[] start = {-1, -1};

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                Graph[i][j] = line.charAt(j);
                if (Graph[i][j] == '2') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        System.out.println(bfs(start, Graph, n, m));


    }

    private static int bfs(int[] start, char[][] Graph, int n, int m) {
        int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

        Queue<Node> que = new ArrayDeque<>();
        boolean[][][] marked = new boolean[n][m][1200];
        // marked[start[0]][start[1]][0] = true;
        que.add(new Node(start[0], start[1], 0));
//
        int step = 0;
//        out:
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
//                    System.out.println(que);
                Node top = que.poll();
                for (int[] dir : dirs) {
                    int nx = top.x + dir[0];
                    int ny = top.y + dir[1];
                    int key = top.key;

                    if (nx >= n || nx < 0 || ny >= m || ny < 0 || Graph[nx][ny] == '0') {
                        continue;
                    }
                    char next = Graph[nx][ny];

                    if (next == '3') {
                        return step + 1;
                    } else if (next >= 'a' && next <= 'z') {
                        key |= (1 << (next - 'a'));
                    } else if (next >= 'A' && next <= 'Z' && (key & (1 << (next - 'A'))) == 0) {
                        continue;
                    }
//

                    if (!marked[nx][ny][key]) {
                        marked[nx][ny][key] = true;
                        que.offer(new Node(nx, ny, key));
                    }
                }
            }
            step++;
        }
        return -1;
    }

//    private static int bfs(int si, int sj,int N,int M,char[][] G) {
//        Queue<Node> queue=new LinkedList<>();
//        int[][][] mp=new int[101][101][1025];
//        int[][] next={{-1,0},{0,-1},{1,0},{0,1}};
//        int step = 0;
//        queue.offer(new Node(si,sj,0));
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            while (size-->0) {
//                Node node = queue.poll();
//                for (int i = 0; i < 4; i++) {
//                    int x = node.x + next[i][0];
//                    int y = node.y + next[i][1];
//                    int key = node.key;
//                    if (x < 0 || x >= N || y < 0 || y >= M || G[x][y] == '0') continue;
//                    else if (G[x][y] == '3') return step + 1;
//                    else if (G[x][y] <= 'z' && G[x][y] >= 'a') key = key | (1 << (G[x][y] - 'a'));
//                    else if (G[x][y] <= 'Z' && G[x][y] >= 'A' && (key & (1 << (G[x][y] - 'A'))) == 0) continue;
//                    if (mp[x][y][key] == 0) {
//                        mp[x][y][key] = 1;
//                        queue.offer(new Node(x, y, key));
//                    }
//                }
//            }
//
//
//            step++;
//        }
//        return -1;
//    }


}
