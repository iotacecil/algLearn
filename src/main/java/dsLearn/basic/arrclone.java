package dsLearn.basic;

import java.util.Arrays;

public class arrclone {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,6};
        int[] arr2 = arr.clone();
        arr[1]=9999;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

    }
}
