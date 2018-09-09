package hiho;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hiho1418target_sum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int S = sc.nextInt();
            int[] nums = new int[N];
            for(int i =0;i<N;i++){
                nums[i] = sc.nextInt();
            }

            int ans  = dfs(S,0,nums,new HashMap<>());

            System.out.println(ans%1000000007);
        }
    }
    private static int dfs(int S,int idx,int[] nums,Map<Integer,Integer> map){
        int key = S*10000+idx;

        if(map.containsKey(key)){
            return map.get(key);
        }
        if(idx==nums.length){
            if(S==0)return 1;
            else return 0;
        }

        int cnt=dfs(S+nums[idx],idx+1,nums,map)+dfs(S-nums[idx],idx+1,nums,map);
        map.put(key,cnt);
//        System.out.println(map);
        return cnt;

    }
}