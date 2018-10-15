package leetcode;

public class lc80 {
    public int removeDuplicates(int[] nums){
        int cnt = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] > nums[cnt - 2]){
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,3,3};
        lc80 sl = new lc80();
        System.out.println(sl.removeDuplicates(a));
    }
}
