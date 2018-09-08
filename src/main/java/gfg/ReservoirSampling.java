package gfg;

import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {
    public static void main(String[] args) {
        int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = stream.length;
        int k =5;
        selectKItem(stream,n,k);
    }

    private static void selectKItem(int[] stream,int n,int k){
        int i;
        int[] reserve = new int[k];
        for( i=0;i<k;i++){
            reserve[i]=stream[i];
        }
        Random r = new Random();
        //第k+1个元素
        for(;i<n;i++){
            //生成[0-n-1]的随机数[0-i]的随机数->
            int j = r.nextInt(i+1);
            if(j<k)
                reserve[j]=stream[i];
        }
        System.out.println(Arrays.toString(reserve));
    }
}
