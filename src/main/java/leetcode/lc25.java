package leetcode;

public class lc25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode pre = dumy;


        while (true) {
            ListNode fontk = pre;

            for (int i = 0; i < k; i++) {
                fontk = fontk.next;
                if (fontk == null) return dumy.next;
            }
            // after
            System.out.println(fontk.val);
            ListNode last = pre.next;

            for (int i = 0; i < k - 1; i++) {
                ListNode next = last.next;
                last.next = next.next;
                next.next = pre.next;
                pre.next = next;

                //dumy->2->1->3  -> dumy 3->2->1
            }
            pre = last;

        }
        //  return dumy.next;
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
        lc25 sl = new lc25();
        sl.reverseKGroup(one, 3);
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode p = head;
//        for(int i = 0;i<k;i++){
//            p = p.next;
//        }
//        ListNode pre = reverseKGroup(p.next,k);
//
//        ListNode cur = head.next;
//        for(int i = 0;i<k-1;i++){
//            ListNode nn = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = nn;
//        }
//
//        return pre;
//    }
//
//    public static void main(String[] args) {
//        ListNode one = new ListNode(0);
//        ListNode two = new ListNode(1);
//        ListNode three = new ListNode(2);
//        ListNode four = new ListNode(3);
//        one.next = two; two.next = three;
//        three.next = four;
//        lc25 sl =new lc25();
//        System.out.println(sl.reverseKGroup(one, 2));
//    }
}
