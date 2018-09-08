package leetcode;

import java.util.HashMap;

//LRUCache cache = new LRUCache( 2 /* capacity */ );
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4



public class LRUCache {
    //双向链表
    class DoubleLinkedNode{
        //和hashmap对应，用于日后扩容
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
    }
    HashMap<Integer,DoubleLinkedNode> cache;
    int capacity;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    //创建一个头节点

    //链表操作：
    //1. get/update中间的node移到链表最前面
    private void move2head(DoubleLinkedNode node){
        /**** star ****/
        this.remove(node);
        this.addNode(node);
    }
    //2. put1 头插
    private void addNode(DoubleLinkedNode node){
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }
    //3. put2 删除节点 (1删除中间的，移到最开头 2.删除尾巴)
    private void remove(DoubleLinkedNode node){
        DoubleLinkedNode pre = node.pre;
        DoubleLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    //4.删除尾巴,
    private int removeTail(){
        DoubleLinkedNode pre = tail.pre;
        this.remove(pre);
        return  pre.key;

    }

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        //创建一个头节点
        head = new DoubleLinkedNode();
        head.pre = null;
        //创建一个空尾巴
        tail = new DoubleLinkedNode();
        tail.next= null;

        head.next = tail;
        tail.pre = head;


    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if(node == null)
            return -1;
        move2head(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if(node == null) {
            //插入新值
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;
            //1. 考虑容量剩余,满不满都要插入，但是满了要先删除
            if (capacity == 0) {
                //删除尾巴

                int deleteKey = removeTail();
                cache.remove(deleteKey);
                capacity++;
            }
            //2. 插入队列
            addNode(newNode);
            //3. 加入hash
            cache.put(key, newNode);
            capacity--;
        }else {
            node.value = value;
            move2head(node);
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        System.out.println(cache.get(4));
    }
}
