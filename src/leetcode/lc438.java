package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Anagram Substring Search
public class lc438 {
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
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3,4,5};

        String s = "cbaebabacd";

        String p= "abc";
        List<Integer> result = findAnagrams(s,p);
        //System.out.println(result);


    }
}
