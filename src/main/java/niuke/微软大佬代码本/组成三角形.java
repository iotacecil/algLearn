package niuke.微软大佬代码本;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/*
https://www.nowcoder.com/questionTerminal/c67a09062c0f4a5b964eef0945d3dd06
 */
public class 组成三角形 {
    private static boolean vaild(long[] arr) {
        Arrays.sort(arr);
        if (arr[0] + arr[1] > arr[2] && (arr[2] - arr[1] < arr[0] && arr[1] - arr[0] < arr[2])) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            BigInteger c = sc.nextBigInteger();
            if (a.add(b).compareTo(c) > 0 && a.add(c).compareTo(b) > 0 && b.add(c).compareTo(a) > 0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

}
