package ltc;

public class lt1616 {
    // TLE
    public int smallestLengthII(int[] nums, int k) {
    int n = nums.length;
    int[] sum = new int[n];
    sum[0] = nums[0];
    for(int i = 1; i< n;i++){
        sum[i] = sum[i-1]+nums[i];
    }

    int minlen = n+1;
    for(int i =0;i<n;i++){
        for(int j = i;j<n;j++){
            int sumij = sum[j] - sum[i] + nums[i];
            if(sumij >= k){
                minlen = Math.min(minlen,j-i+1);
            }
        }
    }
    return minlen==n+1?-1:minlen;
}

    public static void main(String[] args) {
        int[] arr = new int[]{2,-1,2};
        int k = 3;
        lt1616 sl = new lt1616();
        System.out.println(sl.smallestLengthII(arr, k));
    }
}
