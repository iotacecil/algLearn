package leetcode;

import java.util.PriorityQueue;

public class lc215 {
    // [left,right] 用pivot划分并返回切分点
    public int findKthLargest2(int[] A, int k) {
        int n = A.length;
        for(int lo = 0,hi = n-1;lo < hi;){
            int i = lo,j=hi;
            int pivot = A[lo];
            while(i<j){
                while(i<j && pivot >= A[j])j--;
                A[i] = A[j];
                while(i<j && A[i] >= pivot)i++;
                A[j] = A[i];
            }
            A[i] = pivot;
            if(k>=i)hi = i-1;
            if(i>=k)lo = i+1;
       //     System.out.println(Arrays.toString(A));
        }
        return A[k];
    }


    private static int findKthLargest(int[] nums,int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums){
            pq.offer(val);
            System.out.println(pq);
            if(pq.size()>k)
                pq.poll();
        }
        System.out.println("after"+pq);
        return pq.peek();
    }
    private static int selec(int[] nums,int k){
         k = nums.length-k;
         int l = 0;
         int r = nums.length-1;
         while(l<r){
             int j = part(nums,l,r);
             if(j<k)l=j+1;
             else if(j>k) r = j-1;
             else break;
         }
         return nums[k];

    }
    private static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private static int part(int[] nums,int l,int r){
        int i = l;
        int j = r+1;
        while(true){
            while(++i<r&&nums[i]<nums[l]);
            while(--j>l&&nums[l]<nums[j]);
            if(i>=j)break;

            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    public static void main(String[] args) {
//        System.out.println(selec(new int[]{3,2,3,1,2,4,5,5,6}, 2));
//        String s = "hjhkh";
//        char[] vo = new char[]{'1'};
        int[] A = {3,2,1,5,6,4};
        int k = 2;

        lc215 sl = new lc215();
        System.out.println(sl.findKthLargest2(A, k));

    }
}