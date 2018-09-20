package other_oj;

import java.util.Arrays;
import java.util.Scanner;
//http://acm.hdu.edu.cn/showproblem.php?pid=1848
public class hdu1848 {
    /**
     * 一共有3堆石子，数量分别是m, n, p个；（1<=m,n,p<=1000）
     * 每走一步可以选择任意一堆石子，然后取走f个；
     *  f只能是菲波那契数列中的元素（即每次只能取1，2，3，5，8…等数量）；
     *   最先取光所有石子的人为胜者；
     */
//    static int fib[] = { 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610,
//            987, 1597, 2584, 4181 };
    static int[] f;
    static int sg[];

    static int[] mex;
    int n;
//    Time Limit Exceeded
    private static void getSG(int n){
        sg = new int[n+ 1];
        for (int i = 1; i <=n ; i++) {
            mex = new int[n+1];
            for (int j = 0; f[j]<=i&&j <=n ; j++) {
                mex[sg[i-f[j]]] = 1;
            }

            for(int j =0;;j++)if(mex[j]!=1){
                sg[i] = j;
                break;
            }

        }
        System.out.println(Arrays.toString(sg));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = new int[17];
        f[0]=f[1]=1;
        for (int i = 2; i <=16 ; i++) {
            f[i] = f[i-1]+f[i-2];
        }
        while (sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int p = sc.nextInt();
            if(m==0&&n==0&&p==0)break;
            getSG(1000);
            if((sg[n]^sg[m]^sg[p])!=0) System.out.println("Fibo");
            //后手
            else System.out.println("Nacci");

        }
    }
}
