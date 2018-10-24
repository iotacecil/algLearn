package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc23mergeKListNode {

    public ListNode mergeDivid(ListNode[] lists){
        if(lists.length ==0)return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2){
            return mergeTwoLists(lists[0],lists[1] );
        }
        int mid = lists.length / 2;
        ListNode[] sub1 = new ListNode[mid];
        ListNode[] sub2 = new ListNode[lists.length - mid];
        for (int i = 0; i < mid; i++) {
            sub1[i] = lists[i];
        }
        for (int i = mid; i <lists.length; i++) {
            sub2[i-mid] =  lists[i];
        }
        ListNode listNode1 = mergeKLists(sub1);
        ListNode listNode2 = mergeKLists(sub2);
        return mergeTwoLists(listNode1, listNode2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
//        List<ListNode> all = Arrays.asList(lists);
//        Arrays.sort(lists,(l1,l2)->l1.val-l2.val );

        List<ListNode> all = new ArrayList<>();

        for(ListNode node : lists){
            while (node!=null){
                all.add(node);
                node = node.next;
            }
        }
        all.sort((l1,l2)->l1.val-l2.val);
        ListNode tmp = new ListNode(-1);
        ListNode pre = tmp;
        for(ListNode node :all){
            pre.next = node;
            pre = pre.next;
        }
        return tmp.next;

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

        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(6);
        l7.next = l8;
        ListNode[] lists = {l1, l4, l7};
        lc23mergeKListNode sl = new lc23mergeKListNode();
        System.out.println(sl.mergeDivid(lists));
    }
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
}
