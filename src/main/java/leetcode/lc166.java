package leetcode;

import java.util.HashMap;

public class lc166 {
    public String fractionToDecimal(int a, int b) {
        if(a%b == 0) return ""+a/b;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> set = new HashMap<>();
        while(a>b){
            sb.append(a/b);
            a %=b;
        }

        System.out.println(a);
        if(sb.length()<1){
            sb.append("0");
        }
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
        }
        Integer idx = set.get(a);

        sb.insert(idx,"(");
        sb.append(")");


        return sb.toString();

    }
}
