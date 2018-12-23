package hiho;

import org.junit.jupiter.api.Test;

import java.util.*;

/*

https://hihocoder.com/problemset/problem/1892
每次小Ho可以对S进行以下操作：

选定S中的一个字符Si，将Si移动到字符串首位。
计算最少需要几次移动操作，可以使S变成T。
 */



public class hiho8601 {
    public static int trans3(String s,String t){
        if(s.length() != t.length())return -1;
        int n = s.length();
        int[] scnt  = new int[256];
        int[] tcnt  = new int[256];
        for (int i = 0; i <n ; i++) {
            scnt[s.charAt(i)]++;
            tcnt[t.charAt(i)]++;
        }
        for (int i = 0; i <256 ; i++) {
            if(scnt[i]!=tcnt[i])return -1;
        }
        int tidx = n-1;
        int ans = 0;
        for (int i = n-1; i >=0 ; i--) {
            if(s.charAt(i) == t.charAt(tidx)){
                ans++;
                tidx--;
            }
        }
        return n-ans;

    }
    public static int chgStr(String S, String T){

        int subseq = 0;
        int[] rest_S = new int[26];
        int[] rest_T = new int[26];

        int s_len = S.length();
        int t_len = T.length();

        if(s_len != t_len) return -1;

        for(int i = 0; i<s_len; i++){
            rest_S[S.charAt(i) -'A'] += 1;
        }
        for(int i = 0; i<t_len; i++){
            rest_T[T.charAt(i) -'A'] += 1;
        }

        for(int i = 0,j = 0; i<s_len ; i++){
            if(j!=0)j = i+1;
            while(j<t_len && S.charAt(i) != T.charAt(j) ){
                j++;
            }
            if(j<t_len && S.charAt(i) == T.charAt(j)){
                subseq++;
                rest_S[S.charAt(i) -'A'] -= 1;
                rest_T[S.charAt(i) -'A'] -= 1;
            }
        }
        for(int i = 0; i<26; i++){
            if(rest_S[i] != rest_T[i]) return -1;
        }

        return s_len-subseq;
    }

    public static  int trans2(String s,String t){
        if(s.length() != t.length())return -1;
        int n = s.length();
        int[] scnt  = new int[256];
        int[] tcnt  = new int[256];
        Map<Character,Integer> map = new HashMap<>(n);
        for (int i = 0; i <n ; i++) {
            scnt[s.charAt(i)]++;
            tcnt[t.charAt(i)]++;
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), i);
        }

        for (int i = 0; i <256 ; i++) {
            if(scnt[i]!=tcnt[i])return -1;
        }
        int startidx = 0;
        for (int i = 0; i < n-1; i++) {
                int first = map.get(t.charAt(i));
                int next = map.get(t.charAt(i+1));
                if(next < first)startidx = i+1;


        }
        return n - startidx;

    }
    //TLE
    public static int trans(String s,String t){
        Queue<String> states = new LinkedList<>();
        Set<String> markd = new HashSet<>();
        states.add(s);
        markd.add(s);
        int step = 0;
        while (!states.isEmpty())
        {
            int size = states.size();

            while (size-- >0){
                String cur = states.poll();
                for (int i = 1; i <cur.length() ; i++) {
                    String trans = cur.charAt(i) + cur.substring(0,i) + cur.substring(i+1);
                    if(markd.contains(trans))continue;
                    if(trans.equals(t))return step+1;
                    states.add(trans);
                    markd.add(trans);
                }

            }
            step++;
        }
        return -1;
    }

    @Test
    public void testrest() {
//        char[] ch = new char[26];
//        for (int i = 0; i <26 ; i++) {
//            char tmp = (char) ('A' + i);
//            ch[i] = tmp;
//        }
//        Random rd = new Random();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i <10 ; i++) {
//            sb.append(ch[rd.nextInt(26)]);
//
//        }
        String s = "ABCD";
        String t = "DBAC";

        System.out.println(trans3(s, t));
        System.out.println(chgStr(s, t));

    }

    @Test
    public void test(){
        String s = "ABCD";

        String t = "DBAC";
        int idx = 3;
        String trans = s.charAt(idx) + s.substring(0,idx) + s.substring(idx+1);
        System.out.println(trans);
    }
    public  static int dfs(String s,String t,int d,int idx){
        if(s.equals(t))return d;
        for (int i = idx; i <s.length() ; i++) {
            String trans = s.charAt(idx) + s.substring(0,idx) + s.substring(idx+1);
            if(trans.equals(t))return d+1;

        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();


            System.out.println(trans3(s, t));
            System.out.println(chgStr(s, t));

    }

}
