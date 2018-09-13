package courseBook.dsLearn.basic;

import java.util.Arrays;

public class mergeSort {
    public static void mergesort(int[] arr){
        if(arr== null||arr.length<2)return;
        sort(arr,0,arr.length-1);
    }
    public static void sort(int[] arr,int L,int R){
        if(L==R)return;
        int mid = L+((R-L)>>1);
        sort(arr,L,mid);
        sort(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public static void merge(int[] arr,int L,int mid,int R){
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while(p1<=mid&&p2<=R){
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
            System.out.println(Arrays.toString(help));
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=R){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L+j] = help[j];
            
        }
        System.out.println(Arrays.toString(help));
        
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1,0};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
