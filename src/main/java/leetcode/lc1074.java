package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCach {
    Map<Integer, Node> cache;
    LinkedList<Node> list;

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            //this.idx =idx;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value;
        }
    }

    int capacity;

    public LRUCach(int capacity) {
        list = new LinkedList<>();
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            list.remove(node);
            list.add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            list.remove(node);

        } else {
            if (list.size() == capacity) {
                //  System.out.println(list);
                Node first = list.getFirst();
                cache.remove(first.key);
                list.removeFirst();
            }

        }
        Node node = new Node(key, value);
        list.add(node);
        cache.put(key, node);
    }
}

public class lc1074 {
    public static void main(String[] args) {
        LRUCach cache = new LRUCach(2);
        cache.put(2, 1);
//        cache.put(2,2);
//        cache.get(1);
        System.out.println(cache.list);
        cache.put(1, 1);    // 该操作会使得密钥 2 作废
        System.out.println(cache.list);

        cache.put(2, 3);    // 该操作会使得密钥 2 作废
        cache.put(4, 1);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(1));
        System.out.println(cache.list);

        System.out.println(cache.get(2));

//        cache.get(2);       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        cache.get(1);       // 返回 -1 (未找到)
//        cache.get(3);       // 返回  3
//        cache.get(4);       // 返回  4


    }
}
