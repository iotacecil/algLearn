package dsLearn.basic;

import java.util.Arrays;

public class bubbleSort {
    //复杂度：等差数列n+ n-1 + n-2 +...+1->n(n+1)/2 ->n^2
    public void bubble(int[] arr){
        if(arr== null|| arr.length<2){
            return;
        }
        //0~n ->0,1 n-1,n
        //0~n-1
        //0~n-2
        for (int i = arr.length-1; i >0; i--) {
            //0~n-1
            for (int j = 0; j <i; j++) {
                if(arr[j]>arr[j+1]){
                   swap(arr,j,j+1);
                }
            }

        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
    public static void main(String[] args) {
        bubbleSort sl = new bubbleSort();
        int[] arr = new int[]{4,3,2,1};
        sl.bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
}
