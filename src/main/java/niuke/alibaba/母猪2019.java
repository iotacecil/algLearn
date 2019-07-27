package niuke.alibaba;

import java.util.PriorityQueue;

/*
小明是一个数学家，他喜欢用数字给事务命名编号，他给自己编号为1，同时在2019年小明开办了一个农场，
准备开始养母猪，他专门给农场的母猪用以下数列
2，[3，[4]，5]，7，9，12，16，21，28，37，49，65，86，114，151…（f(n)=f(n-2)+f(n-3)）进行命名。
小母猪出生后3年后成熟，成熟后从第三年开始每年只会生一只母猪。第一年农场，
有一只刚出生的小母猪和一只成熟的母猪（本年不再生小猪，下一年开始生小猪），并给他们编号为2和3。


请问，第m只母猪的编号为多少？其是哪一年出生的？

小明还准备了1份礼物，专门颁给农场第1到m只的母猪，颁奖规则如下，
选出第1到m只的母猪翻转编号（114编号翻转为411）为第k大的母猪进行颁奖，
请问是第几只获奖？
输入m,k
20,3
输出465,2024,15
 */
public class 母猪2019 {
    private static int reverse(int num) {
        if (num < 10) return num;
        // System.out.println("before"+num);
        int tmp = 0;
        while (num > 0) {
            tmp = tmp * 10 + num % 10;
            num /= 10;
        }
        //System.out.println("after"+tmp);
        return tmp;

    }

    public static void main(String[] args) {
        int m = 20;
        int k = 3;
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int f1 = 2;//2019 (1/2)2,3 20(1/3)4   21(2/5) 22(3/8)  生   cs = 2

        int f2 = 3;//2019
        int f3 = 4;  //2020 // 1 //2021
        // 成熟的
        int fb1 = 2;
        // 总共
        int fb2 = 3;
        // 新一年的总数
        int cnt = 0;

        int year = 2021;
        if (m <= 3) {
            if (m == 1 && k == 1) System.out.println(2 + "," + 2019 + "," + k);
            else if (m == 2) {
                System.out.println(3 + "," + 2019 + "," + k);
            } else if (m == 3) System.out.println(4 + "," + 2020 + "," + k);
        }
        minheap.add(new int[]{2, 1});
        minheap.add(new int[]{3, 2});
        minheap.add(new int[]{4, 3});

        out:
        while (cnt <= m) {

            // cnt = fb2+fb1
            System.out.println("year:" + year);
            cnt = fb2;
            for (int i = 0; i < fb1 && cnt <= m; i++) {
                // 生成序号成熟的每只生
                cnt++;
                int tmp = f3;
                f3 = f2 + f1;//5,
                System.out.println("第" + cnt + "序号" + f3);
                int rev = reverse(f3);
                if (rev > minheap.peek()[0]) {
                    minheap.poll();
                    minheap.add(new int[]{rev, cnt});
                }
                f1 = f2;
                f2 = tmp;
                // 加上每只成熟的新产的
                if (cnt == m) break out;


            }
            // 成熟的
            fb1 = fb2;
            // 总数
            fb2 = cnt;
            year++;

        }
//        while (minheap.size()>1){
//           minheap.poll();
//        }
        System.out.print(f3 + "," + (year) + "," + minheap.poll()[1]);
    }
}
