package leetcode;

public class lc43 {

    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] rst = new int[n+m];
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                int mul = (num1.charAt(i)-'0') * (num1.charAt(j)-'0');
                int p1 = i + j; int p2  = i + j + 1;
                int sum = mul + rst[p2];
                rst[p1] += sum / 10;
                rst[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num:rst){
            if(sb.length()==0 && num==0)continue;
            sb.append(num);
        }
        return sb.length() == 0?"0":sb.toString();


    }


    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "999";
        lc43 sl = new lc43();

        System.out.println(sl.multiply(num1,num2));
    }
}
