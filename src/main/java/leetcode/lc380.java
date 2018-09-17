package leetcode;

import java.util.*;

/**
 * Design a data structure
 * that supports all following operations in average O(1) time.
 *
 * 为了random需要array，为了0(1)添加删除需要hashtable
 * insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned
 */
class RandomizedSetnext {

    Map<Integer,Integer> valIdx;
    List<Integer> list;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSetnext() {
        valIdx = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valIdx.containsKey(val))return false;
        valIdx.put(val,list.size() );
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valIdx.containsKey(val))return false;
        int idx = valIdx.get(val);
        //最后一个元素放到前面来，更新map索引
        int last = list.get(list.size() - 1);
        list.set(idx,last);
        valIdx.put(last,idx);
        //删除
        list.remove(list.size()-1);
        valIdx.remove(val);
        return true;


    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
public class lc380 {


    public static void main(String[] args) {
        RandomizedSetnext randomSet = new RandomizedSetnext();
        randomSet.insert(1);
        randomSet.remove(2);
        randomSet.insert(2);
        randomSet.getRandom();

    }
}
