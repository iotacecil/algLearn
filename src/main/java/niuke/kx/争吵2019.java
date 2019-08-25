package niuke.kx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 争吵2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int n = str.length();
        int de = 0;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                de++;
            }

        }
        System.out.println(n - de);

    }
}
