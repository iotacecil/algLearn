package niuke.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
你非常热爱与邻居进行交流，故而你需要你所入住的房子两边上都有住户。
一条街上有n幢房子，标号从1到n，
两个在标号上相差为1的房子视为相邻，这些房子中有k幢房子已有住户。
对于每个用例输出最小的可能数以及最大的可能数


用例:
10
113765943 111815632
229484446 148237592
305009175 188064307
802795648 193143995
884683360 224244502
120294547 52744945
410722466 152331918
96136591 52575253
324554420 138687677
33461747 2994630

对应输出应该为:

0 1950311
0 81246854
0 116944868
0 193143994
0 224244501
0 52744944
0 152331917
0 43561338
0 138687676
0 2994629

你的输出为:

0 56882971
0 114742222
0 152504587
193143994
224244501
52744944
152331917
0 48068295
138687676
2994629

 */
public class 买房2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Long t = Long.parseLong(bf.readLine());
        for (int i = 0; i < t; i++) {
            String[] split = bf.readLine().split(" ");
            Long n = Long.parseLong(split[0]);
            Long k = Long.parseLong(split[1]);
            if (n < 3 || k < 2) {
                System.out.println(0 + " " + 0);
                continue;
            }

            if (k == n / 2) {
                System.out.println(0 + " " + (n % 2 == 0 ? ((n / 2) - 1) : ((n / 2))));
            } else if (k > n / 2) {
                System.out.println(0 + " " + (n - k));
            } else {
                System.out.println(0 + " " + (k - 1));
            }


        }


    }
}
