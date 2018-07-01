package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class possible {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i =0;i<n;i++){
           nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int dif = nums[1]-nums[0];
        for(int i =1;i<n-1;i++){
            if(nums[i+1]-nums[i]!=dif){
                System.out.println("Impossible");
                break;
            }
           if(i==n-2)
            System.out.println("Possible");

        }

//        System.out.println(Arrays.toString(nums));
    }
}
