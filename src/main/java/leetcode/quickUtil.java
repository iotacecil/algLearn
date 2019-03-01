package leetcode;

import java.util.Arrays;

public class quickUtil {

    public static void main(String[] args) {
        int[] arr = {8,3,5,1,2,0,7,9,4};
        int[] arr2 = {1,1,1,1,1,1,1,1};
        quickUtil sl = new quickUtil();
        sl.qS(arr,0 ,arr.length-1);
        System.out.println(Arrays.toString(arr2));
    }

    static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private int median(int[] arr,int left,int right){
        int mid = (left+right)/2;
        // 先比出最小的放左边
        if(arr[left] > arr[mid]){
            swap(arr, left, mid);
        }
        if(arr[left]> arr[right]){
            swap(arr, left, right);
        }
        //最大的放到最右边
        if(arr[mid] > arr[right]){
            swap(arr, mid, right);
        }
        // mid就是主元，放到倒数第二个位置上只需要划分[left+1,right-2]
        if(right-1 >=0){
            swap(arr,mid , right-1);
            return arr[right-1];
        }else return arr[mid];


    }
    private void qS(int[] arr,int left,int right){
        if(left>=right)return;

//        int pivot = median(arr,left,right);
        int pivot = arr[right];
        System.out.println("pivot:"+pivot+"left:"+left+"right"+right);
        int i = left-1;int j = right;
        while (true){
            while (++i<=right && arr[i] < pivot);
            while (--j>=left && arr[j] > pivot);
            if(i < j){
                swap(arr,i , j);
            }
            else break;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(i+" "+j);
        // 把主元放到左集合右边
        swap(arr, i, right);

        qS(arr, left, i-1);
        qS(arr, i+1,right);
    }

}
