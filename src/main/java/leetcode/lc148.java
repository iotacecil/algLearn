package leetcode;

public class lc148 {


    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMiddle(head);

        ListNode right = mid.next;
//        System.out.println(right.val);
        mid.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(right);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dumy = new ListNode(0);
        ListNode p = dumy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        if (l != null) {
            p.next = l;

        }
        if (r != null) {
            p.next = r;

        }
        return dumy.next;
    }

//    public ListNode sortList(ListNode head){
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode prev = null;
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast!=null && fast.next != null){
//            prev = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        System.out.println(slow.val);
//        prev.next = null;
//        // step 2. sort each half
//        ListNode l1 = sortList(head);
//        ListNode l2 = sortList(slow);
//
//        // step 3. merge l1 and l2
//        return merge(l1, l2);
//    }
//

    public static void main(String[] args) {
        lc148 sl = new lc148();
        //1->2 1->null 1->2
        //slow = 2
        ListNode four = new ListNode(4);
        ListNode two = new ListNode(2);
        four.next = two;
        ListNode listNode = sl.sortList(four);
        System.out.println(listNode);
    }
}
