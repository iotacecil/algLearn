package leetcode;

import java.util.Arrays;

public class heapSort {

    private int poll(int[] arr){
        int s = arr.length - 1;
        int rst = arr[0];
        int last = arr[s];
        arr[s] = rst;
        if(s!=0){
            shifDown(arr, 0,last,arr.length);
        }
        return rst;
    }
    //down不会超过树的高度 所以O(logn)
    private void shifDown(int[] arr,int i,int x,int len){
        int s = len;
        int half = s >>>1;
        while (i < half){
            int child = 1 + (i<<1);
            int el = arr[child];
            int rc = child+1;
            if(rc < s && arr[child] < arr[rc]){
                el = arr[rc];
                child = rc;
            }
            // 大顶堆，如果比叶子都大，下面已经是有序堆了，就完成了
            if(x >= el){
                break;
            }
            arr[i] = el;
            i = child;
        }
        arr[i] = x;
    }
    // log(n)
    private void shifUp(int[] arr,int i,int x){
        while (i>0){
            int parent = (i-1)>>>1;
            int e = arr[parent];
            if(e >= x)break;
            // 下移父节点
            arr[i] = e;
            i = parent;
        }
        arr[i] = x;
    }
    void heapify(int[] arr){
        for (int i = (arr.length >>> 1) - 1; i >= 0; i--)
            shifDown(arr,i, arr[i],arr.length);
    }

    void heapSort(int[] arr){
        heapify(arr);
        int s = arr.length;
        while (s>0) {
            s--;
            //swap(0,n-1)
            int rst = arr[0];
            int last = arr[s];
            arr[s] = rst;
            if (s != 0) {
                shifDown(arr, 0, last,s);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,6,7};
        heapSort sl = new heapSort();

//        sl.heapify(arr);
//        System.out.println(Arrays.toString(arr));
        sl.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
