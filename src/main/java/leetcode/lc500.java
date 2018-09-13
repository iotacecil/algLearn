package leetcode;

import java.util.*;
import java.util.stream.Stream;

public class lc500 {
    public String[] findWordsStream(String[] words) {

        return Stream.of(words).parallel().filter(s->s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
    public String[] findWordsRE(String[] words) {
        List<String> rst = new ArrayList<>();
        for(String word:words){

//            System.out.println(word.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"));
            if(word.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")){

                rst.add(word);
            }
        }
        return rst.toArray(new String[rst.size()]);

    }
        public String[] findWords(String[] words) {
        Map<Character,Integer> pattern = new HashMap<>();
        for(char letter:"qwertyuiop".toCharArray()){
            pattern.put(letter,1 );
        }
        for(char letter:"asdfghjkl".toCharArray()){
            pattern.put(letter,2 );
        }
        for(char letter:"zxcvbnm".toCharArray()){
            pattern.put(letter,3 );
        }
        List<String> rst = new ArrayList<>();
        for(String word:words){
            word = word.toLowerCase();
            int tmp = pattern.get(word.charAt(0));
            for(int i=1;i<word.length();i++){
                System.out.println(tmp+" "+pattern.get(word.charAt(i)));
                if(pattern.get(word.charAt(i))!=tmp)break;
            }
            System.out.println(word);
            rst.add(word);
        }
        System.out.println(rst);
        return rst.toArray(new String[rst.size()]);
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        lc500 sl = new lc500();
        System.out.println(Arrays.toString(sl.findWordsRE(words)));
    }
}
