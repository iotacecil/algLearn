package leetcode;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class lc753 {
    Set<String> edge;
    StringBuilder ans;

    public String crackSafe(int n, int k) {
        if(n==1&&k ==1)return "0";
        edge = new HashSet<>();
        ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <n-1 ; i++) {
            sb.append("0");
        }
        String start = sb.toString();

        dfs(start,k);
        ans.append(start);
        return new String(ans);
    }
    public void dfs(String node,int  k){
        System.out.println("node:"+node);
        for (int x = 0; x < k; x++) {
            String nei = node+x;
            System.out.println("nei:"+nei);
            if(!edge.contains(nei)){
                edge.add(nei);
                System.out.println(edge);
                dfs(nei.substring(1),k);
                ans.append(x);
            }

        }
    }
    private BigInteger smallestLyndonRotation(BigInteger input, int size) {
        BigInteger lowestForm = input;
        BigInteger mask = BigInteger.ONE;
        for(int i = 1;i<size;i++) {
            BigInteger possibleLowerForm = (input.and(mask).shiftLeft(size-i)).or(input.and(mask.negate()).shiftRight(i));
            mask = mask.or(mask.shiftLeft(1));
            if(possibleLowerForm.compareTo(lowestForm) == -1) {
                lowestForm = possibleLowerForm;
            }
        }
        return lowestForm;
    }

    public static void main(String[] args) {
        lc753 sl = new lc753();
        System.out.println(sl.crackSafe(2, 2));
        System.out.println(sl.smallestLyndonRotation(new BigInteger("6"), 4).toString(2));
    }
}
