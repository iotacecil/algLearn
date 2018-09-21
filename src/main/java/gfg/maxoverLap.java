package gfg;

import java.util.Arrays;
import java.util.stream.Stream;

public class maxoverLap {
    private static int findMax(int[] arr){
        int max = arr[0];
        for(int i:arr){
            max = Math.max(max,i );
        }
        return max;
    }
    private static int findMin(int[] arr){
        int min = arr[0];
        for(int i:arr){
            min = Math.min(min,i);
        }
        return min;
    }

    /*
   1        Arrival                  1
   2        Arrival                  2
   4        Exit                     1
   5        Arrival                  2
   5        Arrival                  3    // Max Guests
   5        Exit                     2
   9        Exit                     1
   10       Arrival                  2
   12       Exit                     1
   12       Exit                     0
     */
//(nLogn).
    private static int maxGuest(int[] arr,int[] ext){
        Arrays.sort(arr);
        Arrays.sort(ext);
        int n = arr.length;
        int guest_in = 1,max_guest = 1,time = arr[0];
        int i =1,j=0;
        while (i<n&&j<n){
            if(arr[i]<=ext[i]){
                guest_in++;
                if(guest_in>max_guest){
                    max_guest = guest_in;
                    time = arr[i];
                }
                i++;
            }else{
                guest_in--;
                j++;
            }
        }
        return max_guest;

    }

    //wa?
    // time complexity becomes O((max-min+1)*n
    private static int maxover(int[] arr,int[] ext){

        int min = findMin(arr);
       int max = findMax(ext);


        int[] count = new int[max-min+1];
        for(int i =0;i<arr.length;i++){
            //进入
            for(int x = arr[i];x<=ext[i];x++){
                //这样没有先进后出
                count[x-min]++;
            }
            System.out.println(Arrays.toString(count));
        }
        int rst = 0;
        int idx = 0;
        for(int i = 0;i<count.length;i++){
            if(rst<count[i]) {
                rst = Math.max(rst, count[i]);

                idx = i;
            }


        }
        return idx+min;
    }

    public static int auxArr(int[] arr, int[] ext){
        int maxa = Arrays.stream(arr).max().getAsInt();
        int maxb = Arrays.stream(ext).max().getAsInt();
        int maxc = Math.max(maxa,maxb );
        int[] x = new int[maxc+2];
        int cur = 0,idx=0;
        for(int i=0;i<arr.length;i++){
            ++x[arr[i]];
            --x[ext[i]+1];
        }
        int maxy = -1;
        for (int i = 0; i <=maxc ; i++) {
            cur+=x[i];
            if(maxy<cur){
                maxy = cur;
                idx = i;
            }

        }
        return maxy;
    }

    /**
     *
     * First guest in array arrives at 1 and leaves at 4,
     second guest arrives at 2 and leaves at 5, and so on.

     Output: 5
     There are maximum 3 guests at time 5.
     * @param args
     */
    public static void main(String[] args) {
        int[] arrl = {1, 2, 9, 5, 5};
        int[] exit = {4, 5, 12, 9, 12};
        int maxover = auxArr(arrl, exit);
        System.out.println(maxover);
    }
}
