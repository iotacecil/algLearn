package niuke.pdd;

import java.util.Scanner;

public class chenji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = sc.nextInt();

        }
//        String strs = sc.nextLine();
//        String[] numss = strs.split(" ");
//        System.out.println(Arrays.toString(numss));

        if(n == 3){
            System.out.println(nums[0] *
                    nums[1] *
                    nums[2]);

        }else{
            long max1 = Long.MIN_VALUE;
            long max2 = Long.MIN_VALUE;
            long max3 = Long.MIN_VALUE;
            long min1 = Long.MAX_VALUE;
            long min2 = Long.MAX_VALUE;


//            System.out.println(numss.length);
            for (int i = 0; i <n ; i++) {
                Long tmp = nums[i];
//                System.out.println(tmp);
                if(tmp > max1){
                    max3 = max2;max2 = max1;
                    max1 = tmp;
                }else if(tmp > max2){
                    max3 = max2;max2 = tmp;
                }else if(tmp > max3){
                    max3 = tmp;
                }

                if(tmp < min1){
                    min2 = min1;min1 = tmp;
                }else if(tmp < min2){
                    min2 = tmp;
                }
            }
            System.out.println(Math.max(min1*min2*max1, max1*max2*max3));
        }

    }
}
