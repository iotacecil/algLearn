package niuke.codedance;

import leetcode.ListNode;

/*

 1->3
 2->1->3
 0>2>1>3
 cur = 3


        0->1->2->3->4->5->6
     * |           |
     * pre        next
     * after call pre = reverse(pre, next)
     *
     *  0->3->2->1->4->5->6
     *          |  |
     *          pre next
 */
public class 从后向前k个一组反转链表 {
    //区间reverse
//    private static ListNode reverse(ListNode pre,ListNode next){
//        ListNode last = pre.next;
//        ListNode cur = last.next;
//        while (cur != next){
//            last.next = cur.next;
//            cur.next = pre.next;
//        }
//    }

    public static ListNode rangereverse(ListNode pre, ListNode after) {
        ListNode cur = pre.next;
        while (cur != after) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = cur;
        }
        return cur;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || n == m) return head;
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode pre = dumy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = 0; i < m - n; i++) {
            ListNode next = cur.next;
            System.out.println(next.val);
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        reverseBetween(one, 2, 4);

    }
}
