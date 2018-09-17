package niuke;

/**
 * 改动多少个数字 使左右相等
 * 081 101 dif = 9 return 2
 */
public class luckyID {
    private static int getsum(String str,int s,int end){
        int sum = 0;
        for(int i=s;i<end;i++){
            sum+=str.charAt(i)-'0';
        }
        return sum;
    }
    public static void main(String[] args) {
//        String str = "123420";
                String str = "124133";

        int presum = getsum(str, 0, 3);
        int endsum = getsum(str, 3, 6);
        System.out.println(presum);
        System.out.println(endsum);

//        int presum = 0;
//        int endsum = 0;
//        for (int i = 0; i < ; i++) {
//
//        }
//        int i = Integer.parseInt(str);
//        int pre = i/1000;
//        int end = i%1000;
//        presum=pre%100+(pre/10)%10+(pre/100)%10;
//        System.out.println(pre%100);
//        endsum=end%100+(end/10)%10+(end/100)%10;
        int dif = Math.abs(presum-endsum);

        int sum = 0;
        //最多只能差[0,27]

//        if(dif%10!=0)sum++;
//        if(dif/10!=0)sum++;
//        if(dif/100!=0)sum++;

        System.out.println(dif);
        System.out.println(sum);
    }
}
