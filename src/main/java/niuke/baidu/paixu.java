package niuke.baidu;

import java.util.Arrays;
import java.util.Scanner;

public class paixu {
    public static int ret;
    public static int reversePairs(int[] nums) {
        ret = 0;
        mergeSort(nums, 0, nums.length-1);
        return ret;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int middle = left + (right - left)/2;
        mergeSort(nums, left, middle);
        mergeSort(nums,middle+1, right);
        int count = 0;
        for (int l = left, r = middle+1; l <= middle;) {
            if (r > right || (long)nums[l] <= 2*(long)nums[r]) {
                l++;
                ret += count;
            } else {
                r++;
                count++;
            }
        }
        Arrays.sort(nums, left, right + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i <N ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(reversePairs(arr));
    }
}
