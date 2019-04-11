package niuke.baidu;

import java.util.Scanner;

public class huijia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] pois = new int[N];
        int sum = 0;
        for (int i = 0; i <N ; i++) {
            pois[i] = sc.nextInt();
            if(i!=0){
                sum += Math.abs(pois[i]-pois[i-1]);
            }
        }
      //  System.out.println(sum);
        int rst = sum;
        for (int i = 1; i <N-1 ; i++) {
            int tmp = sum - (Math.abs(pois[i]-pois[i-1]) + Math.abs(pois[i+1]-pois[i])) + Math.abs(pois[i-1]-pois[i+1]);
            rst = Math.min(rst, tmp);
        }
        System.out.println(rst);
    }
}
