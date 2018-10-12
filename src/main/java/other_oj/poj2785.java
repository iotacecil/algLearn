package other_oj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//4 Values whose Sum is 0
//p160
//Accepted	29716K	10329MS 其实还是二分快 可能是oj的map慢(?
public class poj2785 {

    public static long cnt(int[] A, int[] B, int[] C, int[] D) {
//        Accepted	138880K	19625MS	Java
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i <C.length ; i++) {
            for (int j = 0; j <D.length ; j++) {
                int sum = C[i] + D[j];
                int cnt = 1;
                if(map.get(sum)!=null){
                    cnt+=map.get(sum);
                }
                map.put(sum,cnt );
            }
        }
        long res = 0;
        for (int i = 0; i <A.length ; i++) {
            for (int j = 0; j <B.length ; j++) {
                int cnt = 1;
                if(map.get(-(A[i]+B[j]))!=null){
                    res+=map.get(-(A[i]+B[j]));
                }
            }
        }
        return res;
//        int n = A.length;
//        int[] CD = new int[n * n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                CD[i * n + j] = C[i] + D[j];
//            }
//        }
//        Arrays.sort(CD);
//
//        long cnt = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int cd = -(A[i] + B[j]);
//                //WA 一个AB对应的CD要全部加上去 不然错过这个AB就漏掉了
////                if (binarySearch(CD, cd))
////                cnt++;
//                //两者相减正好是排好序之后的数组中某个元素的个数
//
//                cnt+=searchRange2(CD, cd)[0]==-1?0:searchRange2(CD, cd)[1]-searchRange2(CD, cd)[0]+1;
//
//            }
//        }
//        return cnt;
    }
//29716K	10500MS
    public static int[] searchRange2(int[] A, int target) {
        int start = findFirst(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, findFirst(A, target + 1) - 1};
    }
    private static int findFirst(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }

        public static int upper_bound(int[] a,int k){
        if (a == null || a.length == 0) return -1;
        int lb = -1,ub = a.length;
        while (ub - lb > 1) {
            int mid = (lb+ub)/2;
            if(a[mid]<=k){
                lb = mid;
            }else
                ub = mid;
        }
        return lb;
    }
    public static int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] >= target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }
        return ub;
    }
    public static int[] searchRange(int[] a, int k) {
        if(a==null||a.length<1)return new int[]{-1,-1};
        int first = lowerBound(a, k);
        if(first==a.length||a[first]!=k)return new int[]{-1,-1};


        int last = upper_bound(a, k);
        last = last==-1||a[last]!=k?-1:last;
        return new int[]{first,last};
    }
    //全部 n^4种可能
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
            D[i] = sc.nextInt();
        }
        System.out.println(cnt(A, B, C, D));


    }
}
