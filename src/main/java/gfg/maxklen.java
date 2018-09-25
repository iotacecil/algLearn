package gfg;

/**
 * Maximum sum of lengths of non-overlapping subarrays
 * with k as the max element.
 * Input : arr[] = {2, 1, 4, 9, 2, 3, 8, 3, 4}
 k = 4
 Output : 5
 {2, 1, 4} => Length = 3
 {3, 4} => Length = 2
 So, 3 + 2 = 5 is the answer
 */
public class maxklen {
    public int lensum(int[] arr,int k){
        int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n ; i++) {
        int cnt=0;
        int flag = 0;
        while (i<n&&arr[i]<=k){
            cnt++;
            if(arr[i] == k)flag = 1;
            i++;
        }
        if(flag == 1)
            ans+=cnt;
        while (i<n&&arr[i]>k)i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 9, 2, 3, 8, 3, 4};
        int k = 4;
        maxklen sl = new maxklen();
        System.out.println(sl.lensum(arr, k));

    }
}
