package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Anagram Substring Search
public class lc438 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3,4,5};

        String s = "cbaebabacd";

        String p= "abc";
        lc438 sl = new lc438();
//        System.out.println(sl.findAnagramsMy(s, p));
        System.out.println(sl.findAnagramsArrEqual("abab", "ab"));
//        List<Integer> result = findAnagrams(s,p);
        //System.out.println(result);


    }
    public List<Integer> findAnagramsArrEqual(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        int[] ch = new int[26];
        int wcn = p.length();
        for(char c:p.toCharArray()){
            ch[c-'a']++;
        }
        int[] window = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            if(i>=wcn){
                --window[s.charAt(i-wcn)-'a'];
            }
            window[s.charAt(i)-'a']++;
            if(Arrays.equals(window, ch)){
                rst.add(i-wcn+1);
            }
        }
        return rst;
    }

//
//    public List<Integer> findAnagramsHashMap(String s, String p) {
//        List<Integer> rst = new ArrayList<>();
//        Map<Character,Integer> map = new HashMap<>();
//        int wcn = p.length();
//        for(char c:p.toCharArray()){
//            map.putIfAbsent(c, map.getOrDefault(c,0 )+1);
//        }
//        for(int i=0;i<=s.length()-wcn;i++) {
//            int j = 0;
//            if(map.containsKey(s.charAt(i))){
//
//            }
//            while (j<wcn){
//
//            }
//        }
//
//    }
    public List<Integer> findAnagramsMy(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        int[] ch = new int[26];
        int wcn = p.length();
        for(char c:p.toCharArray()){
            ch[c-'a']++;
        }
        //s=4, wcn = 2  j =0,1 i+j<4
        for(int i=0;i<=s.length()-wcn;i++){
            int j=0;
            int[] window=ch.clone();
            while(j<wcn){

                if(--window[s.charAt(i+j)-'a']<0){
                    System.out.println(Arrays.toString(window));
                    break;
                }
                j++;


            }
            if(j==wcn){

                rst.add(i);
            }
        }
        return rst;
    }
    //滑动窗口匹配字符串
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();
        if(s.length()<1||p.length()<1||p.length()>s.length())return result;
        int len = p.length();

        int[] cntp = new int[26];
        int[] window = new int[26];
        char[] chars= s.toCharArray();
        for(char c : p.toCharArray()){
            cntp[c-'a']++;
        }
        int start=0,end =len-1;
        char[] sub = s.substring(start,end+1).toCharArray();

        for(char c : sub){
            window[c-'a']++;
        }

        //"cbaebabacd" p: "abc"

        while(end<s.length()){
            //System.out.println(start+" "+end);
            if(Arrays.equals(window,cntp)){
                result.add(start);
                //System.out.println(Arrays.toString(window));
            }
            //start=0 sub = cba window = 111
            char startc = s.charAt(start);

            window[startc-'a']--;

            start++;
            end++;
            if(end<s.length()) {
                // String s = "cbaebabacd";

//            String p= "abc";
                //System.out.println("end=" + end);
                char next = s.charAt(end);
                //System.out.println("最后一个字母" + next);

                window[next - 'a']++;
                //System.out.println(Arrays.toString(window));

            }
        }

        return result;


    }

}
