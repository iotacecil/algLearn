package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class lc220
{
    private long getID(long i,long w){
        return i < 0 ? (i+1)/w-1 :i/w;
    }

    /**
     * 73%
     *  with each bucket a width of (t+1). If there are two item with difference <= t, one of the two will happen:

     (1) the two in the same bucket
     (2) the two in neighbor buckets
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicateBucket(int[] nums, int k, int t) {

        if(t < 0)return false;
        Map<Long,Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long m = getID(nums[i],w );
            if(d.containsKey(m))
                return true;
            if(d.containsKey(m-1) && Math.abs(nums[i]-d.get(m-1)) < w){
                return true;
            }
            if(d.containsKey(m+1) && Math.abs(nums[i]-d.get(m+1)) < w) {
                return true;
            }
            d.put(m,(long)nums[i]);
            if(i >= k) d.remove(getID(nums[i-k],w ));
            }
            return false;
    }
        //40%
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(nums == null ||nums.length ==0 || k <= 0 || t < 0){
            return false;
        }
        // 一个 k 大的平衡树
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // smallest >= nums[i]
            Integer ceiling = set.ceiling(nums[i]);
            if(ceiling != null && (long)ceiling - (long)nums[i] <= t){
                return true;
            }
            Integer floor = set.floor(nums[i]);
            if(floor != null && (long)nums[i] - (long)floor <= t){
                return true;
            }
            //没有找到相邻的 暂存
            set.add(nums[i]);
            //不停删除最左边元素
            if(i >= k)
                set.remove(nums[i-k]);
        }
        return false;
    }

        // 暴力
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null ||nums.length ==0 || k <= 0 || t < 0){
            return false;
        }
        //复杂度n*k
        for(int i = 0;i < nums.length;i++){
            for(int j = i+1; j-i <= k && j < nums.length;j++){
                if(Math.abs((long)nums[j]-(long)nums[i]) <= t) {
                    System.out.println(j+" "+i);
                    System.out.print(nums[j] + " " + nums[i]);
                    return true;
                }
                System.out.println(Math.abs((long)nums[j]-(long)nums[i]));

            }
        }
        return false;
    }
    /*
    [-1,2147483647]
1
2147483647
     */
    public static void main(String[] args) {
        int[] nums = {-3,3};
        int k = 2;
        int t = 4;

        lc220 sl = new lc220();
        System.out.println(sl.containsNearbyAlmostDuplicate2(nums, k, t));
    }
}
