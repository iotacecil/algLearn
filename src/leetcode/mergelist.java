package leetcode;
class Solution3 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newone = new ListNode(0);
        //记得保存返回位置：头指针
        ListNode head = newone;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                newone.next = l1;
                l1=l1.next;
            }else {
                newone.next = l2;
                l2= l2.next;
            }
            //返回数组递推
            newone=newone.next;
        }
        if(l1!=null)newone.next=l1;
        if(l2!= null)newone.next=l2;
        //去掉0
        return head.next;
    }
}
public class mergelist {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l4.next=l5;
        l5.next=l6;
        Solution3 s3 = new Solution3();
        System.out.println(l1);
        System.out.println(l4);
        System.out.println(s3.mergeTwoLists(l1,l4));
    }
}
