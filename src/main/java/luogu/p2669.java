package luogu;

import java.util.Scanner;

public class p2669 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jb = 1;
        int top = 1;
        int k = sc.nextInt();
        int sum = 0;
        for (int i = 0; i <k ; i++) {
            sum += jb;
            top--;
            if(top==0){
                jb++;
                top = jb;
            }
        }
        System.out.println(sum);
    }
}
