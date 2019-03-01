package leetcode;

public class lc459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int startlen = (len &1)==1?len/2+1:len/2;
        for(int i =startlen;i<len;i++){
            if(s.substring(0,i).equals(s.substring(len-i,len))){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        String str = "aabaaba";
        lc459 sl = new lc459();
        System.out.println(sl.repeatedSubstringPattern(str));
    }
}
