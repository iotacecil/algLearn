package other_oj;

import java.io.*;
import java.lang.management.MemoryManagerMXBean;
import java.util.Arrays;
import java.util.Scanner;

public class poj2976 {
//http://www.cnblogs.com/perseawe/archive/2012/05/03/01fsgh.html
//    a[i]表示选取i的收益，b[i]表示选取i的代价。
// 如果选取i，定义x[i]=1否则x[i]=0。每一个物品只有选或者不选两种方案，求一个选择方案使得R=sigma(a[i]*x[i])/sigma(b[i]*x[i])取得最值，

//    Dinkelbach算法，他就是基于这样的一个思想，他并不会去二分答案，而是先随便给定一个答案，然后根据更优的解不断移动答案，逼近最优解。由于他对每次判定使用的更加充分，所以它比二分会快上很多。但是，他的弊端就是需要保存这个解，而我们知道，有时候验证一个解和求得一个解的复杂度是不同的

    //有n个考试 第一行得分 第二行总分
    //k 求去掉drop any k of your test scores.
    //求最高分

    /**
     *3 1
     5 0 2
     5 1 6
     4 2
     1 2 7 9
     5 6 7 9
     0 0
     *
     *
     *
     * 83
     100
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), k = sc.nextInt();
            if (n == 0 && k == 0) {
                break;
            }
            double[] a = new double[n];
            double[] b = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextDouble();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextDouble();
            }


        }
    }
//Accepted	938MS
    //考虑 每个考试的贡献度 r = sum(a)/sum(b)  -> 0 = sum(a)-sum(b)*r
    // 求出每个 a[i] - b[i] * r; 然后排序，去除 k 个最小值。
    private static double binarySearch(double[] a,double[] b,int n,int k){
        double min = 0.0,max = 1.0;
        while (Math.abs(max-min)>1e-6){
            double mid = (min+max)/2;
            double[] arr = new double[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=a[i]-mid*b[i];
            }
            Arrays.sort(arr);
            double sum = 0;
            //去掉k个最小
            for (int i = k; i <n ; i++) {
                sum+=arr[i];
            }
//            如果 Q(r) > 0 说明 r 的值偏小，因为可能存在 r 使得 Q(r) = 0；
// * 如果 Q(r) < 0 说明选取的 r 值过大；
            if (sum < 0) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;
    }
}
