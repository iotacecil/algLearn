package leetcode;

public class lc61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)return head;
        ListNode fast = head;
        int i = 0;
        //   ListNode dumy = new ListNode(0);
        int len = 0;
        while(fast !=null){
            fast = fast.next;
            len++;
        }
        System.out.println(len);
        k %= len;
        fast = head;
        while(i++<k && fast!=null){
            fast = fast.next;
        }
        // if(i<=k)return head;

        ListNode slow = head;
        while(fast.next!=null){
            fast = fast.next;
            // 倒数 k+1
            slow = slow.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        // dumy.next = tmp;
        fast.next = head;

        return tmp;

    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        lc61 sl = new lc61();
        sl.rotateRight(one,4 );
    }
}
