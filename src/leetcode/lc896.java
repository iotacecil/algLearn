package leetcode;

public class lc896 {
    public boolean isMonotonic(int[] A) {

        if(A==null||A.length<1)return false;
        int n = A.length;
        if(n==1)return true;
        int flag = 1;
        for(int i=1;i<n-1;i++){
            if(A[i]==A[i-1])continue;
            flag = A[i]-A[i-1];
            while(i<n-1){
                while(i<n-1&&A[i+1]-A[i]==0)i++;
                if(i<n-1&&(A[i+1]-A[i])*flag<0)return false;
                i++;
            }

        }
        return true;



    }

    public static void main(String[] args) {
        lc896 sl = new lc896();
        System.out.println(sl.isMonotonic(new int[]{6, 5, 4, 4}));
    }
}
