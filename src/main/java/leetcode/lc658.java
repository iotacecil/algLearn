package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lc658 {
    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int h = n - 1;
        List<Integer> rst = new ArrayList<>();
        //[0] -1 mid = 0 h = -1 -> l = 0
        //[0]  1 mid = 0 l = 1
        while (l <= h) {
            int mid = l + (h - l) / 2;
            // if(arr[mid] == x)break;
            if (arr[mid] >= x) {
                h = mid - 1;
            } else l = mid + 1;
        }

        int start = Math.min(l, n - 1);
        if (arr[start] != x) {
            start = Math.max(start - 1, 0);
        }

        int ll = start;
        int rr = start;
        rst.add(arr[start]);
        k--;
        while (ll >= 0 && rr < n) {
            if (k == 0) break;

            if (ll - 1 >= 0 && rr + 1 < n) {
                if (x - arr[ll - 1] <= arr[rr + 1] - x) {
                    rst.add(arr[ll - 1]);
                    ll--;
                } else {
                    rst.add(arr[ll - 1]);
                    ll--;
                }
            } else if (ll - 1 >= 0) {
                rst.add(arr[--ll]);

            } else if (rr + 1 < n) {
                rst.add(arr[++rr]);

            }
            k--;
        }
        rst.sort((a, b) -> a - b);

        return rst;
    }
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

        int[] arr = new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        int k = 3, x = 5;
        lc658 sl = new lc658();
        System.out.println(sl.findClosestElements3(arr, k, x));
    }
}
