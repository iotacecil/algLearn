package leetcode;

public class ListNode {

      public int val;
      public ListNode next;
      //构造函数
      public ListNode(int x) { val = x;
      next = null;}
      @Override
      public String toString(){
          String out = ""+val;
          ListNode cur = this;
          while(cur.next!=null){
              out+="->"+cur.next.val;
              cur=cur.next;
          }
          return out;
      }

}
