package leetcode;

public class lc309 {
    public int maxProfit(int[] prices) {
        int sell = 0,preSell = 0,buy = Integer.MIN_VALUE,prev_buy=0;
        for(int price:prices){
            prev_buy = buy;
            buy = Math.max(preSell-price, prev_buy);
            preSell = sell;
            sell = Math.max(prev_buy+price,preSell );
        }
        return sell;
    }

    public static void main(String[] args) {

    }

}
