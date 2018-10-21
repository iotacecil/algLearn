package leetcode;

import java.util.*;

public class lc347 {
    public List<Integer> topKbucket(int[] nums,int k){
        List<Integer> rst = new ArrayList<>();
        if(nums.length == 0) return rst;
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < min)min = nums[i];
            if(nums[i] >max) max = nums[i];
        }
        int[] data = new int[max-min + 1];
        for (int i = 0; i <nums.length ; i++) {
            data[nums[i] - min]++;
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int i = 0;i<data.length;i++){
            if(data[i]> 0){
                if(bucket[data[i]]== null){
                    bucket[data[i]] = new ArrayList<Integer>();
                    bucket[data[i]].add(i);
                }else{
                    bucket[data[i]].add(i);
                }

            }
        }
        for(int i =nums.length;i>0;i--){
            if(k<=0)return rst;
            if(bucket[i]!=null){
                rst.addAll(bucket[i]);
                k-=bucket[i].size();
            }
        }
        return rst;

    }
    /**
     * 34%
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> rst = new ArrayList<>();
        if(nums.length<1)return rst;
        int n = nums.length;
        Map<Integer,Integer> cnt = new HashMap<>();

        for(int x:nums){
            if(cnt.containsKey(x)){
                cnt.put(x,cnt.get(x)+1);
            }else{
                cnt.put(x,1);
            }
        }
        List<Integer>[] bucket = new ArrayList[n+1];
        for(int key :cnt.keySet()){
            int ccc = cnt.get(key);
            if(bucket[ccc]== null){
                bucket[ccc] = new ArrayList<Integer>();
                bucket[ccc].add(key);
            }else{
                bucket[ccc].add(key);
            }

        }
        System.out.println(Arrays.toString(bucket));

        for(int i =n;i>0;i--){
            if(k<=0)return rst;
            if(bucket[i]!=null){
                rst.addAll(bucket[i]);
                k-=bucket[i].size();
            }
        }

        return rst;
    }
    public static void main(String[] args) {
        List<Integer>[] bucket = new ArrayList[10];
        int[] nums = {4,1,-1,2,-1,2,3};
        int k  = 2;
        lc347 sl = new lc347();
        System.out.println(sl.topKbucket(nums, k));
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

    }
}
