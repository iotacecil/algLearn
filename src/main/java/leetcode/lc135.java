package leetcode;
/*

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

示例 1:

输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
1 0 2 1
2 1 2 1

[0,1,0,1]
1  2 1 2
0 1 2 3 0
1 2 3 4 1

3 2 1 0  -> 2 3 4 5


1 2 3 2 1
1 2 3 2 1
if(up){
    if(down)
        cnt--;
        }

 1 2 3 4 2 1
 1 2 3 4


 */
public class lc135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] nums = new int[n];
        nums[0] = 1;
        // Arrays.f
        for(int i = 1;i<n;i++){
            // 1 2 3 4
            if(ratings[i-1] < ratings[i]){
                nums[i] = nums[i-1]+1;
            }else nums[i]  = 1;
        }
        // 1 2 3 4 3 2
        // 1 2 3 4 1 1
        //
        // 4 3 2 1 2 3
        // 1 1 1 1 2 3
        // 4 3 2

        // 1 2 2
        // 1 2 2
        //
        for(int i = n-1;i>0;i--){
            if(ratings[i-1] > ratings[i]){
                nums[i-1] = Math.max(nums[i] + 1, nums[i-1]);
            }
        }
        int rst = 0;
        for(int num:nums){
            rst += num;
        }
        return rst;
    }
}
