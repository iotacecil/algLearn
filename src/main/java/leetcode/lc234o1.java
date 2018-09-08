package leetcode;

public class lc234o1 {
    //找到中点，反转后半段与前半段比较
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findmiddle(head).next;
        while(head!=null&&mid!=null){
            if(head!=mid)return false;
            head=head.next;
            mid= mid.next;

        }
        return true;

    }

    public ListNode findmiddle(ListNode head){//1,2,3
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head!=null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.printf("%n");
        System.out.printf("%n");
        System.out.printf("%n");
    }
}
