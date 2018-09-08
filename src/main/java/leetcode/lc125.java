package leetcode;


public class lc125 {
    public static boolean ppp(String s) {
        if(s==null||s.length()<2)return true;
        int len = s.length();
        s=s.toLowerCase();
        int end = len-1;
        int i=0;
//        Character.isLetterOrDigit()
        while(i<end){
            while(end>i&&(s.charAt(i)<'a'||s.charAt(i)>'z'||s.charAt(i)<'0'||s.charAt(i)>'9')){
                System.out.println(s.charAt(i));
                i++;
            }
            while(end>i&&(s.charAt(end)<'a'||s.charAt(end)>'z'||s.charAt(i)<'0'||s.charAt(i)>'9')){
                end--;
            }
            if(s.charAt(i)!=s.charAt(end))return false;
            end--;
            i++;
        }
        return true;

    }
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        if (s == null || s.length() < 2) return true;
        int len = s.length();
        int end = len - 1;
//        while(left<right &&Character.isLetterOrDigit(s))
        for (int i = 0; i < len && end >= i; i++) {


            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'z') {
                System.out.println(s.charAt(i)+" "+s.charAt(end));

                i++;
            }
            if (s.charAt(end) >= 'A' && s.charAt(end) <= 'z') {
                end--;
            }

            if (s.charAt(i) != s.charAt(end)) {
                return false;
            }
            end--;

        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        String s = "A man, a plan, a canal: Panama";
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(actual);
        System.out.println(ppp("0P"));
        char a=' ';
        int end = s.length()-1;
        int i =0;
        System.out.println("对嘛"+(end>i&&s.charAt(i)<'a'||s.charAt(i)>'z'||s.charAt(i)<'0'||s.charAt(i)>'9'));
        System.out.println((int)'0');
        System.out.println((int)'9');
        System.out.println(a >= 'A' && a <= 'z');
        System.out.println((int)'z');
        System.out.println((int)'a');
        System.out.println('a'>'z');

        System.out.println((char)0);
    }
}
