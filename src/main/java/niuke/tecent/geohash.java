package niuke.tecent;

import java.util.Scanner;

public class geohash {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int wd = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] bound = {-90,90};
        for (int i = 0; i <6 ; i++) {
            int mid = (bound[0]+bound[1])/2;
            if(wd>=mid){
                sb.append(1);
                bound[0] = mid;
            }else {
                sb.append(0);
                bound[1] = mid;
            }
        }
        System.out.println(sb.toString());
    }
}
