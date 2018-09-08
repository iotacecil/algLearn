package leetcode;

import java.util.Random;

public class lc382 {
    ListNode node;
    static Random r;
    public lc382(ListNode head) {
        this.node = head;
        this.r = new Random();

    }

    /** Returns a random node's value. */
    //报空指针？？
    public int getRandom() {
        int rst = node.val;
        node = node.next;
        for(int i =1;node!=null;node= node.next){
            if(r.nextInt(i+1)==i)rst = node.val;
            i++;

        }
        return rst;
    }

    public static void main(String[] args) {
        lc382 sl =new lc382(new ListNode(1));
        System.out.println(sl.getRandom());
    }
}
