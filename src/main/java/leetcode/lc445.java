package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc445 {
    //31%
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> que1 = new ArrayDeque<>();
        Deque<ListNode> que2 = new ArrayDeque<>();
        while (l1 != null) {
            que1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            que2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = null;
        ListNode cur = dummy;
        while (!que1.isEmpty() || !que2.isEmpty()) {
            if (!que1.isEmpty() && !que2.isEmpty()) {
                int sum = que1.poll().val + que2.poll().val + carry;
                System.out.println(sum);
                 carry = sum / 10;
                ListNode tmp = new ListNode(sum % 10);
                tmp.next = cur;
                cur = tmp;
            } else {

                int sum = (que1.isEmpty() ? que2.poll().val : que1.poll().val) + carry;
                carry = sum / 10;
                ListNode tmp = new ListNode(sum % 10);
                tmp.next = cur;
                cur = tmp;
            }
        }
        if(carry!=0){
            ListNode tmp = new ListNode(1);
            tmp.next = cur;
            cur = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(7);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        root.next = two;
        two.next = four;
        four.next = three;

        ListNode root2 = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode four2 = new ListNode(4);
        root2.next = six;
        six.next = four2;

        lc445 sl = new lc445();
        System.out.println(sl.addTwoNumbers(root, root2));

    }
}
