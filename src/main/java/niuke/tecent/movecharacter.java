package niuke.tecent;

import java.util.Scanner;

public class movecharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            char[] ch = str.toCharArray();
            int z = -1;
            for (int i = 0; i < str.length() ; i++) {
                char tmp = ch[i];
                if(tmp <='z' && tmp >='a'){
                    ch[i] = ch[++z];
                    ch[z] = tmp;
                }

            }
//            for (int i = 0; i <str.length() ; i++) {
//                if(str.charAt(i) <='z' && str.charAt(i)>='a')
//                System.out.print(str.charAt(i));
//            }
//            for (int i = 0; i <str.length() ; i++) {
//                if(str.charAt(i) <='Z' && str.charAt(i)>='A')
//                    System.out.print(str.charAt(i));
//            }
            System.out.println(ch);
        }
    }
}
