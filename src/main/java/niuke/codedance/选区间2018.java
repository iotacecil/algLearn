package niuke.codedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 区间还是不清楚
public class 选区间2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + arr[i - 1];

        }

        // 1 2 3 4
        // 6 2 1 2 3
        // stk [0] curr = [1] 如果递减，pop并计算这个数字之前的sum * pop
        // 递增 stk=[2] cur=3 递增，全入栈stk=[2,3,4] 最后i=n cur = -1
        // 每次pop计算右边界4:[5-4]  3:[5-3]
        // 如果一直递增遇到一个开始递减的：栈里是递增的，[2,3,4] cur = 当前递减 计算[peek+1,cur]*cur
        // 1 2 3 4 3 cur = 3,peek = 4,num = 4
        int rst = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int curr = i == n ? -1 : arr[i];
            while (!stk.isEmpty() && curr < arr[stk.peek()]) {
                int num = arr[stk.pop()];
                // 表示左边的都出栈了，递减的情况，当前值和前面整个前缀
                if (stk.isEmpty()) {
                    rst = Math.max(rst, presum[i] * num);

                } else {
                    rst = Math.max(rst, (presum[i] - presum[stk.peek() + 1]) * num);
                    System.out.println("[" + i + "," + (stk.peek() + 1) + "]" + presum[i] + " " + presum[stk.peek() + 1] + " " + (presum[i] - presum[stk.peek() + 1]));
                }
            }

            stk.push(i);
        }
        System.out.println(rst);

//        long rst = 0;
//        for (int i = 0; i <n ; i++) {
//            int l = i-1;int r = i+1;
//            int sum = arr[i];
//            while (l>=0 && arr[l] >= arr[i]){
//                sum += arr[l];
//                l--;
//            }
//
//            while (r<n && arr[r] >= arr[i]){
//                sum += arr[r];
//                r++;
//            }
//        //    System.out.println(sum+" x "+arr[i]);
//            rst = Math.max(rst,sum*arr[i]);
//
//
//        }
//        System.out.println(rst);

    }
}
