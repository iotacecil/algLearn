package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc532 {

    //???
    public int findPairsRight(int[] nums,int k){
        if(k<0)return 0;
        Set<Integer> starts = new HashSet<>();
        Set<Integer> uniqs = new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            //n-k ,n
            if(uniqs.contains(nums[i]-k))starts.add(nums[i]-k);
            if(uniqs.contains(nums[i]+k))starts.add(nums[i]);
            uniqs.add(nums[i]);
        }
        return starts.size();
    }
    //52%
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0,n = nums.length,right = left+1;
        int cnt = 0;
        while(left<n-1){
            if(left>=right)right = left+1;
            if(left<n && right<n && Math.abs(nums[left]-nums[right])==k){

                cnt++;
                while(left+1<n && nums[left]==nums[left+1]){
                    left++;
                }
                left++;
//                right = left+1;
//                System.out.println(left+" "+right);
            }else if(right<n && (nums[right]-nums[left])<k){
                right++;
            }else if(left<n) left++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,4,1,5};
        int target = 2;
        lc532 sl = new lc532();
        System.out.println(sl.findPairsRight(nums, target));
    }
}
