package niuke.pdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*

每只小熊有一个饥饿值，每次进食的时候，小熊们会选择最大的能填饱自己当前饥饿值的那颗糖来吃，可能吃完没饱会重复上述过程，但不会选择吃撑

第一行两个正整数n和m，分别表示小熊数量和糖的数量。（n <= 10, m <= 100）
第二行m个正整数，每个表示着颗糖能填充的饥饿值。
接下来的n行，每行2个正整数，分别代表每只小熊的战斗力和当前饥饿值。
题目中所有输入的数值小于等于100。

输出描述:
输出n行，每行一个整数，代表每只小熊剩余的饥饿值。

输入例子1:
2 5
5 6 10 20 30
4 34
3 35

输出例子1:
4
0


用例:
6 60
43 24 72 84 44 96 58 36 67 39 1 28 50 57 31 13 66 76 96 10 16 31 17 61 80 6 36 45 33 75 89 56 74 66 92 10 69 43 19 76 78 18 82 39 49 4 89 37 12 83 53 31 29 25 73 94 2 19 43 77
70 59
28 56
43 21
23 57
89 59
12 2

对应输出应该为:

0
0
2
0
0
2

 */
public class xiaoxiong {

   static class bear{
        int fight;
        int hungry;

        public bear(int fight, int hungry) {
            this.fight = fight;
            this.hungry = hungry;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> candy = new ArrayList<>(m);
        for (int i = 0; i <m ; i++) {
            candy.add( sc.nextInt());
        }
        candy.sort((Integer a,Integer b)->b-a);
        List<bear> bears = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            bears.add(new bear(sc.nextInt(),sc.nextInt()));
        }

        List<bear> copy = new ArrayList<>(bears);
        copy.sort((bear a,bear b)->b.fight-a.fight);
        System.out.println(candy);
       for(bear b:bears){
        Iterator<Integer> it = candy.iterator();
           while (it.hasNext()){
               int tmp = it.next();
               if(b.hungry >= tmp){
                   b.hungry-= tmp;
                   it.remove();
               }
           }
       }

       for(bear b:bears){
           System.out.println(b.hungry);
       }



    }
}
