package leetcode;

import java.util.*;

public class lc315 {
    class NumArray {

        int[] nums=null;
        int[] e = null;
        int len =0;
        public NumArray(int[] nums) {
            len = nums.length;
            e = new int[len+1];
            this.nums = new int[len];
            for(int i =0;i<len;i++){
                update(i,nums[i]);
            }
        }
        int query(int i){
            int sum = 0;
            while(i>0){
                sum+=e[i];
                i-=(i&-i);
            }
            return sum;
        }
        int rangeSum(int i,int j){
            return query(j+1)-query(i);
        }
        void update(int i,int val){
            int dif = val-nums[i];
            nums[i++]=val;
            while(i<e.length){
                e[i]+=dif;
                i+=(i&-i);
            }
        }
    }
    public List<Integer> countSmallerBIT(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if(nums == null || nums.length ==0){
            return res;
        }
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            min = Math.min(min, num);
        }
        int max = Integer.MIN_VALUE;
        //
        for(int num:nums){
            max = Math.max(max, (num - min));
        }
        return  res;

    }


    class Node{
        Node left,right;
        int val,sum,dup = 1;

        public Node(int val, int sum) {
            this.val = val;
            this.sum = sum;
        }
    }
    private Node insert(int num,Node node,Integer[] ans,int i,int presum){
        if(node == null){
            node = new Node(num,0);
            ans[i] = presum;
        }else if(node.val == num){
            node.dup++;
            ans[i] = presum + node.sum;
        }else if(node.val > num){
            // 向左
            node.sum++;
            node.left = insert(num, node.left, ans, i, presum);
        }else{
            node.right = insert(num, node.right, ans, i, presum+node.sum+node.dup);
        }
        return node;
    }

    public List<Integer> countSmall(int[] nums){
        int n = nums.length;
        Node root = null;
        Integer[] rst = new Integer[n];
        for (int i = n-1; i >=0 ; i--) {
            root = insert(nums[i],root,rst ,i,0 );
        }
        return Arrays.asList(rst);
    }




    public  int lowerBound(int[] nums, int target) {
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
    // 有问题
    public List<Integer> countSmallerBinary(int[] nums) {
        int n = nums.length;
        // 1 2 5 6
        List<Integer> ist = new ArrayList<>(n);
        Integer[] rst = new Integer[n];
//        int[] ist = new int[n];
//        Arrays.fill(ist, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            int pos = Collections.binarySearch(ist, nums[i]);
//            int pos = lowerBound(ist, nums[i]);
            if(pos<0)
                pos = -(pos+1);
                ist.add(pos, nums[i]);

            rst[i] = pos;
        }
        return Arrays.asList(rst);
    }
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }
        mergesort(nums, indexes, 0, nums.length - 1);
        for(int i = 0; i < count.length; i++){
            res.add(count[i]);
        }
        return res;
    }
    private void mergesort(int[] nums, int[] indexes, int start, int end){
        if(end <= start){
            return;
        }
        int mid = (start + end) / 2;
        mergesort(nums, indexes, start, mid);
        mergesort(nums, indexes, mid + 1, end);

        merge(nums, indexes, start, end);
    }
    private void merge(int[] nums, int[] indexes, int start, int end){
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;
        int[] new_indexes = new int[end - start + 1];

        int sort_index = 0;
        while(left_index <= mid && right_index <= end){
            if(nums[indexes[right_index]] < nums[indexes[left_index]]){
                new_indexes[sort_index] = indexes[right_index];
                rightcount++;
                right_index++;
            }else{
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
            }
            sort_index++;
        }
        while(left_index <= mid){
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
            sort_index++;
        }
        while(right_index <= end){
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for(int i = start; i <= end; i++){
            indexes[i] = new_indexes[i - start];
        }
    }


    public static void main(String[] args) {
        lc315 sl = new lc315();
//        System.out.println(sl.countSmallerBinary(new int[]{5, 2, 6, 1}));
        System.out.println(sl.countSmall(new int[]{2,0,1}));
    }
}
