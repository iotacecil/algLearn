package gfg.tsp;

import java.util.ArrayList;
import java.util.Random;

public class tspDPbook {
    private ArrayList<Integer> outputArray = new ArrayList<Integer>();
    private int g[][], p[][], npow, N, d[][];
    public static long time;

    public tspDPbook() {
    }

    public ArrayList<Integer> computeTSP(int[][] inputArray, int n) {
        long start = System.nanoTime();
        N = n;
        npow = (int) Math.pow(2, n);
        g = new int[n][npow];
        p = new int[n][npow];
        d = inputArray;
        int i, j, k, l, m, s;
        for (i = 0; i < n; i++) {
            for (j = 0; j < npow; j++) {
                g[i][j] = -1;
                p[i][j] = -1;
            }
        }
        //initialize based on distance matrix
        for (i = 0; i < n; i++) {
            g[i][0] = inputArray[i][0];
        }
        int result = tsp(0, npow - 2);
        outputArray.add(0);
        getPath(0, npow - 2);
        outputArray.add(result);
        long end = System.nanoTime();
        time = (end - start) / 1000;
        System.out.println("用时"+time);
        return outputArray;
    }

    private int tsp(int start, int set) {
        int masked, mask, result = -1, temp;
        if (g[start][set] != -1) {
            return g[start][set];
        } else {
            for (int x = 0; x < N; x++) {
                mask = npow - 1 - (int) Math.pow(2, x);
                masked = set & mask;
                if (masked != set) {
                    temp = d[start][x] + tsp(x, masked);
                    if (result == -1 || result > temp) {
                        result = temp;
                        p[start][set] = x;
                    }
                }
            }
            g[start][set] = result;
            return result;
        }
    }

    private void getPath(int start, int set) {
        if (p[start][set] == -1) {
            return;
        }
        int x = p[start][set];
        int mask = npow - 1 - (int) Math.pow(2, x);
        int masked = set & mask;
        outputArray.add(x);
        getPath(x, masked);
    }

    public static void main(String[] args) {
        int n = 23;
        Random rnd = new Random(1024);
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    cost[i][j] = rnd.nextInt(30) + 10;
                    continue;
                }
                cost[i][j] = rnd.nextInt(50) + 5;
            }
        }
            int[][] inputArray = {
                    {0, 10, 15, 20},
                    {10, 0, 35, 25},
                    {15, 35, 0, 30},
                    {20, 25, 30, 0}
            };
            tspDPbook sl = new tspDPbook();
            System.out.println(sl.computeTSP(cost, n));

        }

    }

