package bdstar;

import java.util.Scanner;
//一模一样改成cpp用scanf和printf才能过
//TLE
public class zg1802 {
    public static void main(String[] args) {
        //q<10^5
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        for (int t =1;t<=T;t++){
            //字符串长度
            int n = sc.nextInt();
            int q = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();

            int[][] sum = new int[n+1][26];
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < 26; j++) {
                    if(str.charAt(i)-'A'==j){
                        sum[i+1][j]=sum[i][j]+1;

                    }else sum[i+1][j] = sum[i][j];
                }
            }
            System.out.format("Case #%d:\n",t);

            while (q>0){
                int l = sc.nextInt();
                int r = sc.nextInt();

                int cnt = 0;
                for (int i = 0; i < 26; i++) {
                    if(sum[r][i]-sum[l-1][i]>0){
                        cnt = sum[r][i]-sum[l-1][i];
                        break;
                    }
                }
                System.out.println(cnt);
                q--;
            }
        }
    }
}
