package meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class shopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n个物品 //2
        int n = sc.nextInt();
        //m种优惠 //1
        int m = sc.nextInt();
        //物品价格
        double min = Double.MAX_VALUE;
        Map<Integer,Integer> good = new HashMap<>();
        //1表示特价优惠可以八折
      double sum = 0;
      int noyou = 0;
        for(int i =0;i<n;i++){
            int price = sc.nextInt();
            int eight = sc.nextInt();
            noyou+=price;
            if(eight==1){
                sum+=0.8*price;
            }
            else{
                sum+=price;
            }
//            good.put(price,sc.nextInt());
        }
        min = sum;
        Map<Integer,Integer> you = new HashMap<>();
        for(int i = 0;i<m;i++){
            int man = sc.nextInt();
            int cut = sc.nextInt();
            if(noyou>=man){
                min = Math.min(min,noyou-cut);
            }
//            you.put(sc.nextInt(),sc.nextInt());
        }
        System.out.println(String.format("%.2f",min));
    }
}
