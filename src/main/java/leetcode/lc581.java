package leetcode;

//需要排序的最小子串，整个串都被排序了 递增
public class lc581 {
    public static int fid(int[]A){
        //1,3,2,2,2
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);//从前往后，找到最大值max=3
            min = Math.min(min, A[n-1-i]);//从后往前找到最小值min=2
            if (A[i] < max) end = i; //a=2<3 end = 2->3->4 直到找到a[i]>max
            if (A[n-1-i] > min) beg = n-1-i;//begin =1 直到找到a[i]<min
        }
        return end - beg + 1;
    }


    public static int findUnsortedSubarray2(int[] nums) {
        int len = nums.length;
        int max = nums[0];//2
        int min = nums[len-1];//1
        int end=-2,begin=-1;
        //[2, 6, 4, 8, 10, 9, 15]

        for(int i=0;i<len;i++){
            max = Math.max(max,nums[i]);
            //左边的最大值(6,4) //2
            min = Math.min(min,nums[len-1-i]); //1
            if(nums[i]<max) {
                end = i; //1
                System.out.println("end"+end);
            }
            if(nums[len-1-i]>min)begin = len-1-i;//0

        }
        return end-begin+1;
    }

    public static int findUnsortedSubarray(int[] nums) {

        int len = nums.length;
        if(len<2)return 0;
        int i=0,j=len-1;
        //[2, 6, 4, 8, 10, 9, 15]
        for(;i<len-1;i++){
            if(nums[i]>nums[i+1])break;

        }

        //1~5
        for(;j>i;j--){
            if(nums[j]<nums[j-1]){
                System.out.println(j);
                return j-i+1;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums={1,3,2,2,2};
        int[] nums2= {2, 6, 4, 8, 10, 9, 15};
        int[] nums3={2,1};
        System.out.println(findUnsortedSubarray2(nums3));
        System.out.println(fid(nums2));
        System.out.println(findUnsortedSubarray2(nums2));
        System.out.println(findUnsortedSubarray(nums));
    }
}
