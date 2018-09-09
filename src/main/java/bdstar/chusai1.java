package bdstar;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class chusai1 {


    static String magic(int n,StringBuilder res){

        while(n>0){
            if(n%2==0){
                res.append('2');
                n=(n-2)/2;
            }
            else{
                res.append('1');

                n=(n-1)/2;
            }
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int n = sc.nextInt();
        String magic = magic(n, new StringBuilder());

        System.out.println(magic);

        //0->1->6->10



    }
}
