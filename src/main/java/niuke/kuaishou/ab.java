package niuke.kuaishou;

import java.util.HashMap;
import java.util.Scanner;

public class ab {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a%b == 0) System.out.println(a/b);
        else {
            StringBuilder sb = new StringBuilder();
            HashMap<Integer,Integer> set = new HashMap<>();
            while(a>b){
                sb.append(a/b);
                a %=b;
            }

            if(sb.length()<1)sb.append("0");
            sb.append(".");
            while (!set.containsKey(a*10)) {
                set.put(a,sb.length());
                a *= 10;
                while (a < b) {
                    set.put(a,sb.length());
                    sb.append("0");
                    a *= 10;
                }
                sb.append(a / b);
                a -= (b * (a / b));
            }
            Integer idx = set.get(a);
            System.out.println(a+" " +idx);
            sb.insert(idx,"(");
            sb.append(")");


            System.out.println(sb.toString());
        }
    }
}
