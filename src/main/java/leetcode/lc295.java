package leetcode;

import java.util.PriorityQueue;

class MedianFinder {


    /** initialize your data structure here. */
    PriorityQueue<Integer> maxleft;
    PriorityQueue<Integer> minright;

    public MedianFinder() {
        maxleft = new PriorityQueue<>((a,b)->b-a);
        minright = new PriorityQueue<>();
    }

    public void addNum(int num) {
        Integer left = maxleft.peek()==null?Integer.MAX_VALUE:maxleft.peek();
        Integer right = minright.peek()==null?Integer.MIN_VALUE:minright.peek();
        if(num <left || (num <right && maxleft.size() == minright.size())){
            if(maxleft.size() -minright.size()==1){
                Integer top = maxleft.poll();
                minright.add(top);
            }
            maxleft.add(num);

        }else{
            if(minright.size() -maxleft.size()==0){
                Integer top = minright.poll();
                maxleft.add(top);
            }
            minright.add(num);


        }

    }

    public double findMedian() {
      //  data.sort(Integer::compareTo);
        int n = maxleft.size() + minright.size();
        if(n % 2 == 0){
            return (maxleft.peek()+minright.peek())/2.0;
        }else return maxleft.peek();
    }
}

public class lc295 {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(40);
        mf.addNum(12);
        mf.addNum(16);
        System.out.println(mf.findMedian());
    }
}
