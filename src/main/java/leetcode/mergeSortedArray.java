package leetcode;

import java.util.Arrays;

public class mergeSortedArray {
    public static void merge(int[] nums1,int m,int[] nums2,int n){
       int p = m-- + n-- -1;//m= 2,n = 5,p = 6
        while (m>=0&&n>=0){
            nums1[p--] = nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
        }
        while (n>=0){
            //m个元素本来就在nums1里，m最后可能有几个最小的没动过m>0
            nums1[p--]=nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] a =new int[10];
        a[1]=1;
        a[2]=3;
        int[] b = {5,6,7,8,9};
        int m = 3;
        int n = b.length;
        merge(a,m,b,n);
        System.out.printf(Arrays.toString(a));
    }
}
