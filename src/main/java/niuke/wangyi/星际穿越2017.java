package niuke.wangyi;

import java.math.BigInteger;
import java.util.Scanner;

public class 星际穿越2017 {
    // 大数开根号
    public static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for (; ; ) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();

//        long n = sc.nextInt();
        //x+x^2=10
        /*
        long x = (long)Math.pow(num, 0.5);
            if(x * (x + 1) > num) {
                System.out.println(x - 1);
            } else {
                System.out.println(x);
            }
         */
        BigInteger rst = (sqrt(n.multiply(BigInteger.valueOf(4)).add(BigInteger.valueOf(1)).add(BigInteger
                .valueOf(-1))
        ).divide(BigInteger.valueOf(2)));
        System.out.println(rst);
    }
}
