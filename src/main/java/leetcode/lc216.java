package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc216 {
    //2.5% 5ms
    public List<List<Integer>> combinationSum3Bit(int k, int n) {
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i <(1<<9) ; i++) {
            List<Integer> tmp = new ArrayList<>();
            int sum =0;
            for (int j = 1; j <=9 ; j++) {
                if((i&(1<<(j-1)))!=0){
                    sum+=j;
                    tmp.add(j);
                }
            }
            if(sum==n&&tmp.size()==k)rst.add(new ArrayList<>(tmp));
        }
        return rst;

    }
    //1ms
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(rst,new ArrayList<>(),0,1,k,n);
        return rst;
    }
    private void dfs(List<List<Integer>> rst,List<Integer>tmp,int cnt,int idx,int len,int target){
        if(cnt==len){
            if(target==0)rst.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i <=9 ; i++) {
            if(i>target)break;
            tmp.add(i);
            dfs(rst,tmp,cnt+1,i+1,len,target-i);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        lc216 sl = new lc216();
        System.out.println(sl.combinationSum3(3, 7));
    }
}
