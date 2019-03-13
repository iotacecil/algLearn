package leetcode;

public class lc88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n-1;
        int i = m-1;
        int j = n-1;
        while(len>=0){
            int tmp =0;
            if(j==0 || (i>=0 && j>=0 && nums1[i] >= nums2[j])){
                tmp = nums1[i];
                i--;
            }else if(i==0 || (i>=0 && j>=0 && nums1[i] < nums2[j])) {
                tmp = nums2[j];
                j--;
            }
            nums1[len--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        lc88 sl = new lc88();
        sl.merge(arr1, 3, arr2, 3);
    }
}
