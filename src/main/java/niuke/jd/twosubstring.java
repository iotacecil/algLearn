package niuke.jd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/abf0f0d6b4c44676b44e66060286c45a?orderByHotValue=0&commentTags=Python
 * 来源：牛客网
 * <p>
 * 给定一个字符串s, 请计算输出含有连续两个s作为子串的最短字符串。 注意两个s可能有重叠部分。例如,"ababa"含有两个"aba".
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),s中每个字符都是小写字母.
 * <p>
 * <p>
 * 输出描述:
 * 输出一个字符串,即含有连续两个s作为子串的最短字符串。
 * 示例1
 * 输入
 * abracadabra
 * 输出
 * abracadabracadabra
 */
public class twosubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        int n = in.length();
        int[] next = new int[n + 1];
        Arrays.fill(next, 0);
        next[0] = -1;
        next[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            char pre = in.charAt(i - 1);
            // 前面多少位和开头一样 后退的位置(个数正好是从头数+1个的位置）
            // abcab next[b] = 2
            int k = next[i - 1];
            // 中止 如果 abc k = 0 c和开头的a还是不等，k=-1不能往前匹配了next[i]=0下一个
            while (k != -1) {
                if (in.charAt(k) == pre) {
                    next[i] = next[i - 1] + 1;
                    break;
                }
                //如果 ab dd abc | ab dd abd
                // k = next[b] = 6 c和d不等，
                // next[c] = 2 d和d相等，所以最后的next[d] = 3
                k = next[k];
            }
        }
        // 求完最后一个位置的前缀后缀长度 abcdabc next = 3
        // abcdabc
        //     abc dabc
        System.out.println(in + in.substring(next[in.length()]));

    }

}
