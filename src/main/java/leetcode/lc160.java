package leetcode;

public class lc160 {

        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null||headB==null)return null;
            ListNode a = headA;
            ListNode b = headB;

            while(a!=b){
                if(a==null){a=headB;}else{a=a.next;}
                if(b==null){b=headA;}else{b=b.next;}



            }
            return a;

        }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next=c;
        b.next=c;
        System.out.println(getIntersectionNode(a,b));


    }
}
