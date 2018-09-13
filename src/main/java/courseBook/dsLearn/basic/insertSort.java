package courseBook.dsLearn.basic;

import java.util.Arrays;

public class insertSort {
    public void insert(int[] arr){
        if(arr == null||arr.length<2)return;
        for (int i = 1; i <arr.length ; i++) {
            for (int j = i-1; j >=0&&arr[j]>arr[j+1] ; j--) {
                bubbleSort.swap(arr,j,j+1);
            }
        }
    }

    public static void main(String[] args) {
        insertSort sl = new insertSort();
        int[] ints = {9, 5, 4, 7, 2, 3, 5, 8, 2};

        sl.insert(ints);
        System.out.println(Arrays.toString(ints));
    }
}
