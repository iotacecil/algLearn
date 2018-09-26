package leetcode;

public class lc43 {
    private int multione(String num1,int x){

        int carry = 0;
        int n = num1.length();
        int sum = 0;
        for(int i = n-1;i>=0;i--){
            int tmp =(num1.charAt(i)-'0')*x+carry;
            carry = tmp%10;
            sum= sum*10+tmp%10;
        }
        System.out.print(sum);
        int rst = 0;
        while(sum!=0){
            int add = sum%10;
            sum/=10;
            rst = rst*10+add;
        }
        return rst;
    }
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int sum = 0;
        for(int i = n2-1;i>=0;i--){
            int tmp = multione(num1,num2.charAt(i)-'0');
            if(i!=n2-1)tmp= tmp*(n2-1-i)*10;
            sum+=tmp;
        }
        return Integer.toString(sum);
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        lc43 sl = new lc43();
        sl.multiply(num1,num2 );
    }
}
