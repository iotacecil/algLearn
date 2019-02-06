package niuke;

public class add2Palindromic {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return s;
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        int n = sb.length();
        int[] p = new int[n];
        int c = -1, R = -1;
        int rR = 0, rc = 0;
        for (int i = 0; i < n; i++) {
            p[i] = R > i ? Math.min(p[2 * c - i], R - i) : 1;
            while (i - p[i] >= 0 && i + p[i] < n && sb.charAt(i + p[i]) == sb.charAt(i - p[i]))
                p[i]++;
            if (R < i + p[i]) {
                R = i + p[i];
                c = i;
            }
            if (R == n - 1) {
                rR = p[i];
                break;
            }
//            if(rR < p[i]){
//                rR = p[i];
//                rc = i;
//            }
        }

        int start = (rc - rR + 1) / 2;
        return s + s.substring(0, start);
    }


    static String addToPalindrome(String A) {

        int n = A.length();
        // 取得翻转串
        // abcdecba
        // abcedabc
        String s = new StringBuilder(A).reverse().toString();
        for (int i = 0; i < n; i++) // Naive查找
            if (A.substring(i, n).equals(s.substring(0, n - i)))//求最长公共子串
                return s.substring(n - i, n);//返回公共集后面剩余字符串
        return "";
    }


    static String addToPalindrome2(String A) {

        int n = A.length();
        // 取得翻转串
        // abcdecba
        // abcedabc
        String s = new StringBuilder(A).reverse().toString();
        int i = 0;
        while (A.charAt(n - 1 - i) == s.charAt(i)) {
            i++;
        }
        if (A.substring(i, n).equals(s.substring(0, n - i)))//求最长公共子串
            return s.substring(n - i, n);//返回公共集后面剩余字符串
        return "";
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String s = "1234abcxyzcba";
        // aab
        // baa
        System.out.println(addToPalindrome(s));
//        String str = sc.next();

    }
}
