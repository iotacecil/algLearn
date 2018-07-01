package leetcode;

import org.apache.commons.net.telnet.EchoOptionHandler;

import java.io.ByteArrayOutputStream;
import java.security.Provider;
import java.security.Security;

public class lc486 {
    public static boolean PredictTheWinner(int[] nums) {
        int asum=0;
        int bsum=0;
        int flag=0;
        int len = nums.length;
        int i =0;
        int end = len-1-i;

        while(end>i){
            int tmpadd=0;
            System.out.println(i+" "+end);
            if(nums[i]>nums[end]){

                tmpadd=i;
                i++;
            }
            else{

                tmpadd=end;
                end--;

            }
            System.out.println("tempadd"+tmpadd);
            if(flag==0){
                asum+=nums[tmpadd];
                flag=1;
            }else
            if(flag==1){
                bsum+=nums[tmpadd];
                flag=0;
            }
            System.out.println(asum+" "+bsum);
        }
        return asum>bsum;
    }
    public static void main(String[] args) {
        int[] nums ={1,5,233,7};
        System.out.println(PredictTheWinner(nums));
//        ByteArrayOutputStream
    }

}
