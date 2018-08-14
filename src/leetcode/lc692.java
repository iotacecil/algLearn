package leetcode;

import java.util.*;

public class lc692 {
    //快速排序
//    public List<String> topKFrequent2(String[] words, int k) {
//
//    }
//    private int partition(ArrayList<Map.Entry<String,Integer>> list,int low,int high){
//        Map.Entry<String, Integer> tmp = list.get(low);
//
//    }
//    private List<String> topK(HashMap<String,Integer> wordcount,int k){
//        ArrayList<Map.Entry<String,Integer>> flatwordcounts = new ArrayList<>(wordcount.entrySet());
//        int low = 0;
//        int high = flatwordcounts.size()-1;
//        while (low<high){
//            int pivot = partition(flatwordcounts,low,high);
//            if(pivot==k-1)break;
//            if(pivot<k-1)low=pivot+1;
//            else high = pivot-1;
//        }
//    }
    public static void main(String[] args) {

        Map<Integer,List<Integer>> bucke = new HashMap<>();


    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        List<String> rst = new ArrayList<>();

        for(int i =0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }
            else{
                map.put(words[i],1);
            }

        }
        PriorityQueue<Map.Entry<String,Integer>> que = new PriorityQueue<>(k,
                (a,b)->a.getValue()==b.getValue()?
                        b.getKey().compareTo(a.getKey()):
                        a.getValue()-b.getValue());
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            que.offer(entry);
            if(que.size()>k)que.poll();
            entry.getValue();

        }

        while(!que.isEmpty()){
            rst.add(0,que.poll().getKey());
        }
        return rst;
    }
}
