package leetcode;

public class lc21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode tem_head = new ListNode(-1);
       ListNode pre = tem_head;
       while (l1 != null && l2 != null){
           if(l1.val < l2.val){
             pre.next = l1;
             l1 = l1.next;
           }else{
               pre.next = l2;
               l2 = l2.next;
           }
           pre = pre.next;
       }
       if(l1!=null){
           pre.next = l1;
       }
       if(l2!=null){
           pre.next =l2;
       }
       return tem_head.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        lc21 sl = new lc21();
        System.out.println(sl.mergeTwoLists(l1, l4));

    }
}
