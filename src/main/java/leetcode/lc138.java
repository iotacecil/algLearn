package leetcode;


public class lc138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
//    public Node copyRandomList(Node head) {
//        if(head == null)return null;
//        Node node = new Node(head.val,copyRandomList(head.next),copyRandomList(head.random));
//        return node;
//    }
}
