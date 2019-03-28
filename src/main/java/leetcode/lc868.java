package leetcode;

public class lc868 {
    // 101
    public int binaryGap(int N) {
        int rst = 0;
        int start = 0;
        int cnt = 0;
        while (N!=0){
            if((N&1)==1){
                rst = Math.max(rst, cnt-start+1);
                start = cnt;
            }
            cnt++;
            N >>>= cnt;
        }
        return rst;
    }

    public static void main(String[] args) {
       lc868 sl = new lc868();
        System.out.println(sl.binaryGap(22));

    }
}
