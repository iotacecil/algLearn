package dsLearn.basic;

import java.util.Arrays;

//小和问题和逆序问题
public class test8 {

//数组每个数左边比当前小的数累加起来叫这个 组数的小和。
//[1,3,4,2,5]->1 +1+3 +1 +1+3+4+2
    public int xiaohe(int[] arr){
        if(arr==null||arr.length<2)return 0;
        return mergesort(arr,0,arr.length-1);

    }
    private int mergesort(int[] arr,int l,int r){
        if(l==r)return 0;
        int mid = l+((r-l)>>2);
        return mergesort(arr,l,mid)+mergesort(arr,mid+1,r)+merge(arr,l,mid,r);
    }
//    如果[p1...][p2...]
//    如果p1比p2小，则p1比p2后面的数都小，是后面的数的小和
    private static int merge(int[] arr,int l,int mid,int r){
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        int res = 0;
        while (p1<=mid&&p2<=r){
            System.out.println(res);
            res+=arr[p1]<arr[p2]?(r-p2+1)*arr[p1]:0;
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
            System.out.println(Arrays.toString(help));

        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=r){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j <help.length ; j++) {
            arr[l+j] = help[j];
        }
        System.out.println(Arrays.toString(help));
        return res;
    }

    public static void main(String[] args) {
        test8 sl = new test8();
        System.out.println(sl.xiaohe(new int[]{1, 3, 4, 2, 5}));
    }
    //逆序问题，左边比右边大则构成一个逆序对 打印所有逆序对
//    public List<int[]> nixu (int[] arr){
//
//    }
}
