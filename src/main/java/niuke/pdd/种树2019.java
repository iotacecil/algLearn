package niuke.pdd;

import java.util.Scanner;

/*


比较当前未种的树和坑的大小关系！
具体的剪枝思路是每次搜索之前判断当前剩余的坑位left和任意品种的树之间的关系:

1) 如果left为偶数，那么只要tree[i] > left / 2，就表示肯定种不了
2) 如果left为奇数，那么只要tree[i] > (left + 1) / 2，就表示肯定种不了
这里有一个小技巧：left为偶数时，left/2 和(left + 1)/2的值是相等的，
所以可以统一使用tree[i] > (left+1)/2的关系来做剪枝优化！
 */
public class 种树2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        if (sum % 2 == 0) {
            for (int i = 0; i < n; i++) {
                if (a[i] > sum / 2) {
                    System.out.println("-");
                    return;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (a[i] > ((sum + 1) / 2)) {
                    System.out.println("-");
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int left = sum;
        int pre = -1;
        //每次种一棵
        for (int i = 0; i < sum; i++) {
            boolean flag = false;
            // 找一颗现在>1/2的
            for (int k = 0; k < n; k++) {
                if (a[k] > left / 2) {
                    sb.append(k + 1).append(" ");
                    a[k]--;
                    pre = k + 1;
                    flag = true;
                    left--;
                    break;
                }
            }
            if (flag) continue;
            int j = 0;
            //找第一个和上次不一样的
            while (a[j] == 0 || (j + 1) == pre) j++;
            a[j]--;
            pre = j + 1;
            sb.append(j + 1);
            sb.append(" ");
            left--;
        }
        System.out.println(sb.toString().trim());
    }
}
