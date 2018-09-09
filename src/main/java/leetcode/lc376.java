package leetcode;

public class lc376 {

    public int wiggleMaxLength(int[] nums) {
        nums=new int[]{1,17,5,10,13,15,10,5,16,8};
        if(nums==null||nums.length<1) return 0;
        if(nums.length<2)return nums.length;

        final int begin = 0;
        final  int up = 1;
        final int down = -1;
        int cnt = 1;
        int state = begin;
        for (int i = 1; i < nums.length; i++) {
            switch(state){
                case begin:
                    if(nums[i]>nums[i-1]){
                        cnt++;
                        state = up;
                    }else if(nums[i]<nums[i-1]){
                        cnt++;
                        state = down;
                    }
                    break;
                case up:
                    if(nums[i]<nums[i-1]){
                        cnt++;
                        state = down;
                    }
                    break;
                case down:
                    if(nums[i]>nums[i-1]){
                        cnt++;
                        state = up;
                    }
                    break;
            }
        }


        return cnt;

    }

    public static void main(String[] args) {
        lc376 sl = new lc376();
        System.out.println(sl.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }
}
