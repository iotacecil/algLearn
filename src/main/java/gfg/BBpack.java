package gfg;


import java.util.*;

class Item{
    double weight;
    int value;

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }

    public Item(double weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
class Node{
    // level  --> Level of node in decision tree (or index
    //             in arr[]
    // profit --> Profit of nodes on path from root to this
    //            node (including this node)
    // bound ---> Upper bound of maximum profit in subtree
    //            of this node/
    int level,profit,bound;
    double weight;

    public Node(Node v) {
        this.level = v.level;
        this.bound = v.bound;
        this.profit = v.profit;
        this.weight = v.weight;
    }

    public Node(int level, int profit, double weight) {
        this.level = level;
        this.profit = profit;

        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Node{" +
                "level=" + level +
                ", profit=" + profit +
                ", bound=" + bound +
                ", weight=" + weight +
                '}';
    }
}
public class BBpack {
    //用分数背包问题的贪心法求接下去可能的最大值
    public static  int bound(Node u,int n,int W,List<Item> arr){
        if(u.weight>=W)return 0;
        int profit_bound = u.profit;
        int j = u.level+1;
        int totweight = (int)u.weight;
        while(j<n&&(totweight+arr.get(j).weight<=W)){
            totweight += arr.get(j).weight;
            profit_bound += arr.get(j).value;
            j++;
        }
        if(j<n){
            profit_bound+=(W-totweight)*arr.get(j).value/arr.get(j).weight;
        }
        return profit_bound;
    }
    public static int knapsack(int W,List<Item>arr,int n){
        //1. 排序
//        Comparator<Item> comparing = Comparator.comparing(item -> item.value / item.weight);
//        arr.sort(comparing.reversed());
        arr.sort(Comparator.comparing((Item item )-> item.value / item.weight).reversed());
        //2.队列
        System.out.println(arr);
        Deque<Node> que = new ArrayDeque<>();
        // dummy node
        Node u = new Node(-1,0,0);
        Node v = new Node(-1,0,0);
        que.add(u);
        int MaxProfit = 0;
        while(!que.isEmpty()){
            u = que.poll();

            if(u.level == -1){
                v.level =0;
            }
            if(u.level == n-1)continue;
            v.level = u.level+1;
            //装
            v.weight = u.weight+arr.get(v.level).weight;
            v.profit = u.profit+arr.get(v.level).value;
            //如果不超重 更新当前最大收益
            if(v.weight<=W&&v.profit>MaxProfit)
                MaxProfit = v.profit;
            v.bound = bound(v,n ,W ,arr );

            //不装
            if(v.bound>MaxProfit)
                que.add(new Node(v));
            v.weight = u.weight;
            v.profit = u.profit;
            v.bound = bound(v,n,W ,arr);
            //不装也有可能
            if(v.bound>MaxProfit){
                que.add(new Node(v));
            }
        }
        return MaxProfit;
      }
    public static void main(String[] args) {
        List<Item> arr= new ArrayList<Item>(5);
        arr.add(new Item(2,40));
        arr.add(new Item(3.14,50));
        arr.add(new Item(1.98,100));
        arr.add(new Item(5,95));
        arr.add(new Item(3,30));
        int W = 10;
        System.out.println(knapsack(W, arr, arr.size()));
    }
}
