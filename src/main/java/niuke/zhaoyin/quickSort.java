package niuke.zhaoyin;


import java.util.Scanner;

public class quickSort {

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
//        String[] strs = sc.next().split(" ");
        int  n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0,n-1);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(" ");
            }
        }

    }

    private static void quickSort(int[] arr,int left,int right){
        if(left >= right)return;

        int l = left-1;int r = right;
        while(true){
            while(++l < r && arr[l] <= arr[right]);
            while(--r > l && arr[r] >= arr[right]);
            System.out.println(l+" "+r);
            if(l >= r)break;
            else{
                swap(arr,l,r);
            }
        }
        swap(arr,l,right);
        quickSort(arr,left,l-1);
        quickSort(arr,l+1,right);
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
