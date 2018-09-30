package leetcode;

public class lc915 {
    private boolean can(int[] A,int l){

        int n = A.length;
        int left = A[0];
        int right = A[l];
//        System.out.println("l="+l);
        int i = 0,j = l;
        //left=[0,l) right = [l,n)

            while (i<l)
            left = Math.max(left,A[i++]);
            while (j<n)
            right = Math.min(right,A[j++]);
        System.out.println(left+" "+right);
            if(left>right)return false;

        return true;
    }
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int min = A.length;
        //左边长度[1,n)
        for(int l=1;l<n;l++){
            if(can(A,l)){
                min=Math.min(l,min);

            };
        }
        return min;
    }
    public static void main(String[] args) {
int[] num = {26,51,40,58,42,76,30,48,79,91};
//[1,1,1,0,6,12]
//[26,51,40,58,42,76,30,48,79,91]
        lc915 sl = new lc915();
        System.out.println(sl.partitionDisjoint(num));
    }
}
