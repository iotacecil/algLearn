package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    ArrayList<Integer> index;
    HashMap<Integer,Integer> map;
    Random rand = new Random();
     RandomizedSet() {
        index = new ArrayList<>();
        map = new HashMap<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
     boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if(contain) return false;
        index.add(val);
        map.put(val,index.size());
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if(!contain)return false;
        int ind = map.get(val);
        if(ind<index.size()-1){
            int last = index.get(index.size()-1);
            index.set(ind,last);
            map.put(last,ind);
        }
        map.remove(val);
        index.remove(index.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
       return index.get(rand.nextInt(index.size()));
    }

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

// Returns false as 2 does not exist in the set.
        randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

// 2 was already in the set, so return false.
        randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();

    }
}
