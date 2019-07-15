package leetcode;

abstract class c2{
    public static void main(String[] args) {
        System.out.println("aaa" );
    }
        }
public class lc92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || n == m)return head;
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode pre = dumy;
        for (int i = 0; i <m-1 ; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        for (int i = 0; i <n-m ; i++) {
            ListNode next = start.next;
            //1->3
           start.next = next.next;
           //3->2
            next.next = pre.next;
            pre.next = next;
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        node1.next = node2;

    }
}
