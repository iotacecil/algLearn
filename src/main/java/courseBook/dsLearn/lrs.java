package courseBook.dsLearn;

import java.util.Arrays;

public class lrs {
    private int lcp(String s1,String s2){
        int cnt = 0;
        for(int i =0;i<(s1.length()<s2.length()?s1.length():s2.length());i++){
            if(s1.charAt(i)==s2.charAt(i))cnt++;
            else {
//                System.out.println(s1+" "+s2);
                break;
            }
        }
        return cnt;

    }
    public String LRS(String s){
        int N = s.length();
        String[] subffixes = new String[N];
        for (int i = 0; i <N ; i++) {
            //java substring是常数时间
            subffixes[i] = s.substring(i,N );
        }
        Arrays.sort(subffixes);
        System.out.println(Arrays.toString(subffixes));
        String lrs = "";

        for(int i =0;i<N-1;i++){
            int len = lcp(subffixes[i],subffixes[i+1]);
//            System.out.println(len);
            if(len>lrs.length())
                lrs = subffixes[i].substring(0,len );

        }
        return lrs;
    }

    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        lrs sl = new lrs();
        System.out.println(sl.LRS(str));
    }
}
