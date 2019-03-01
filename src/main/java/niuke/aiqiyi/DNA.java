package niuke.aiqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DNA {


    public static void main(String[] args) {
      String[] s = {"A","C","G","T"};
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int level = 1;
        List<String> tmp = Arrays.asList(s);
        GO:
        while (tmp.size()>0) {
            for (String p :tmp) {
                if (!str.contains(p))
                    break GO;
            }

            List<String> ttmp =new ArrayList<>();
            for (String t:tmp) {
                for (int j = 0; j <s.length ; j++) {
                    ttmp.add(t + s[j]);
                }
            }
            System.out.println(ttmp);
            tmp = ttmp;
            level++;
        }
        System.out.println(level);


    }
}
