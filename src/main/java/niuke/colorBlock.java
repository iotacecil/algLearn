package niuke;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class colorBlock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String  s = in.next();
        Set hs = new HashSet();
        for (int i =0;i<s.length();i++){
            hs.add(s.charAt(i));
        }
        if (hs.size()>2||hs.size()==0) {System.out.println(0);}
        else if (hs.size()==2){
            System.out.println(2);

        }
        else System.out.println(1);

    }

}
