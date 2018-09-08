package leetcode;

public class lc168 {
    public static String convertToTitle(int n) {

//            StringBuilder sb = new StringBuilder();
//            while(n>0){
//                n--;
//                sb.append((char)('A'+n%26));
//                n/=26;
//            }
//            return sb.toString();
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));



    }

    public static void main(String[] args) {
        int n =11;

        System.out.println(convertToTitle(n));

    }
}
