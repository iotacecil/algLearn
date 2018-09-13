package courseBook.dsLearn.basic;

import java.util.Arrays;

public class quickSort {
    private static void swap(int[] a ,int i,int j){
        int tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    int [] a;
    public void quick(int[] a){
        this.a = a;
        quick(0,a.length-1);
    }
    private void quick(int l,int r){
        if(l>=r)
            return;
        int p = partition(l,r);
        quick(l,p-1);
        quick(p+1,r);
    }
    private int partition(int l,int r){
        int v = a[l];
        int j = l;
        for (int i = j+1; i <=r ; i++) {
            if(a[i]<v){
                j++;
                System.out.println("swap"+i+" "+j+" "+a[i]+" "+a[j]);
                swap(a,i,j);

            }
            System.out.println(Arrays.toString(a));
        }
        System.out.println("lastswap"+l+" "+j);
        swap(a,l,j);
        return j;
    }

    public static void main(String[] args) {

        int[] a = {3,4,5,2,9,8,7,6,0};
        quickSort sl = new quickSort();
        sl.quick(a);
        System.out.println(Arrays.toString(a));
    }
}
