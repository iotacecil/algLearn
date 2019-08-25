package niuke.paypal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 幸存者游戏 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int num = 1;
        int pow = 1;
        //1 2 3 4 5
        //1 2
        //1 3 4 5
        //

        while (list.size() > 1) {
            num++;
            if (num == Math.pow(m, pow)) {
//                System.out.println((num%(list.size())));
                list.remove((num % (list.size())));
//                System.out.println(list);
                pow++;
            }
//           System.out.println(num);

        }
        System.out.println(list.get(0));
    }
}
