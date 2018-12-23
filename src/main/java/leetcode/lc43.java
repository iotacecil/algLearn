package leetcode;

import java.util.Arrays;

public class lc43 {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes,(a,b) -> a[0]-b[0]!=0?a[0] - b[0]:a[1]-b[1]);
        int[] small = envelopes[0];
        int cnt  =0;
        if(envelopes.length < 2)return envelopes.length;
        for(int i =1;i<envelopes.length;i++){
            if(envelopes[i][0] - small[0] >0 && envelopes[i][1] - small[1] >0 ){
                small = envelopes[i];
                cnt++;
            }
        }
        return cnt;
    }
    public String multiply(String num1, String num2) {
        long n = num1.length();
        long m = num2.length();
        if(m > n){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        // s1长
        long allmulti = 0;
        long carry = 0;

        for(int i = num2.length()-1;i>=0;i--){
            long left = num2.charAt(i) - '0';
            long onemulti = 0;
            carry = 0;
            for(int j = num1.length() - 1 ; j>=0 ;j--){
                long right = num1.charAt(j) - '0';
                long multi = left * right +carry;
                carry =  multi /10;
                multi = (long) ((multi %10) * Math.pow(10,(num1.length()-1 - j)));
                onemulti +=  multi;
            }
            if(carry >0){
                onemulti += (long) (carry * Math.pow(10,(num1.length())));
            }
                            System.out.println(onemulti);

            allmulti += onemulti* Math.pow(10,(num2.length()-1 - i));
        }

        return Long.toString(allmulti);

    }


    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "999";
        lc43 sl = new lc43();
        System.out.println(sl.multiply(num1,num2));
    }
}
