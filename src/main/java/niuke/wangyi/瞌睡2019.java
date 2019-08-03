package niuke.wangyi;

import java.util.Scanner;

//你可以叫醒他一次
public class 瞌睡2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(a));
        int sum = 0;
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            if (t[i] == 1) {
                sum += a[i];
                presum[i + 1] = presum[i];
            }
            if (t[i] == 0) {
                presum[i + 1] = presum[i] + a[i];
            }
        }


        int max = 0;
        for (int i = k; i <= n; i++) {
            max = Math.max(max, sum + presum[i] - presum[i - k]);

        }

//        for (int i = 0; i <n ; i++) {
//
//            if(t[i]==0){
//                int tmp  =0;
//                for (int j = i; j <Math.min(n,i+k) ; j++) {
//                    if(t[j]==0){
//                        tmp+=a[j];
////                        System.out.println(j+ " "+ a[i]);
//                    }
//
//                }
////                System.out.println(tmp);
//                max = Math.max(tmp,max);
//            }

//        }
        System.out.println(max);


    }
}
