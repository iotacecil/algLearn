package leetcode;

class Solution11 {
    public int lengthOfLastWord(String s) {
        return s.trim().length();
    }
    public int trim(char[] value) {
        int len = value.length;
        int st = 0;
        char[] val = value;    /* avoid getfield opcode */

        while ((st < len) && (val[st] <= ' ')) {
            st++;
        }
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
        }
        return st;
//        return ((st > 0) || (len < value.length)) ? substring(st, len) : value;
    }


}
class lastword{
    public static void main(String[] args) {
        Solution11 s11 =  new Solution11();
        String blank = "";
        System.out.println(blank.length());
        String hell = "  a a  ";
        int len = hell.length();
        int st = 0;
          /* avoid getfield opcode */

        while ((st < len) && (hell.charAt(st) <= ' ')) {
            st++;
        }
        while ((st < len) && (hell.charAt(len-1) <= ' ')) {
            len--;
        }
        System.out.println(hell.substring(st,len));
        System.out.println(st);
        System.out.println(len);


    }
}

