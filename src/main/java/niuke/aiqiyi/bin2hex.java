package niuke.aiqiyi;

public class bin2hex {
    String b2h(String bins){
        int n = bins.length();
        String hexs = "0123456789abcdf";
        StringBuilder sb = new StringBuilder();
        //0101 n =4
        while (n>=4){
            int idx = (bins.charAt(n - 1) - '0') +
                    ((bins.charAt(n - 2) - '0') * 2) +
                    ((bins.charAt(n - 3) - '0') * 4) +
                    ((bins.charAt(n - 4) - '0') * 8);
            System.out.println(n);
            sb.append(hexs.charAt(idx));
            n-=4;
        }
        int last = 0;int cnt = 0;
        while (n>0){
            last += (bins.charAt(n-- - 1) - '0')*(1<<(cnt++));
        }
        sb.append(hexs.charAt(last));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        bin2hex sl = new bin2hex();
        System.out.println(sl.b2h("0101010101"));
        System.out.println(Integer.toHexString(Integer.valueOf("0101010101",2)));
    }
}
