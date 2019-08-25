package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class 塔2019 {
    static class Ta {
        int num;
        int id;

        public Ta(int num, int id) {
            this.num = num;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
//        int[] ta = new int[n];
        Ta[] ta = new Ta[n];
        // 2 3 4 4 5->dif = 3,
        for (int i = 0; i < n; i++) {
            ta[i] = new Ta(sc.nextInt(), i + 1);

        }
        Arrays.sort(ta, (a, b) -> a.num - b.num);
        if (ta[0].num == ta[n - 1].num) {
            System.out.println(0 + " " + 0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (++cnt <= k) {
//           System.out.println("cnt"+" "+cnt);
            sb.append(ta[n - 1].id + " " + ta[0].id + "\n");
            ta[n - 1].num--;
            ta[0].num++;


            Arrays.sort(ta, (a, b) -> a.num - b.num);

            if (ta[0].num >= ta[n - 1].num - 1) {
                sb.insert(0, 0 + " " + cnt + "\n");
                break;
            } else if (cnt == k) {
                sb.insert(0, ta[n - 1].num - ta[0].num + " " + cnt + "\n");
            }
        }
        System.out.println(sb.toString().trim());
        //


    }
}
