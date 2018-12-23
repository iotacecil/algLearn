package hiho;

import java.util.Scanner;

public class hiho1326 {
    public static int minFlipsMonoIncr(String S) {
        int oCnt = 0;
        int fCnt = 0;
        for(int i =0;i<S.length();i++){
            if(S.charAt(i) == '1'){
                oCnt ++;
            }else if(oCnt >0){
                fCnt ++;
            }
            // 关键 fCnt 随前缀更新
            fCnt = oCnt < fCnt ? oCnt:fCnt;
        }
        return fCnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-->0){
            System.out.println(minFlipsMonoIncr(sc.next()));
        }

    }
}
