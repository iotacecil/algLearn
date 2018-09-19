package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc386 {

    /**
     * //todo
     *  13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
     *  怎么有14
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> rst = new ArrayList<>(n);
        int cur = 1;
        for (int i = 0; i <n ; i++) {
           rst.add(cur);
            if(cur*10<=n)
                cur*=10;
            else{
                if(cur>n){
                    cur = cur/10;
                }
                cur++;
                while (cur%10 == 0)
                    cur = cur/10;
            }

        }
        return rst;
    }
    public List<Integer> lexDfs(int n){
        List<Integer> rst = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(rst,n,i);

        }
        return rst;
    }
    private void dfs(List<Integer> rst,int n,int cur){
        if(cur>n)return;
        else{
            rst.add(cur);
            for (int i = 0; i <10 ; i++) {
                if(cur*10+i>n)return;
                dfs(rst,n,10*cur+i);

            }
        }
    }


    public static void main(String[] args) {
        lc386 sl = new lc386();
        System.out.println(sl.lexDfs(13));
    }
}
