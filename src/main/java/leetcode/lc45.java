package leetcode;

public class lc45 {
    /**
     *
     * @param nums [2,3,1,1,4]
     * @return
     */
    public int jump(int[] nums) {
        if(nums==null||nums.length<2)return 0;
        int res = 0;
        int curMax = 0;
        int maxNext = 0;
        //i=0,max = 2 i==cur ->res++,cur = max=2
        //i=1,max = max(2,4)=4, i!=cur
        //i=2,max = max(4,3)=4, i==cur res++,cur = max=4
        //i=3,max = max(4,4)=4, i!=cur break
        //不需要走到i=4,max = max(4,4+4)=8,i==cur res++,cur=max
        for (int i = 0; i < nums.length-1; i++) {
            maxNext = Math.max(maxNext,i+nums[i] );
            if(i==curMax){
              res++;
              curMax = maxNext;
            }
        }
        return res;
    }

    /**
     * BFS
     * @param nums [2,3,1,1,4]
     * @return
     */
    public int jumpBFS(int[] nums){
        if(nums==null||nums.length<2)return 0;
        int level = 0;
        int cur = 0;
        int max =0;
        int i =0;
        //cur-i+1=1,level++; i<=cur,i++,max = 2;cur = 2;
        //cur=2,i=1;level++; i<=2,i++,max = 4,max>=n-1 return 2;
        while (cur-i+1>0){
            level++;
            for(;i<=cur;i++){
                max = Math.max(max,nums[i]+i);
                if(max>=nums.length-1)return level;
            }
            cur = max;
        }

        return 0;
    }
}
