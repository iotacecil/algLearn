package meituan;

import java.math.BigDecimal;
import java.util.Scanner;

public class ciytmanyou {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        BigDecimal a = in.nextBigDecimal();

        BigDecimal b = in.nextBigDecimal();
        String ss = in.next();
//        System.out.println(a.compareTo(BigDecimal.ZERO)+" "+b+" "+ss.equals("0"));

        if (b.compareTo(BigDecimal.ZERO)==0||ss==null) {System.out.println(-1);



        }else if(a.compareTo(BigDecimal.ZERO)==0&&ss.equals("0")) System.out.println(1);
    else {
//double a = 233;
//    double b = 999;
//    String ss = "333";
//ss="55555055550000";
            int zero = 0;
            for (int i = ss.length() - 1; i >= 0; i--) {
                if (ss.charAt(i) == '0') {

                    zero++;
                } else {
                    break;
                }
            }


            BigDecimal divide = a.divide(b,100000,BigDecimal.ROUND_CEILING);
            StringBuilder s = new StringBuilder(divide.toString());
            for (int i = 0; i < zero; i++) {
                s.append("0");
            }
            String find = s.toString().substring(1);

            int rst = find.indexOf(ss);
            System.out.println(rst);
        }

        //权值是时间
        //经过边多少次

        //n*m->
        //5 5


    }
}
