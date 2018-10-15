package ltc;

public class lt640 {
    public boolean isOneEditDistance(String s, String t) {
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "bc";
        String vt = "aBc";
        String vs = "ac";
        // i = 1 idx = 2
        //"c.e(c) || i = 1 'c'.e(c)
        int idx = 1;
        System.out.println(s.substring(idx));
        System.out.println(t.substring(idx-1));


        System.out.println(s.substring(idx).equals(t.substring(idx)) ||
                s.substring(idx).equals(t.substring(idx - 1)) ||
                s.substring(idx - 1).equals(t.substring(idx)));
    }
}
