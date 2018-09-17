//package leetcode;
//
//import java.util.*;
//
//class RandomizedCollection {
////Duplicate elements are allowed.
//    Map<Integer,List<Integer>> valIdxs;
//    Random rand = new Random();
//    List<Integer> list;
//    /** Initialize your data structure here. */
//    public RandomizedCollection() {
//        valIdxs = new HashMap<>();
//        list = new ArrayList<>();
//    }
//
//    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
//    public boolean insert(int val) {
//        List<Integer> idxs;
//        if(valIdxs.containsKey(val)){
//             idxs= valIdxs.get(val);
//        }else{
//            idxs = new ArrayList<>();
//        }
//        idxs.add(list.size());
//        valIdxs.put(val,idxs);
//        list.add(val);
//        return true;
//    }
//
//    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
//    public boolean remove(int val) {
//        if(!valIdxs.containsKey(val))return false;
//        List<Integer> idxs = valIdxs.get(val);
//        for(int idx : idxs){
//
//        }
//    }
//
//    /** Get a random element from the collection. */
//    public int getRandom() {
//
//    }
//}
//public class lc381 {
//
//}
