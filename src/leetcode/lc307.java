package leetcode;
/*
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
 */
public class lc307 {

    //sqrt decomposition
    //长度9则sqrt(9)个block

    private int[] b;
    private int len;
    private int[] nums;
    public lc307(int[] nums){
        this.nums = nums;
        double l = Math.sqrt(nums.length);
        len = (int)Math.ceil(nums.length/l);
        b = new int[len];
        for (int i = 0; i < nums.length; i++) {
            b[i/len]+=nums[i];
        }
    }

    //1,7
    public int sumRange(int i,int j){
        int sum = 0;
        int startBlock = i/len;
        int endBlock = i/len;
        //在同一个区间里
        if(startBlock == endBlock){
            for (int k = i; k <= j ; k++) {
                sum+=nums[k];

            }
        }else{
            //start所在区间
            //len =  3,start =0
            for (int k = i; k <(startBlock+1)*len ; k++) {
                sum += nums[k];
            }
            //1-2)
            for (int k = startBlock+1; k <endBlock ; k++) {
                sum += b[k];
            }
            for (int k = endBlock*len; k <j ; k++) {
                sum += nums[k];
            }
        }
        return sum;
    }
    public void update(int i,int val){
        int bidx  = i/len;
        b[bidx] = b[bidx]-nums[i]+val;
        nums[i] = val;
    }

}
