package leetcode;

import java.util.*;

//paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
//        banned = ["hit"]
//        Output: "ball"
public class lc819 {
    public String mostcmm(String p,String[] banned){
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> cnt = new HashMap<>();
        String[] split = p.toLowerCase().split("\\PL+");
        for(String s:split)if(!ban.contains(s))cnt.put(s,cnt.getOrDefault(s,0 )+1);
        return Collections.max(cnt.entrySet(),Map.Entry.comparingByValue()).getKey();
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph+=".";
        System.out.println(paragraph.replaceAll("[^a-zA-Z ]", ""));
        Set<String> banset  = new HashSet<>();
        System.out.println(Character.getType(paragraph.charAt(3)));
        System.out.println(Arrays.toString(paragraph.split("\\PL+")));
        System.out.println(paragraph.replaceAll("\\pP",""));
        for(String word:banned)banset.add(word);
        Map<String,Integer> count = new HashMap<>();

        String s = paragraph.toLowerCase();
        int freq = 0;
        String ans="";
        StringBuilder sb = new StringBuilder();
        for(char c:paragraph.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }else if(sb.length()>0){
                String finalword = sb.toString();
                if(!banset.contains(finalword)){
                    count.put(finalword,count.getOrDefault(finalword,0)+1);
                    if(count.get(finalword)>freq){
                        ans=finalword;
                        freq = count.get(finalword);
                    }
                }
                sb= new StringBuilder();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        lc819 sl = new lc819();
        sl.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
    }
}
