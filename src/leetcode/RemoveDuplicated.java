package leetcode;

public class RemoveDuplicated {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode p = head;
        while (p!=null&&p.next!=null) {
            //1：1->1->1
            if (p.val == p.next.val) {
                //2：第二个元素等于第三个元素 3.1->1下一轮循环1->null
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        a.next=b;
        b.next=c;
        ListNode del=deleteDuplicates(a);
        System.out.println(del);
    }


}
