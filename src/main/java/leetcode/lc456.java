package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//class CompactCounter{
//    private volatile long counter;
//}
public class lc456 {



//        public boolean find132patternInterval(int[] nums) {
//        List<int[]> intervals = new ArrayList<>();
//        int i = 1,s = 0;
//        while (i < nums.length){
//            if(nums[i] <= nums[i-1]){
//                if(s < i - 1)
//            }
//        }
//
//    }
    public boolean find132pattern(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0,n = nums.length;
        while(i<n){
            if(stack.isEmpty()){
                stack.push(nums[i]);
                i++;
            }else{
                int top = stack.peek();
                if(nums[i] > top){
                    while (stack.size() >1)
                        stack.pop();
                    stack.push(nums[i]);
                }
                else if(nums[i] < top){
                    if(stack.size() >= 2){
                        int max_j = stack.pop();
                        int smalli = stack.pop();
                        if(smalli < nums[i] && nums[i] < max_j )return true;
                        else {
                            stack.push(smalli);
                            stack.push(max_j);
                            i++;
                            continue;
                        }
                    }else{
                        stack.clear();
                    }
                    stack.push(nums[i]);
                }
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "aaa".intern();
        int[] arr = {8,10,4,6,5};
        lc456 sl = new lc456();
        System.out.println(sl.find132pattern(arr));
    }
}
