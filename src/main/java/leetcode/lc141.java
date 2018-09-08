package leetcode;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Vector;

public class lc141 {
    public boolean hasCycle(ListNode head) {
        if(head== null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast= fast.next.next;
            slow= slow.next;
            if(fast==slow)return true;
        }

        return false;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        System.out.println(minStack.top());

        System.out.println(minStack.getMin());

//        int head = 0;
//        int length = 8;
//        //8->1000 ;7->0111;10-1=9->1001 ;->1
//        head = (head - 1) & (length - 1);
//        System.out.println();
//
//        System.out.println(head);
//        System.out.println(999999&7);
//        System.out.println(999999%8);
//        int a = -6;
//        //0x80000000表示最高位为1的数字
//        for(int i =0;i<32;i++){
//            //取出a的第一位 //无符号右移( >>> )
//            int t = (a&0x80000000>>>i)>>>(31-i);
//            System.out.print(t);
//        }
    }
}