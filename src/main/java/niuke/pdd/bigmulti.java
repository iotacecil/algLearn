package niuke.pdd;

import java.util.Scanner;

public class bigmulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] num1 = new int[s1.length()];
        int[] num2 = new int[s2.length()];

        for (int i = 0; i <num1.length ; i++) {
            num1[i] = s1.charAt(i)-'0';}
        for (int i = 0; i <num2.length ; i++) {
            num2[i] = s2.charAt(i)-'0';}

        int[] rst = bigNumberMultiply2(num1, num2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <rst.length ; i++) {
            if(i==0&&rst[i]==0)continue;
            sb.append(rst[i]);

        }
        System.out.println(sb.toString());


    }

    public static int[] bigNumberMultiply2(int[] num1, int[] num2){
        // 分配一个空间，用来存储运算的结果，num1长的数 * num2长的数，结果不会超过num1+num2长
        int[] result = new int[num1.length + num2.length];

        // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
        for (int i = 0; i < num1.length; i++){
            for (int j = 0; j < num2.length; j++){
                result[i + j + 1] += num1[i] * num2[j];	 // (因为进位的问题，最终放置到第i+j+1位)
            }
        }

        //单独处理进位
        for(int k = result.length-1; k > 0; k--){
            if(result[k] > 10){
                result[k - 1] += result[k] / 10;
                result[k] %= 10;
            }
        }
        return result;
    }
}
