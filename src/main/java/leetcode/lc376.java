package leetcode;

public class lc376 {

    public int wiggleMaxLength(int[] nums) {
        if(nums == null)return 0;
        int n = nums.length;
        if(n < 2)return n;
        int predif = 0;
        int cnt = 1;
        for(int i =1;i<n;i++){
            int dif = nums[i] - nums[i-1];
            if(dif >0 && predif <=0 ||
                    dif <0 && predif >=0){
                cnt++;
                predif = dif;
            }
        }
        return cnt;

    }

    public static void main(String[] args) {
        lc376 sl = new lc376();
        System.out.println(sl.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }
}
