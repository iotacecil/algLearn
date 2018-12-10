package leetcode;

import java.util.Arrays;

public class lc719 {
    private int smallerThanM(int[] nums,int m){
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            //找到第一个num[j] - num[i] > m
            while (j < nums.length && nums[j] - nums[i] <= m)j++;
            // nums[j] - nums[i] <= m 的个数，相差m的pair的个数
            cnt += (j - i - 1);
        }
        return cnt;
    }
    //3%
    public int smallestDistancePair2(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = nums[n-1] - nums[0] + 1;
        while (l < r ){
            int mid = l +(r-l)/2;
            if(smallerThanM(nums, mid) >= k){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r;
    }
    //???
    // todo
    public int smallestDistancePair3(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = nums[n-1] - nums[0] + 1;
        while (l < r ) {
            int mid = l + (r - l) / 2;
            // 被减数的位置
            int cnt = 0;
            for (int i = 0, j =0; i <nums.length ; i++) {
                while (nums[j] - nums[i] >= mid) j++;
                cnt += j -i -1;
            }
            if(cnt >= k) r = mid;
            else l = mid +1;
        }
        return l;
    }



        public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] bucket = new int[max+1];
        for(int i =0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                int idx = nums[j]-nums[i];
                bucket[idx]++;

            }
        }
        for(int i =0;i<bucket.length;i++){
            k -=bucket[i];
            System.out.println(k);
            if(k<=0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,6,1};
        int k = 3;
        lc719 sl = new lc719();
        System.out.println(sl.smallestDistancePair2(nums, k));
    }
}
