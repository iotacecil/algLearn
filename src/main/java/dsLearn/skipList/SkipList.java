//package dsLearn.skipList;
//
//import java.util.concurrent.ConcurrentSkipListMap;
//
//public class SkipList {
//    private static class SkipListNode{
//        int data;
//        SkipListNode[] next;
//
//        public SkipListNode(int data, int level) {
//            this.data = data;
//            this.next = new SkipListNode[level+1];
//        }
//    }
//    private int maxLevel;
//    SkipListNode header;
//    private static final int INFINITY = Integer.MAX_VALUE;
//    SkipList(int maxLevel){
//        this.maxLevel = maxLevel;
//        header = new SkipListNode(0,maxLevel);
//        SkipListNode last = new SkipListNode(INFINITY,maxLevel);
//        for (int i = 0; i <=maxLevel ; i++) {
//            header.next[i] = last;
//        }
//    }
//    boolean find(int key){
//        SkipListNode current = header;
//        for (int i = maxLevel; i >=0 ; i--) {
//            SkipListNode next = current.next[i];
//            while (next.data<key){
//                current = next;
//                next = current.next[i];
//            }
//        }
//        current = current.next[0];
//        if(current.data==key)return true;
//        else return false;
//    }
//
//
//    void insert(int searchKey,int newValue){
//        SkipListNode[] update = new SkipListNode[maxLevel+1];
//        SkipListNode current = header;
//        for(int i =maxLevel){
//
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
