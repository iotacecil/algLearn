package leetcode;


import java.util.Arrays;

public class lc698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //int sum = Arrays.stream(nums).sum();
        int sum =0;
        for(int n :nums){
            sum+=n;
        }
        if(sum%k!=0)return false;
        int subSum = sum/k;
        Arrays.sort(nums);
        int b = nums.length-1;
        if(nums[b]>subSum)return false;
        while (b>=0&&nums[b]==subSum){

            b--;
            k--;
        }
        return partition(new int[k],nums,b,subSum);
    }
    private boolean partition(int[] subset,int[] nums,int index,int target){


        if(index<0){
            return true;
        }
        int select = nums[index];
        for (int i = 0; i <subset.length ; i++) {

            if(subset[i]+select<=target){
                subset[i]+=select;
                if(partition(subset,nums,index-1,target)){
                    return true;
                }
                subset[i]-=select;
            }
            if(subset[i]==0){
                System.out.println(i);
                System.out.println(Arrays.toString(subset));
//不懂
                break;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        lc698 sl = new lc698();
        sl.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1},4);
    }
}
