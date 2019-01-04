package niuke.tecent;

import java.util.Scanner;

public class xiaoQ {
    public static boolean can(int mid,int n,int m){
        int sum = 0;
        for (int i = 0; i <n ; i++) {
            sum += mid;
            mid = (mid+1)/2;
            if(mid == 0)return true;
            if(sum > m)return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = 0,hi = m+1;
        while (l < hi){
            int mid = l + (hi - l)/2;
            if(can(mid,n,m)){
                l = mid +1;
            }else
                hi = mid;
//            System.out.println(l+" "+hi);
        }
        System.out.println(l-1);
    }
}
