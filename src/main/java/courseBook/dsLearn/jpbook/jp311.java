package courseBook.dsLearn.jpbook;

public class jp311 {
    //(left,right]
    public int idx(int[] a, int k) {
        int l = -1, h = a.length;
        while (h - l > 1) {
            int mid = (l + h) / 2;
            if (a[mid] >= k) {
                h = mid;
            } else {
                l = mid;
            }
        }
        //l+1=h
        return h;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] a = {2, 3, 3, 5, 6};
        int k = 6;
        jp311 sl = new jp311();
        System.out.println(sl.idx(a, k));
    }
}
