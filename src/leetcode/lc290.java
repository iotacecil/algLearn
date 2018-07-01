//package leetcode;
//
//import com.intellij.codeInsight.template.postfix.templates.SoutPostfixTemplate;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//public class lc290 {
//
//        public static boolean wordPattern(String pattern, String str) {
//            String[] strlist = str.split(" ");
//            int strlen = strlist.length;
//            int patlen = pattern.length();
//            String[] match =new String[strlen+1];
//            Map<String,Character> map = new HashMap<>();
//
//            System.out.println(strlen+" "+patlen);
//            if(patlen!=strlen)return false;
//            for(int i =0;i<patlen;i++){
//
//                String dog = strlist[i];
//                int aba = pattern.charAt(i)-'a';
//                if(map.containsKey(aba)){
//                    //1->dog 2->dog
//                    if(!map.get(aba).equals(dog))
//                        return false;
//                }else{
//                    //1->dog,2->dog/dog->false
//                    if(map.containsValue(dog))return false;
//                    map.put(aba,dog);
//                }
//                if(map.put(dog,i)!=map.put(aba,i)) {
//
//                    map.forEach((k,v)->System.out.println(k+" "+v));
//                    return false;
//                }
//
//            }
//            return true;
//
//        }
//
//    public static void main(String[] args) {
//        boolean b = wordPattern("abba", "dog cat cat fish");
//        System.out.println(b);
//
//    }
//}
