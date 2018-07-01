package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {

    }
}
