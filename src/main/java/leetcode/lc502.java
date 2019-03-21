package leetcode;

import java.util.PriorityQueue;

public class lc502 {
    class Item{
        int profit;
        int cost;

        public Item(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
      //  int rst = W;
        int n = Profits.length;
        PriorityQueue<Item> pq = new PriorityQueue<>((a,b)->(b.profit-a.profit==0?(a.cost-b.cost):(b.profit-a.profit)));

        for (int i = 0; i <n ; i++) {
            pq.add(new Item(Profits[i],Capital[i]));
        }
        PriorityQueue<Item> dely = new PriorityQueue<>((a,b)->(b.profit-a.profit==0?(a.cost-b.cost):(b.profit-a.profit)));
        while (k>0 && !pq.isEmpty()) {
            while (!pq.isEmpty() &&pq.peek().cost > W) {
                dely.add(pq.poll());
            }
            if(pq.isEmpty())break;
            if (!pq.isEmpty() && pq.peek().cost <= W) {
                Item itm = pq.poll();
              //  W -= itm.cost;
                W += itm.profit;
               // rst += itm.profit;
                k--;
            }
            while (!dely.isEmpty()){
                pq.add(dely.poll());
            }
        }
        return W;
    }

    public static void main(String[] args) {
        lc502 sl = new lc502();
     //   System.out.println(sl.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
//        System.out.println(sl.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));

    }
}
