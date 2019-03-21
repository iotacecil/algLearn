package niuke.huawei;

import java.util.Scanner;

public class convert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hex = sc.next();
        int[] hexs = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        hex = hex.toLowerCase();
        int rst = 0;
        for(int i = 2;i<hex.length();i++){
            rst*=10;
            if(hex.charAt(i)>='a'&&hex.charAt(i)<='f')
            rst += (hex.charAt(i)-'a'+10);
            else if(hex.charAt(i)>='0'&&hex.charAt(i)<='9')
                rst += (hex.charAt(i)-'0');
        }
        System.out.println(rst);
    }
}
