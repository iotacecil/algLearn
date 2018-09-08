package leetcode;

import java.util.Arrays;
import java.util.HashMap;

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        //HashMap
        int len = nums.length;
        //如果target-nums[i]在map里则取出
        //如果map里没这个值再加入
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<len;++i)
        {
            //2.i=1找到key=7
            //containsKey 与key（差值做匹配）
            if(map.containsKey(nums[i])){
                //直接return 后面不用else
                //get获取值
                //!先后顺序
                //3.输出num[1]=7的序号
                return new int[]{map.get(nums[i]),i};
            }
            //键为与target的差，值为序号（输出）
            //1.i=0存[7,0]
            map.put(target-nums[i],i);
        }
        return null;
    }
}
public class hashmaptwosum {
    public static void main(String[] args){
        Solution2 sl = new Solution2();
        //匿名数组
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(sl.twoSum(arr,target)));
    }
}
