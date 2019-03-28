package niuke.nnoip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfect_Number {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        while (n-->0){
            int sum = 0;
            List<Integer> rst = new ArrayList<>();
            for (int i = 1; i <=n/2 ; i++) {
                if(n%i==0){
                    sum+=(i);
                    rst.add(i);
                }
            }
            if(sum == n) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <rst.size(); i++) {
                    sb.append(rst.get(i));
                    if(i!= rst.size()-1){
                        sb.append(" + ");
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}
