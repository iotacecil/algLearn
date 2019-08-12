package niuke;

import java.util.Scanner;

/*
有一只兔子，从出生后第3个月起每个月都生一只兔子，
小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 */
public class 统计每个月兔子的总数 {


    /**
     * 统计出兔子总数。
     *
     * @param monthCount 第几个月
     * @return 兔子总数
     */
    public static int getTotalCount(int monthCount)
    {
        int f1 = 1;
        int f2 = 1;
        if(monthCount <=2)return 1;
        for (int i = 3; i <=monthCount ; i++) {
            int tmp = f1+f2;
            f1 =f2;
            f2 =tmp;
            // f3 = f1+f2;
            // f1 = f2;
            // f2 = f3;

        }
        return f2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(getTotalCount(sc.nextInt()));
        }
    }
}
