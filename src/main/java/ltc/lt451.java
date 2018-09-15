package ltc;

import leetcode.ListNode;

public class lt451 {
    //todo lc24
    /**
     * 两两交换链表节点位置
     * @param head 1->2->3->4
     * @return 2->1->4->3
     */
    public ListNode swapPairs(ListNode head) {
      ListNode dumy = new ListNode(0);
      dumy.next = head;
      head = dumy;
      while(head.next!=dumy&&head.next.next!=null){
          ListNode l1 = head.next, l2 = head.next.next;
          head.next = l2;
          l1.next = l2.next;
          l2.next = l1;
          head = l1;
      }
        return dumy.next;
      }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next =three;
        three.next = four;
    }

}
