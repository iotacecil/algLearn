package javaquickTest;

import java.util.Arrays;

import static courseBook.dsLearn.basic.bubbleSort.swap;

public class recbob {
    public void bubblesort(int[] array,int n) {
        if (n == 1)
            return;
        if (array == null || array.length == 0)
            return;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array,i,i+1);
            }
        }
        bubblesort(array, n - 1);

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,9,6,6,4};
        recbob sl = new recbob();
        sl.bubblesort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
