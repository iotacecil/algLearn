package leetcode;

public class lc278 {
    boolean isBadVersion(int n){
//        int[] list = {1,2,3,4,5,6,7};
        if(n >= 5)return true;
        else return false;
    }
    public int firstBadVersion(int n) {
        int l = 1,h = n;
        while(l < h){
            int mid = l+(h-l)/2;
            if(isBadVersion(mid)){
                h = mid;
            }else{
                l = mid +1;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        lc278 sl = new lc278();
        sl.firstBadVersion(10);
    }
}
