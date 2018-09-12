package courseBook;

import sun.misc.PostVMInitHook;

import java.util.Arrays;

/**
 * 区间覆盖问题
 */
public class sf410 {
    /**
     * n个点，固定长度闭区间的长度为k，计算覆盖点集最少的区间数量
     * @param k 固定长度闭区间
     * @param num 点集
     * @return 最少的区间数量
     */
    private static int greddy(int k,int[] num){
        int sum = 1,n = num.length;
        Arrays.sort(num);
        for (int i = 0,tmp = num[0]; i < n; i++) {
            if(num[i]-tmp>k){
                sum++;
                tmp = num[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 7,k=3;
        int[] points ={1,2,3,4,5,-2,6};
        System.out.println(greddy(k, points));
    }
}
