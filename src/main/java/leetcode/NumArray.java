package leetcode;

import java.util.concurrent.ForkJoinTask;

/*
binary index tree 求前n项和问题
第一遍求和O(n)
更新O(1)->O(logN)
再求和O(n)->O(logN)
m次sum,update的复杂度O（m）[更新]O(m*n)[求和]->O(m*logn)^2
 */
public class NumArray {

    private int[] e=null;
    private int[] nums =null;

    int sum=0;
    public NumArray(int[] nums) {
        this.e = new int[nums.length+1];
//        this.nums = nums;
        //O(n)
        //为了用diff赋值，初始化的应该全为0
        this.nums= new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            update(i+1,nums[i]);
        }
//        for (int i = 1; i <e.length ; i++) {
//            sum = 0;
//            int lowbit = i&(-i);
//            //log(n)
//            for(int j = i;j>i-lowbit;j--){
//                sum+=nums[j-1];
//            }
//            e[i] = sum;
//        }
    }
//
    public void update(int i, int val) {
        if(nums.length==0)return;
        int dif = val -nums[i];
        nums[i] = val;
        //num中的i是从0 开始，e的i是从1 开始
        i++;
        for(;i<e.length;i+=(i&-i)){
            e[i] +=dif;
        }

    }
//
    public int sumRange(int i, int j) {
        int j1=sum(j+1);
        System.out.println("j+1:"+j1);
        return sum(j+1)-sum(i);
    }
    private int sum(int k){
        int sum = 0;
        //log(n)
        for (int i = k; i >0 ; i-=i&(-i)) {
            sum+=e[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        //000001 & 111111 = 1
        //000010 & 111110 = 2
        //4&-4 = 100
        //110&11111010 == 6&-6 = 10==2

        System.out.println(Integer.toBinaryString((~5)));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(5));
        NumArray na = new NumArray(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(na.sumRange(0, 7));
//        na.update(1,2);
//        System.out.println(na.sumRange(0, 2));

    }
}
