package ltc;

import java.util.HashMap;
import java.util.Map;

public class ltc724 {
    public static void main(String[] args) {
//        int[] arr= {1,5,6,11,21};
        int[] arr= {1,21};
        Map<String, Integer> lookup = new HashMap<>();

        System.out.println("The minimum difference is "
                + minPartition(arr, arr.length - 1, 0, 0, lookup));
        System.out.println(lookup);
        ltc724 sl = new ltc724();
        System.out.println(sl.findMin(arr));
    }

    public int findMin(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum += arr[i];
        }
        int n = arr.length;
        if(n<2)return arr[0];
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i <=sum ; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=sum ; j++) {
                // 不加i
                dp[i][j] = dp[i-1][j];
                // 加i
                if(arr[i-1] <=j){
                    dp[i][j] |= dp[i-1][j - arr[i-1]];
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        int dif = Integer.MAX_VALUE;
        for (int i = sum/2; i >=0 ; i--) {
            if(dp[n][i]){
                dif = sum - 2*i;
                break;
            }
        }
        return dif;
    }
    Map<String,Integer> difmemo;
// 超时
    public int findMindfs(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum += arr[i];
        }
        difmemo = new HashMap<>();
        return dfs(arr, 0, 0, sum);
    }



    private int dfs(int[] arr,int idx,int sum,int target){

        if(idx == arr.length)
            return Math.abs(target  -  2* sum);
        if(difmemo.containsKey(idx+" "+sum))return difmemo.get(idx+" "+sum);
        difmemo.put(idx+" "+sum, Math.min(dfs(arr, idx+1, sum+arr[idx],  target),
                dfs(arr, idx+1, sum,  target))) ;
        return difmemo.get(idx+" "+sum);
    }


// 超时
    public static int minPartition(int[] S, int n, int S1, int S2,
                                   Map<String, Integer> lookup)
    {
        // base case: if list becomes empty, return the absolute
        // difference between two sets
        if (n < 0) {
            return Math.abs(S1 - S2);
        }

        // construct a unique map key from dynamic elements of the input
        // Note that can uniquely identify the subproblem with n & S1 only,
        // as S2 is nothing but S - S1 where S is sum of all elements
        String key = n + "|" + S1;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // Case 1. include current item in the subset S1 and recurse
            // for remaining items (n - 1)
            int inc = minPartition(S, n - 1, S1 + S[n], S2, lookup);

            // Case 2. exclude current item from subset S1 and recurse for
            // remaining items (n - 1)
            int exc = minPartition(S, n - 1, S1, S2 + S[n], lookup);

            lookup.put(key, Integer.min(inc, exc));
        }

        return lookup.get(key);
    }





}
