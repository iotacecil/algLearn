package gfg;

//给定区间上的最小元素位置
public class RMQ {

    //用dp复杂度n^2
    int[][] M;
    void process1(int A[])
    {
        int n = A.length;
        M = new int[n][n];
        int i, j;
        for (i =0; i < n; i++)
            M[i][i] = i;
        for (i = 0; i < n; i++)
            for (j = i + 1; j < n; j++)
                if (A[M[i][j - 1]] < A[j])
                    M[i][j] = M[i][j - 1];
                else
                    M[i][j] = j;
    }
    public int query(int start,int end){
        return M[start][end];
    }

    //稀疏表算法
//    Sparse Table (ST) algorithm
    int[][] ST;
    void process2(int A[])
    {
        int n = A.length;
        ST = new int[n][(int)Math.sqrt(n)];
        int i, j;

        //initialize M for the intervals with length 1
        for (i = 0; i < n; i++)
            ST[i][0] = i;
        //compute values from smaller to bigger intervals
        for (j = 1; 1 << j <= n; j++)
            for (i = 0; i + (1 << j) - 1 < n; i++)
                if (A[ST[i][j - 1]] < A[ST[i + (1 << (j - 1))][j - 1]])
                    ST[i][j] = ST[i][j - 1];
                else
                    ST[i][j] = ST[i + (1 << (j - 1))][j - 1];
    }
    public int queryST(int start,int end){
        return ST[start][end];
    }


    public static void main(String[] args) {
        RMQ rmq = new RMQ();
        int[] ints = {2, 4, 3, 1, 6, 7, 8, 9, 1, 7};
        rmq.process1(ints);
        System.out.println(rmq.queryST(2, 7));
    }
}
