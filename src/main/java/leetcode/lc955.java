package leetcode;

public class lc955 {
    public int minDeletionSize(String[] A) {
        int n = A.length;
        int len = A[0].length();

        int cnt =0;
        for(int i =0;i<len;i++){
            boolean flag = false;
            for(int j = 1;j<n;j++){
                if(A[j].charAt(i) - A[j-1].charAt(i) <0 ){
                    cnt++;
                    flag = true;
                    break;
                }
                if(!flag && A[j].charAt(i) - A[j-1].charAt(i) == 0){
                    flag = true;
                }
            }
            if(!flag)
                return cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String[] A = {"xga","xfb","yfa"};
        lc955 sl = new lc955();
        System.out.println(sl.minDeletionSize(A));
    }
}
