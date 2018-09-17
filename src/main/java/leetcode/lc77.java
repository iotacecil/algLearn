package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class lc77 {
//    74% dp
    public List<List<Integer>> combineDP(int n,int k){
        List<List<Integer>>[][] dp = new ArrayList[n+1][k+1];
        for (int row = 0; row <=n ; row++) {
            dp[row][0] = new ArrayList<>();
            dp[row][0].add(new ArrayList<>() );
        }
        for (int col = 1; col <=k ; col++) {
            for (int row = col; row <=n-k+col ; row++) {
                dp[row][col] = new ArrayList<>();
                if (row - col > 0){
                    dp[row][col].addAll(dp[row - 1][col]);
                }
                Iterator<List<Integer>> iterator = dp[row-1][col-1].iterator();
                while(iterator.hasNext()){
                    List<Integer> tmpList = new ArrayList<>(iterator.next());
                    tmpList.add(row);
                    dp[row][col].add(tmpList);
                }
            }
        }
        return dp[n][k];
    }
    //fast

    public List<List<Integer>> combineFast(int n,int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k>n||k<0)return result;
        if(k==0){
            result.add(new ArrayList<>());
            return result;
        }
        result = combine(n-1,k-1 );
        for(List<Integer> list:result){
            list.add(n);
        }
        result.addAll(combine(n-1,k ));
        return result;
    }

//    math 8% C(n,k)=C(n-1,k-1)+C(n-1,k)
    public List<List<Integer>> combineMath(int n,int k){
        if(k==n||k==0){
            List<Integer> row = new ArrayList<>();
            for (int i = 1; i <=k ; i++) {
                row.add(i);
            }
            return new ArrayList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combineMath(n-1,k-1 );
        result.forEach(e->e.add(n));
        result.addAll(this.combineMath(n-1,k ));
        return result;
    }
    //20% 58ms
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(rst,new ArrayList<Integer>(),1,n,k);
        return rst;
    }
    private void dfs(List<List<Integer>> rst,List<Integer> tmp,int idx,int n,int k){
        if(tmp.size()==k){
            rst.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i <=n ; i++) {
            tmp.add(i);
            dfs(rst,tmp,i+1,n,k);
            tmp.remove(tmp.size()-1);

        }
    }

    public static void main(String[] args) {
        lc77 sl = new lc77();
        System.out.println(sl.combineMath(1, 1));
    }
}
