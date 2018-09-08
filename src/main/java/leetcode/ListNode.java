package leetcode;

public class ListNode {

      int val;
      ListNode next;
      //构造函数
      ListNode(int x) { val = x; }
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
