package other_oj;

import java.io.*;
import java.util.Scanner;

//平方分割 归并树
public class poj2104 {
    final int MAX_N = 100001;
    static int[] A;
    final static int ST_SIZE = (1<<18)-1;
    int[] dat = new int[ST_SIZE];
    void init(int k,int l,int r){
        if(r-l == 1){
        }
    }
    /**
     * //用线段树 每个节点对应区间排好序的结果 归并树O(nlogn)建立树
     * 查询q(i,j,k) num [i-1,j-1]排序后的第[k-1]个数
     * @
     * @param q
     * @return
     */
    public int query(int[] q){
        return 0;

    }
    public static void main(String[] args) throws IOException {
        System.out.println(ST_SIZE);
        int n = nextInt();
        //m个三元组查询 m<5000 查询数量大
        int m = nextInt();
        A = new int[n];
        for (int i = 0; i <n ; i++) {
            A[i] = nextInt();
        }
        int[][]query = new int[m][3];
        for (int i = 0; i <m ; i++) {
            query[i][0] = nextInt();
            query[i][1] = nextInt();
            query[i][2] = nextInt();
        }



        out.println();
        out.flush();
        out.close();
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    static StreamTokenizer in = new StreamTokenizer(br);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    static char nextChar() throws IOException {
        in.nextToken();
        return in.sval.charAt(0);
    }

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    static float nextFloat() throws IOException {
        in.nextToken();
        return (float) in.nval;
    }

    static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }
}
