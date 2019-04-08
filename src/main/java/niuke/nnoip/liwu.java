package niuke.nnoip;

import java.util.HashMap;
import java.util.Scanner;

public class liwu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sc.next(), 0);
        }
        for (int i = 0; i <n ; i++) {
            String name = sc.next();
            map.put(name, sc.nextInt());
            int num = sc.nextInt();


        }
    }
}
