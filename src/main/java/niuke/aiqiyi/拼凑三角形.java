package niuke.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class 拼凑三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] bian = new int[3];
        bian[0]= sc.nextInt();
        bian[1]= sc.nextInt();
        bian[2]= sc.nextInt();
        Arrays.sort(bian);
        // 如果《0 ok 如果>=0 bian2需要变小
        int dif1 = bian[2] - bian[0]-bian[1];
        if(dif1<0){
            System.out.println(bian[0]+bian[1]+bian[2]);
        }else{
            System.out.println(bian[0]+bian[1]+bian[2]-dif1-1);

        }
    }
}
