package courseBook.dsLearn.basic;

import java.util.*;

public class SuffixArray {
    private final String[] suffixes;
    private final int N;
    public SuffixArray(String s){
        N = s.length();
        suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i);
        }
        Arrays.sort(suffixes);
    }
    public String select(int i){return suffixes[i];}
    //select(i)的索引
    public int index(int i){
        return N-suffixes[i].length();
    }
    //select(i) 和 select(i-1)的最长c前缀
    public int lcp(int i){
        return lcp(suffixes[i],suffixes[i-1]);
    }
    private static int lcp(String s,String t){
        int n  = Math.min(s.length(), t.length());
        for (int i = 0; i <n ; i++) {
            if(s.charAt(i) != t.charAt(i))return i;
        }
        return n;
    }
    //小于key的后缀数量
    public int rank(String key){
        int lo = -1,hi = N;
        while (lo+1<hi){
            int mid = lo+(hi-lo)/2;
            int cmp = key.compareTo(suffixes[mid]);
            if(cmp<0)hi = mid;
            else  if(cmp>0) lo = mid;
            else return mid;
        }
        return hi;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> rst = new HashSet<>();
        List<String> res = new ArrayList<>();
        SuffixArray sa = new SuffixArray(s);
        System.out.println(Arrays.toString(sa.suffixes));
        int n = sa.N;
//        String lrs = "";
        for (int i = 1; i <n ; i++) {
            int len = sa.lcp(i);
            System.out.println(i+" "+len);

            if(len==10){
                System.out.println(i);
                rst.add(sa.select(i).substring(0,len ));
                res.add(sa.select(i).substring(0,len ));
            }
        }
        System.out.println(rst);
        return new ArrayList<>(rst);


    }
    public static void main(String[] args) {
//        SuffixArray sa = new SuffixArray("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
//        int n = sa.N;
//        String lrs = "";
//        for (int i = 1; i <n ; i++) {
//            int len = sa.lcp(i);
//            if(len>lrs.length()){
//                lrs = sa.select(i).substring(0,len );
//            }
//        }
//        System.out.println(lrs);
        SuffixArray sb = new SuffixArray("GAGAGAGAGAGAG");
        System.out.println(sb.findRepeatedDnaSequences("GAGAGAGAGAGAG"));
    }
}
