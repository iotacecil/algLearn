package leetcode;

public class lc121 {
    public static int maxProfit(int[] prices) {
        int maxp = 0;
        int dlen = prices.length;
        for(int i =0;i<dlen;i++){
            int buy = prices[i];
            for(int j = i;j<dlen;j++){
                maxp=Math.max(prices[j]-buy,maxp);
            }
        }
        return maxp;
    }
    public static int maxProfit2(int[] prices) {
        int max = 0,minp = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minp)minp= prices[i];
            int delta = prices[i]-minp;
            if(delta>max)max= delta;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] p = {7,1,5,3,6,4};
        System.out.println(maxProfit(p));
        System.out.println(maxProfit2(p));
    }
}
