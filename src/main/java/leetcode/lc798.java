package leetcode;

public class lc798 {
    public int bestRotation(int[] A) {
        int maxrst = 0;
        int n = A.length;
        int maxk = 0;
        for(int k = 0;k<n;k++){

            int rst = 0;
            for(int i = 0;i<n-k;i++){
               int tmp =  A[k+i]-i<=0?1:0;
               rst+=tmp;


            }
            for(int i = 0;i<k;i++){
                int tmp = A[i]-(n-k+i)<=0?1:0;
                rst+=tmp;

            }
            if(rst>maxrst){
                maxrst = Math.max(rst,maxrst);
                maxk = k;
            }
//            System.out.println(rst);
        }
        return maxk;
    }

    public static void main(String[] args) {
        int[] A= {2, 3, 1, 4, 0};
        System.out.println((new lc798()).bestRotation(A));
    }
}
