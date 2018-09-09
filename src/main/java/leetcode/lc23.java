package leetcode;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class componod implements Comparator<node>{


    @Override
    public int compare(node o1, node o2) {
        return o1.val-o2.val;
    }
}
class node{
    node next;
    int val;
    public node(int x){
        val =x;
    }
    @Override
    public String toString() {
        return ""+val;
    }
//    /**
//     * Compares this object with the specified object for order.  Returns a
//     * negative integer, zero, or a positive integer as this object is less
//     * than, equal to, or greater than the specified object.
//     * <p>
//     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
//     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
//     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
//     * <tt>y.compareTo(x)</tt> throws an exception.)
//     * <p>
//     * <p>The implementor must also ensure that the relation is transitive:
//     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
//     * <tt>x.compareTo(z)&gt;0</tt>.
//     * <p>
//     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
//     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
//     * all <tt>z</tt>.
//     * <p>
//     * <p>It is strongly recommended, but <i>not</i> strictly required that
//     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
//     * class that implements the <tt>Comparable</tt> interface and violates
//     * this condition should clearly indicate this fact.  The recommended
//     * language is "Note: this class has a natural ordering that is
//     * inconsistent with equals."
//     * <p>
//     * <p>In the foregoing description, the notation
//     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
//     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
//     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
//     * <i>expression</i> is negative, zero or positive.
//     *
//     * @param o the object to be compared.
//     * @return a negative integer, zero, or a positive integer as this object
//     * is less than, equal to, or greater than the specified object.
//     * @throws NullPointerException if the specified object is null
//     * @throws ClassCastException   if the specified object's type prevents it
//     *                              from being compared to this object.
//     */
//    @Override
//    public int compareTo(@NotNull Object o) {
//        node oo = (node)o;
//        return (oo.val-val);
//    }
class cmp implements Comparator<ListNode>{
        @Override
    public int compare(ListNode o1,ListNode o2){
        return o1.val-o2.val;
    }}
public class lc23 {

    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length
                ;
        List<Integer> list = new ArrayList<>();
        list.set(1,2);
        List<ListNode> nodelist = new ArrayList<>();
nodelist.forEach((item)-> System.out.println(item.val));
        ListNode nH = new ListNode(0);
        ListNode head = nH;
        for(int i =0;i<len;i++){
            ListNode tmp = lists[i];
            while(tmp.next!=null){
                nodelist.add(tmp);
                tmp=tmp.next;
            }
        }
        nodelist.sort(new cmp());
        //nH->tmp nH.next=tmp.next = ...
        for(ListNode tmp :nodelist){

            nH.next = tmp;
            nH.next =nH.next.next;
        }
        return head.next;

    }

    }
    public static void main(String[] args) {
        node one = new node(1);
        node two = new node(999);
        node san = new node(3);
        node four = new node(4);

        List<node> nodeList = new ArrayList<>();
        nodeList.add(one);
        nodeList.add(two);
        nodeList.add(san);
        nodeList.add(four);
        nodeList.sort(new componod());
        System.out.println(nodeList);
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

