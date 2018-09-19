package leetcode;

public class lc495 {
    /**
     * 输入: [1,2], 2
     输出: 3
     原因: 在第1秒开始时，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持2秒钟，直到第2秒钟结束。
     但是在第2秒开始时，提莫再次攻击了已经处于中毒状态的艾希。
     由于中毒状态不可叠加，提莫在第2秒开始时的这次攻击会在第3秒钟结束。
     所以最终输出3。
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;
        int result = 0,start = timeSeries[0],end = timeSeries[0]+duration;
        for (int i = 1; i <timeSeries.length ; i++) {
            if(timeSeries[i]>end){
                result+= (end-start);
                start = timeSeries[i];
            }
            end = timeSeries[i]+duration;
        }
        result += (end-start);
        return result;
    }

}
