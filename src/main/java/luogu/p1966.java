package luogu;

import java.util.Arrays;
import java.util.Scanner;
class node{
    int x;
    int loc;

    public node(int x, int loc) {
        this.x = x;
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "("+x+","+ loc+")";
    }
}
public class p1966 {

    int mergeS(int[] arr,int l,int r){
        if(l==r)return 0;
        int mid = l+((r-l)>>1);
        return mergeS(arr, l, mid)+mergeS(arr, mid+1, r)+merge(arr,l,mid,r);
    }
    int merge(int[] arr,int l,int mid,int r){
        int[] cnt = new int[r-l+1];
        int p1 = l,p2 = mid+1;
        int rst = 0;
        while (p1<mid && p2<r){

        }
        return rst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        node[] a = new node[n];
        node[] b = new node[n];
        for (int i = 0; i < n; i++) {
            a[i] = new node(sc.nextInt(),i);
        }
        for (int i = 0; i < n; i++) {
            b[i] = new node(sc.nextInt(),i);
        }
        Arrays.sort(a,(aa,bb)->aa.x-bb.x);
        Arrays.sort(b,(aa,bb)->aa.x-bb.x);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        int[] c = new int[n];
        for (int i = 0; i <n ; i++) {
            c[b[i].loc] = a[i].loc;
        }
        System.out.println(Arrays.toString(c));
    }
}
