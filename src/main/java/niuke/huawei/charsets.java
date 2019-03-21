package niuke.huawei;

import java.util.Scanner;

public class charsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            int[] cnt = new int[256];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <str.length() ; i++) {
                char c = str.charAt(i);
                if(cnt[c]==0){
                    sb.append(c);
                }
                cnt[c]++;
            }
            System.out.println(sb.toString());
        }

    }
}
