package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc91 {
    Map<String,Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        if(s.length()<1)return 1;
       // System.out.println(s);
        if(map.containsKey(s))return map.get(s);
       // System.out.println(s.length());
        if(s.charAt(0)=='0')return 0;
        if(s.length()==1)return 1;
        //取第一位之后的解码方式
        int w = numDecodings(s.substring(1));
        int pre2 = Integer.parseInt(s.substring(0,2));
        if(pre2<=26)
            w+=numDecodings(s.substring(2));
        map.put(s,w);
        return w;

    }
//用index范围表示s的子串
    Map<Integer,Integer> map2 = new HashMap<>();
    public int numDecodings2(String s) {
        return help(s,0,s.length()-1);
    }
private int help(String s,int l,int r) {
    if(l>s.length()-1)return 1;

    if(map2.containsKey(l))return map2.get(l);
    if(s.charAt(l)=='0')return 0;
    if(l>=r)return 1;
    int w = help(s,l+1,r);
    int pre2 = (s.charAt(l)-'0')*10+(s.charAt(l+1)-'0');
    if(pre2<=26){
        w+=help(s,l+2,r);

    }
    map2.put(l,w);
    return w;
}
//方法3 dp

public int numDecodings3(String s) {
        if(s==null|s.length()<1)return 0;
    int n = s.length();

    int[] dp = new int[n+1];
    dp[0]=1;
    dp[1] = s.charAt(0)!='0'?1:0;

    for (int i = 2; i<=n ; i++) {
        if(s.charAt(i-1)=='0')continue;
        else {
            int two = Integer.parseInt(s.substring(i - 2, i));

            dp[i] = (two<=26?dp[i-1]+dp[i-2]:dp[i-1]);
        }
    }
    return dp[n];

}


    public static void main(String[] args) {
        lc91 sl = new lc91();
        System.out.println(sl.numDecodings3("12"));
//        System.out.println(Integer.parseInt("226".substring(1, 3)));
    }
}
