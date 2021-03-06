package leetcode;

import java.util.*;

//wa
//Input:
//        "GAGAGAGAGAGAG"
//        Output:
//        ["AGAGAGAGAG"]
//        Expected:
//        ["GAGAGAGAGA","AGAGAGAGAG"]
public class lc187 {

    public List<String> findRepeatedDnaSequencesSet(String s) {
        Set<String> rst = new HashSet<>();
        HashSet<String> set = new HashSet<>();
//i=0 i<
        for(int i =0;i<=s.length()-10;i++){
            System.out.println(s.length()+" "+i);
            String sub = s.substring(i,i+10);
            if(set.contains(sub))rst.add(sub);
            else set.add(sub);
        }
        return new ArrayList<>(rst);
    }



    private int lcp(String s1,String s2){
        int cnt = 0;
        for(int i =0;i<(s1.length()<s2.length()?s1.length():s2.length());i++){
            if(s1.charAt(i)==s2.charAt(i))cnt++;
            else {
//                System.out.println(s1+" "+s2);
                break;
            }
        }
        return cnt;

    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rst = new ArrayList<>();
        int N = s.length();
        String[] subffixes = new String[N];
        for (int i = 0; i <N ; i++) {
            //java substring是常数时间
            subffixes[i] = s.substring(i,N);
        }
        Arrays.sort(subffixes);
        System.out.println(Arrays.toString(subffixes));

        for(int i =0;i<N-1;i++){
            int len = lcp(subffixes[i],subffixes[i+1]);
            if(len >= 10){

                rst.add( subffixes[i].substring(0,len ));
            }
//            System.out.println(len);


        }
        return rst;
    }

    public static void main(String[] args) {
//        String str = "GAGAGAGAGAGAG";
        lc187 sl = new lc187();
//        System.out.println(sl.findRepeatedDnaSequences(str));

        System.out.println(sl.findRepeatedDnaSequencesSet( "AAAAAAAAAAAA"));
//        System.out.println(sl.lcp("GAGAGAGAGAG", "GAGAGAGAGAGAG"));
    }
}
