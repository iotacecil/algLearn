package niuke.wangyi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class xiachufhang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> cailiao = new HashSet<>();
        while (sc.hasNext()){
            String line = sc.next();
            String[] cailiaos = line.split(" ");
            cailiao.addAll(Arrays.asList(cailiaos));
        }
        System.out.println(cailiao.size());
    }
}
