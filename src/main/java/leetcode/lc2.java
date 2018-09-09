package leetcode;

public class lc2 {
    public ListNode add2(ListNode l1,ListNode l2){
        ListNode dumy = new ListNode(0);
        ListNode cur = dumy;
        int carry = 0;
        while (l1!=null|l2!=null){
            int x = (l1!=null)?l1.val:0;
            int y = (l2!=null)?l2.val:0;
            int sum = carry+x+y;
            carry = sum/10;
            cur.next = new ListNode((sum%10));
            cur = cur.next;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
        if(carry>0){
            cur.next = new ListNode(carry);
        }
        return dumy.next;
    }
}
