
package niuke.wangyi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，
请帮助牛牛计算出，符合这个要求的合法排列的数目

数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000）


链接：https://www.nowcoder.com/questionTerminal/b698e67a2f5b450a824527e82ed7495d
来源：牛客网

对于数组A来说，增加（插入）一个数字，其A的顺序对个数不变，所以新数组A+1的顺序对个数=数组A的顺序对+新插入的数字产生的顺序对.
进而推广到，增加c个数字，新数组A+c的顺序对=数组A的顺序对+数组c的顺序对+每个新插入的数字产生顺序对（共c个数字）。
 */
public class 数列还原2017 {

    static boolean valid(int[] arr, List<Integer> pe, long k) {
        int[] clone = arr.clone();
//    System.out.println(pe);
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                clone[i] = pe.get(idx++);
            }
        }
//    System.out.println(Arrays.toString(clone));
        long cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (clone[i] < clone[j])
                    cnt++;
                if (cnt > k) return false;
            }
        }
//    System.out.println(cnt);
        return cnt == k;

    }


    /*
    非递归全排列
     */
    static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> rst = new LinkedList<>();

        rst.add(new LinkedList<>());
        for (int n : num) {
            int size = rst.size();
            while (size-- > 0) {
                List<Integer> tmp = rst.get(0);
                rst.remove(0);
//                System.out.println(tmp);
                for (int i = 0; i <= tmp.size(); i++) {
                    List<Integer> t = new LinkedList<>(tmp);
                    t.add(i, n);
                    rst.add(t);
                }
            }
        }
        return rst;
    }

    //5-2 = 3  3!=6
    // 1 2 3 4 5   4+3+2+1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextInt();
        int[] arr = new int[n];
        boolean[] vis = new boolean[101];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] != 0) {
                vis[arr[i]] = true;
            } else {
                cnt++;
            }
        }
        int[] unvi = new int[cnt];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                unvi[idx++] = i;
            }
        }
        long rst = 0;
//        System.out.println(Arrays.toString(unvi));
        List<List<Integer>> permut = permute(unvi);
//        System.out.println(permut);
        for (List<Integer> pp : permut) {
            boolean valid = valid(arr, pp, k);
            if (valid) {
                rst++;
            }
        }
        System.out.println(rst);


    }

}
