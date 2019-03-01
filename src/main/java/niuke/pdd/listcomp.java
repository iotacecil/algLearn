package niuke.pdd;

import java.util.Scanner;

public class listcomp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int offset = sc.nextInt();
            int n = sc.nextInt();
            int len1 = sc.nextInt();
            int len2 = sc.nextInt();

            int start1 = -1;
            int end1 = -1;
            int start2 = -1;
            int end2 = -1;
            if (offset >= len1) {
                // 只从2取
                int offset2 = offset - len1;
                start1 = len1;
                end1 = len1;


                start2 =Math.min( offset2,len2);
                end2 = Math.min(offset2 + n, len2);

            } else if (offset + n <= len1) {
                //只从1取
                start1 = offset;
                end1 = offset + n;
                start2 = 0;
                end2 = 0;

            } else if (offset < len1 && offset + n > len1) {
                start1 = offset;
                end1 = len1;
                start2 = 0;
                end2 = n - (len1 - offset);

            }

            System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
        }
    }
}
