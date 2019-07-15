package niuke.codedance;

import java.util.Arrays;
import java.util.Scanner;

/*

https://www.nowcoder.com/questionTerminal/448127caa21e462f9c9755589a8f2416
1 1 1 1 2 2 3 3 5 6 7 8 9
4 7
 */
public class 雀魂启动2019 {
/*
14张牌中有2张相同数字的牌，称为雀头。
除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。
顺子的意思是递增的连续3个数字牌（例如234,567等），
刻子的意思是相同数字的3个数字牌（例如111,777）
 */
public static boolean check(int[] cnt) {

    for (int i = 1; i < 10; i++) {
        if (cnt[i] >= 2) {
            cnt[i] -= 2;
            if (kezi(cnt) || shunzi(cnt)) {
                cnt[i]+=2;
                return true;
            }
            cnt[i] += 2;
        }
    }
    return false;

}
/*
1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
 */
public static boolean kezi(int[] cnt){
    for (int i = 1; i < 10; i++) {
        if (cnt[i]>0 &&cnt[i]!=3) {
            return false;
        }
    }
    return true;
}
public static boolean shunzi(int[] cnt){
//    int[] tmp = new int[3];
//    for (int i = 1; i <10 ; i++) {
//        if(cnt[i]>0){
//            tmp[i%3]+=cnt[i];
//        }
//
//    }
//    System.out.println(Arrays.toString(tmp));
//    return tmp[0]==tmp[1]&&tmp[0]==tmp[2];
    int[] tmp = cnt.clone();
    System.out.println(Arrays.toString(tmp));
    for (int i = 1; i <=7 ; i++) {
        if(tmp[i]>0){
            if (tmp[i+1] < tmp[i] || tmp[i+2]<tmp[i]) {
                return false;
            }
            else{
                tmp[i+1]-=tmp[i];
                tmp[i+2]-=tmp[i];
                tmp[i] = 0;
            }
        }
    }
    for(int num:tmp){
        if(num>0)return false;
    }
    return true;
}
    // 123 123 123 123 88
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[10];
        for (int i = 0; i < 13; i++) {
            int num = sc.nextInt();

            cnt[num]++;
        }


        for (int i = 1; i < 10; i++) {
         //   System.out.println(Arrays.toString(cnt));
            if (cnt[i] < 4) {
               cnt[i]++;
               if(check(cnt)){
                   System.out.print(i+" ");
               }
               cnt[i]--;

            }

        }
    }
}
