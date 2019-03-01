package leetcode;

public class lc206 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode pre = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next =pre;
            pre=head;
            head = temp;
        }
        return pre;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }

    public static void main(String[] args) {

    }
}
