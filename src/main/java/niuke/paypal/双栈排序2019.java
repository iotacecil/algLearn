package niuke.paypal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 双栈排序2019 {
    public static ArrayList<Integer> twoStacksSort(int[] numbers) {

        Deque<Integer> stk = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        for (int num : numbers) {
            nums.add(num);
        }
        while (!nums.isEmpty()) {
            int num = nums.pop();
            while (!stk.isEmpty() && stk.peek() > num) {
                nums.push(stk.pop());
            }
            stk.push(num);
        }
        List<Integer> list = new ArrayList<>();
        list.sort((a, b) -> a - b);
        return new ArrayList<>(stk);


    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(twoStacksSort(arr));
    }
}
