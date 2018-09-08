package dsLearn;

import java.util.Arrays;

public class stringSuffixes {
    public static String[] suffixes(String s){
        int N = s.length();
        String[] subffixes = new String[N];
        for (int i = 0; i <N ; i++) {
            subffixes[i] = s.substring(i,N);
        }
        return subffixes;
    }
    public static int lcp(String s,String t){
        int N = Math.min(s.length(),t.length());
        for (int i = 0; i < N; i++) {
            if(s.charAt(i)!=t.charAt(i)){
                return i;
            }

        }
        return N;
    }
    static int[] count = new int[7];
    static private int[] countt(String s){

        int N = s.length();

        for (int i = 0; i <N ; i++) {
            count[s.charAt(i)-'a'+1]++;
        }
        return count;
    }
    static private int[] acu(){
        for (int i = 0; i < count.length-1; i++) {
            count[i+1]+=count[i];

        }
        return count;
    }
    static private char[] axuu(String s){
      char[] axu = new  char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            axu[count[s.charAt(i)-'a']++] = s.charAt(i);
        }
        return axu;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(suffixes("prefetch")));
        System.out.println(Arrays.toString(countt("dacffbdbfbea")));
        System.out.println(Arrays.toString(acu()));
        String dacffbdbfbea = Arrays.toString(axuu("dacffbdbfbea"));
        System.out.println(dacffbdbfbea);
    }
}
