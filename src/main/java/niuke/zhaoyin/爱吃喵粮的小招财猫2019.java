package niuke.zhaoyin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
6 8 11 3
4
 */
/*
https://www.nowcoder.com/practice/336d00e600f8496287d0d472678da774?tpId=98&tqId=32863&rp=2&ru=%2Fta%2F2019test&qru=%2Fta%2F2019test%2Fquestion-ranking
 */


public class 爱吃喵粮的小招财猫2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(" ");
        int H = Integer.parseInt(bf.readLine());

        int[] h = new int[split.length];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <split.length ; i++) {
            h[i] = Integer.parseInt(split[i]);
            max = Math.max(max, h[i]);
            min = Math.min(min, h[i]);
        }
        for (int i = 1; i <=max ; i++) {
            int cut = 0;
            for(int itm:h){

                if(itm%i==0){
                    cut+= itm/i;
                }else {
                    cut += (itm/i)+1;
                }
            }
            //System.out.println(i+" "+cut);
            if(cut<=H){
                System.out.println(i);
                return;
            }

        }
        System.out.println(-1);


    }
}
