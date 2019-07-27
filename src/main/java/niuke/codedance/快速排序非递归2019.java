package niuke.codedance;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 快速排序非递归2019 {
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void quicksort(int[] arr, int left, int right) {
        Deque<Integer> stk = new ArrayDeque<>();

        if (left <= right) {
            stk.push(right);
            stk.push(left);
            while (!stk.isEmpty()) {
                int l = stk.pop();
                int r = stk.pop();
                if (l >= r) continue;
                //  int pivot = arr[r];
                int i = l - 1;
                int j = r;
                while (true) {
                    while (++i < j && arr[i] <= arr[r]) ;
                    while (--j > i && arr[j] >= arr[r]) ;
                    if (i >= j) break;
                    else {
                        swap(arr, i, j);
                    }
                }
                swap(arr, i, r);
                stk.push(i - 1);
                stk.push(l);
                stk.push(r);
                stk.push(i + 1);

            }
        }


    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quicksort(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }
}
