package niuke.basic;

import java.util.Arrays;

public class SelectSort {
    private void insert(int[] arr){
        if(arr== null|| arr.length<2){
            return;
        }
        //0~n
        //1~n
        for (int i = 0; i < arr.length; i++) {
            //1~n
            //2~n 找到最小值放到i上
            int minidx = i;
            for (int j = 1; j <arr.length ; j++) {
                minidx= arr[j]<arr[minidx]?j:minidx;
            }

            
        }


    }
    public static void main(String[] args) {
        SelectSort sl = new SelectSort();
        int[] arr = new int[]{4,3,2,1};
        sl.insert(arr);
        System.out.println(Arrays.toString(arr));
    }
}
