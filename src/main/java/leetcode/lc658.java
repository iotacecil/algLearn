package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lc658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int start = 0, end = arr.length-k;
        // 死循环
        while(start<end) {
            int mid = (start + end)/2;
            if (x - arr[mid] <= arr[mid+k]-x)
                start = mid;
            else
                end = mid+1;
        }

        List<Integer> results = new ArrayList<Integer>();
        for(int i=start;i<start+k;i++){
            results.add(arr[i]);
        }
        return results;
    }
    /// ---------------- 3.6%
    class pair{
        int num;
        int dif;

        public pair(int num, int dif) {
            this.num = num;
            this.dif = dif;
        }
    }
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int n = arr.length;
        ArrayList<Integer> rst = new ArrayList<>();
        PriorityQueue<pair> queue = new PriorityQueue<>((a,b)->(a.dif - b.dif)!=0?(a.dif - b.dif):(a.num - b.num));
        for(int a :arr){
            queue.add(new pair(a,Math.abs(a-x)));
        }
        while (k-->0){
            rst.add(queue.poll().num);
        }

        rst.sort(Integer::compareTo);
        return rst;

    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int k=4, x=3;
        lc658 sl = new lc658();
        System.out.println(sl.findClosestElements(arr, k, x));
    }
}
