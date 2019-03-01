package leetcode;

public class lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        head = dumy;
        //如果后面有两个点
        while(head.next !=null && head.next.next!=null ){
            if(head.next.val == head.next.next.val){
                int val = head.next.val;
                while(head.next !=null &&head.next.val == val){
                    head.next = head.next.next;
                }
            }else{
                head = head.next;
            }
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        lc82 sl = new lc82();
        sl.deleteDuplicates(one);
    }
}
