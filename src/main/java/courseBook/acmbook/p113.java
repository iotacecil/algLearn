package courseBook.acmbook;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
//https://code.google.com/codejam/contest/32016/dashboard
//点1和点2 的直线上有多少个整数点
//Correct.
// Correct.
public class p113 {
    public static long product(int n,int[] v1,int[] v2){

        Arrays.sort(v1);
        Arrays.sort(v2);
        long ans = 0;
        for (int i = 0; i < n; i++) {
//            v1升序*v2降序
            ans += (long) v1[i]*v2[n-i-1];
        }
        return ans;

    }
    public static void main(String[] args) throws IOException {

//        FileInputStream in = new FileInputStream("D:\\algLearn\\src\\main\\resources\\A-small-practice.in");
//        System.out.println(System.getProperty("user.dir"));
        FileInputStream in = new FileInputStream(".\\src\\main\\resources\\A-large-practice.in");
        Scanner sc = new Scanner(in);
        BufferedWriter out=new BufferedWriter(new FileWriter(".\\src\\main\\resources\\A2008L.out"));

        int T = sc.nextInt();
        for (int t = 1; t < T+1; t++) {


            int n = sc.nextInt();
            int[] v1 = new int[n];
            int[] v2 = new int[n];
            for (int i = 0; i <n ; i++) {
                v1[i] = sc.nextInt();
            }
            for (int i = 0; i <n ; i++) {
                v2[i] = sc.nextInt();
            }
            out.write("Case #"+t+": "+product(n,v1, v2));
            if(t!= T)out.newLine();

        }



        out.close();
    }
}
