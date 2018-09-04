package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc887 {
    //dp
    public int superEggDropDP(int K,int N){
        int[] dp = new int[N+1];
        for (int i = 0; i <=N ; i++) {
            dp[i] = i;
        }
        for (int k = 2;k<=K;k++){
            int[] dp2 = new int[N+1];
            int x = 1;
            for (int n = 1; n <= N ; n++) {
                while (x<=n&&Math.max(dp[x-1],dp2[n-x])>Math.max(dp[x],dp[n-x-1]))x++;
                dp2[n] = 1+Math.max(dp[x-1],dp2[n-x]);
            }
            dp = dp2;
        }
        return dp[N];
    }

    Map<Integer,Integer> memo = new HashMap<>();
    Map<Integer,Integer> memo2 = new HashMap<>();
    public int superEggDrop(int K,int N){
        //1<=k<=100
        if(!memo.containsKey(N*100+K)){
            int ans;
            if(N==0)ans = 0;
            else if(K==1)ans = N;
            else{
                int lo = 1,hi = N;
                while(lo<hi){
                    int mid = (lo+hi)/2;
                    int t1 = superEggDrop(K-1,mid-1);
                    int t2 = superEggDrop(K,N-mid);

                    if(t1<t2)lo = mid+1;
                    else if(t1>t2) hi = mid;
                        //关键
                    else lo=hi=mid;
                }

                ans = 1+Math.min(Math.max(superEggDrop(K-1,lo-1),superEggDrop(K,N-lo)),
                        Math.max(superEggDrop(K-1,hi-1),superEggDrop(K,N-hi)));
            }
            memo.put(N*100+K,ans);
        }
        return memo.get(N*100+K);
    }
    public int superEggDrop2(int K, int N) {
        return dp(K, N);
    }
    public int dp(int K,int N){
        if(!memo2.containsKey(N*100+K)){
            int ans;
            if(N==0)
                ans = 0;
            else if(K==1)
                ans = N;
            else{
                int lo = 1,hi = N;
                //二分查找的写法
                while (lo<hi){
                    int x = (lo+hi)/2;
                    int t1 = dp(K-1,x-1);
                    int t2 = dp(K,N-x);
                    System.out.println(t1+" "+t2);

                    if(t1<t2)lo = x+1;
                    else if(t1>t2) hi = x;
                    else lo=hi=x;
                }
                System.out.println(" lo: "+lo+" hi "+hi);
                ans = 1+Math.min(Math.max(dp(K-1,lo-1),dp(K,N-lo)),
                        Math.max(dp(K-1,hi-1),dp(K,N-hi)));
            }
            memo2.put(N*100+K,ans );
        }
        return memo2.get(N*100+K);
    }

    public static void main(String[] args) {
        lc887 sl = new lc887();
        System.out.println(sl.superEggDrop(2, 10));
        System.out.println(sl.superEggDrop2(2, 10));
    }
}
