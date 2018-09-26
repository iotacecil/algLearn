package other_oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
//http://poj.org/problem?id=3276
//4972K	2735MS
public class poj3276 {
    // 求最小操作次数m和对应的k
    static int[] niu;
    public static void main(String[] args) {
//        int N = 7;
//        String niu = "BBFBFBB";
      
        //全部变成F的最少次数M和 最小K 连续K头牛转向
        //每次反转最左边的B的牛,问题规模缩小
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        niu = new int[n];
        for (int i = 0; i < n; i++) {
            niu[i] = sc.nextLine().equals("F")?0:1;
        }
        solve(niu);
    }

    /**
     * 固定反转长度k 求最小操作次数M
     * @param K
     * @return
     */

    static private int calc(int K){
        int n = niu.length;
        //区间[i,i+K-1]进行反转则1
        int[] f = new int[niu.length];
        int res = 0;
        int sum = 0; //f的累加
        //注意==  len = 10  i=7 k = 3 flip 7,8,9
        for (int i = 0; i+K <=n ; i++) {
            //区间[i,i+K-1] 是奇数了,
            if((niu[i]+sum)%2!=0){
                //需要翻转
                res++;
                f[i] = 1;
            }
            sum+=f[i];
            //??
            if(i-K+1>=0){
                sum-=f[i-K+1];
            }
        }
        for (int i = n-K+1; i < n; i++) {
            if((niu[i]+sum)%2!=0)return -1;
            if(i-K+1>=0)sum-=f[i-K+1];
        }
        return res;
    }
   static private void solve(int[] f){
//        PrintWriter out = new PrintWriter(System.out);

        int K = 1,M = f.length;
        for (int k = 1; k <=f.length ; k++) {
            int m = calc(k);
            if(m>=0&&M>m){
                M = m;
                K = k;
            }

        }
        System.out.printf("%d %d\n",K,M);
    }

    //快速IO
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            try	{
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer(br.readLine());
            } catch (Exception e){e.printStackTrace();}
        }

        public String next() {
            if (st.hasMoreTokens())	return st.nextToken();
            try {st = new StringTokenizer(br.readLine());}
            catch (Exception e) {e.printStackTrace();}
            return st.nextToken();
        }

        public int nextInt() {return Integer.parseInt(next());}

        public long nextLong() {return Long.parseLong(next());}

        public double nextDouble() {return Double.parseDouble(next());}

        public String nextLine() {
            String line = "";
            if(st.hasMoreTokens()) line = st.nextToken();
            else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
            while(st.hasMoreTokens()) line += " "+st.nextToken();
            return line;
        }
    }

}
