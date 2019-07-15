package leetcode;

public class lc25 {
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
