package leetcode;

public class lc122 {

    public static int maxProfit(int[] prices) {
        int maxp = 0;
        int total =0;
        int dlen= prices.length;
        out:
        for(int i =0;i<dlen;i++){


            int buy = prices[i];

            for(int j =i+1;j<dlen;j++){
                int sell = prices[j];
                if(j>0&&j<dlen-1&&sell<prices[j-1]){
                    System.out.println(sell);
                    total+=maxp;
                    System.out.println("total"+total);
                    maxp=0;
                    i=j-1;
                    continue out;

                }
                if(sell-buy>maxp){
                    System.out.println("sell"+sell+buy);
                    maxp=sell-buy;
                }


            }
            if(i==dlen-1)total+=maxp;
        }
        return total;
    }
    public static  int right(int[] prices){
        int max = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i]>prices[i-1])max+=prices[i]-prices[i-1];
        }
        return max;
    }
    //1 2 3 4
    public static void main(String[] args) {
        int[] p = {2,1,4,5,2,9,7};
        System.out.println(maxProfit(p));
        System.out.println(right(p));
    }
}
