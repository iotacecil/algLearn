package ltc;

public class lt1350 {
    public String convertToTitle2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n!=0){
            --n;
           sb.insert(0,(char)(n%26+'A' ));
           n/=26;
        }
        return sb.toString();

    }
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

    public static void main(String[] args) {
        lt1350 sl = new lt1350();
        System.out.println(sl.convertToTitle2(28));
    }
}
