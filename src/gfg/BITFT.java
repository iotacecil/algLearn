package gfg;

import java.util.Arrays;
//有问题
public class BITFT {
    int[] bit;
    int[] arr;
    public BITFT(int[] arr) {
        int n = arr.length;
        this.arr = arr;
        bit = new int[n+1];
        for (int i = 0; i <n ; i++) {
            update(i,arr[i]);
        }
    }
    public void update(int idx,int val){
        int dif = val-arr[idx];
        arr[idx] = val;

        idx++;
        while (dif!=0&&idx<=arr.length){
            bit[idx] += dif;
            idx+=idx&(-idx);

        }
    }

    public int getSum(int idx){
        int sum = 0;
        idx++;
        while(idx>0){
            sum+=bit[idx];
            idx-=idx&(-idx);
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return getSum(j)-getSum(i-1);
    }

    public static void main(String[] args) {
        BITFT sl = new BITFT(new int[]{1, 3, 5});
        System.out.println(Arrays.toString(sl.bit));
        System.out.println(sl.sumRange(0, 2));

        sl.update(1,2 );
        System.out.println(sl.sumRange(0, 2));
    }
}
