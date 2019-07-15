package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class LFUCache {
    long timestamp;
    class node{
        int key;
        int value;
        int cnt;
        long ts;
        node(int key,int val,long ts){
            this.key = key;
            this.value = val;
            this.cnt = 0;
            this.ts = ts;
        }
        public boolean equals(Object object) {return key==((node) object).key;}
        public int hashCode() {return key;}
        public String toString(){
            return key+" "+value+" "+cnt+" "+ts;
        }
    }
    public Map<Integer,node> cache;
    PriorityQueue<node> minpq;
    int capacity;
    public LFUCache(int capacity) {
        timestamp = 0;
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        minpq = new PriorityQueue<>((a, b)->a.cnt== b.cnt? (int)(a.ts -b.ts):a.cnt-b.cnt);
    }

    public int get(int key) {
        timestamp++;
        if(cache.size()<1)return -1;
        if(cache.containsKey(key)){
            node nd = cache.get(key);
            nd.cnt++;

            minpq.remove(nd);
            nd.ts = timestamp;
            minpq.add(nd);
            return nd.value;
        }
        else return -1;

    }

    public void put(int key, int value) {
        if(capacity == 0)return;
        if(cache.containsKey(key)){
            node nd = cache.get(key);
            nd.value = value;
            nd.cnt++;
            minpq.remove(nd);
            nd.ts = timestamp;
            minpq.add(nd);
            return;
        }else{
            if(cache.size() ==  capacity){
                node min = minpq.poll();

                cache.remove(min.key);

            }
            timestamp++;
            node nd = new node(key,value,timestamp);
            minpq.add(nd);
            cache.put(key,nd);
        }
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class lc460 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(2,1 );
        System.out.println(cache.minpq);

        cache.put(1,1 );
        System.out.println(cache.minpq);


        cache.put(2,3 );
        System.out.println(cache.minpq);

        cache.put(4,1 );
        System.out.println(cache.minpq);

        cache.get(1);

        System.out.println(cache.minpq);
        System.out.println(cache.minpq);

//
//        LFUCache2 cache2 = new LFUCache2(2);
//        cache2.set(1,1 );
//        System.out.println(cache2.queue);
//
//        cache2.set(2,2 );
//        System.out.println(cache2.queue);

    }
}
