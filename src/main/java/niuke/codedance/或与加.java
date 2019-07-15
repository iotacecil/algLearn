package niuke.codedance;

import java.util.Scanner;

public class 或与加 {
    //5->101  +2 ==
    //1->1
    // 2->1,2,(1,2)3
    // 3->1,2,3 (1,2)(1,3)(2,3)(1,2,3) 7
    // 4->1,2,3,4, (1,2)(1,3)(2,3)(1,4)(2,4)(3,4),(1,2,3)(1,3,4)(1,2,4)(2,3,4),(1,2,3,4)  15


    //    链接：https://www.nowcoder.com/questionTerminal/729f5e6e2acc4f3cb14a2262888f86fb?orderByHotValue=1&mutiTagIds=665&page=1&onlyReference=false
//    来源：牛客网
//
//      x = 10010010011
//    y = 00000000(0)00   k = 0
//    y = 00000000(1)00   k = 1
//    y = 0000000(1)(0)00 k = 2
//    y = 0000000(1)(1)00 k = 3
//    y = 00000(1)0(0)(0)00 k = 4
//    y = 00000(1)0(0)(1)00 k = 5
// 101 -》111-》1000
    // x+y = x|y x 为1 的地方y肯定不能1
    //0 0101   0111(+2 1101+4 1111+2+4  10101(+8,11101+8+4,11111
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int x = 2000000000;
//        System.out.println(Integer.toBinaryString(x).length());
        long x = sc.nextLong();
        long k = sc.nextLong();
        long idx = 1;
        long y = 0;
        while (k != 0) {
            if ((x & idx) == 0) {
                // 把k的每一位填到这个空
                y += (idx * (k & 1));
                k >>= 1;
            }
            idx <<= 1;
        }
        System.out.println(y);


    }
}
