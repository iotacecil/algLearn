package leetcode;

public class lc415 {
    //20% 43ms
    public String addStrings(String num1, String num2) {
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(len1>=0&&len2>=0){
            int n1 = num1.charAt(len1--) - '0';
            int n2 = num2.charAt(len2--) - '0';
            int sumtmp = n1+n2+carry;
            carry = sumtmp/10;
            sb.insert(0, sumtmp%10);
        }
//        System.out.println(sb.toString()+len1+len2);
        while (len1>=0||len2>=0){
            int n1 = (len1<0?num2.charAt(len2--):num1.charAt(len1--)) - '0';
            System.out.println(n1);
            int sumtmp = n1+carry;
            carry = sumtmp/10;
            sb.insert(0, sumtmp%10);
        }
//        System.out.println(sb.toString()+len1+len2);

        if(carry>0){
            sb.insert(0,1 );
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        lc415 sl = new lc415();
        System.out.println(sl.addStrings("9", "99"));
    }
}
