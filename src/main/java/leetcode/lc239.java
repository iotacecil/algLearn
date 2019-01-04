package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class lc239 {
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if(nums == null || k <=0)return new int[0];
        int n = nums.length;
        int[] rst = new int[n-k+1];
        int cnt = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i <nums.length ; i++) {
            // 如果这个index在窗口之前了 删除
            while (!q.isEmpty() && q.peek() < i - k + 1){
                q.poll();
            }
            // 删除队列中比这个小的
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            q.add(i);
            if(i >= k-1){
                rst[cnt++] = nums[q.peek()];
            }

        }
        return rst;

    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length <1)return new int[]{};
        int n = nums.length;

        if(n < k){
            int max = nums[0];
            for(int t:nums){
                max = Math.max(max,t);
            }
            return new int[]{max};
        }
        int[] rst = new int[n-k+1];
        for(int i =0;i<n-k;i++){
            int x = 0;
            int max = nums[i];
            while(x <k){
                max = Integer.max(max,nums[i+x]);
                System.out.println(i+" " +(i+x));
                x++;
            }
            rst[i] = max;

        }
        return rst;

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->(b-a));
        int n = nums.length;
        int[] rst = new int[n-k+1];
        for(int i =0;i<Math.min(n,k);i++){
            q.add(nums[i]);
        }
        rst[0] = q.peek();
        if(n<=k)return rst;
        int l = 0,r=l+k;
        while(r+1 < n){
            q.remove(nums[l]);
            l++;
            r++;
            q.add(nums[r]);
            rst[l] = q.peek();
        }
        return rst;
    }

    public static void main(String[] args) {
        int[]  nums = {1,3,-1,-3,5,3,6,7};
        lc239 sl = new lc239();
        System.out.println(Arrays.toString(sl.maxSlidingWindow3(nums, 3)));
    }
}
