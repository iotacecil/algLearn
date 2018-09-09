package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc215 {
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
            while(i<r&&nums[++i]<nums[l]);
            while(j>l&&nums[l]<nums[--j]);
            if(i>=j)break;
            System.out.println("i: "+i+" j:"+j);

            swap(nums,i,j);
            System.out.println(Arrays.toString(nums));
        }
        System.out.println("i: "+i+" j:"+j);
        swap(nums,l,j);
        return j;
    }

    public static void main(String[] args) {
        System.out.println(selec(new int[]{3,2,3,1,2,4,5,5,6}, 2));
        String s = "hjhkh";
        char[] vo = new char[]{'1'};


    }
}