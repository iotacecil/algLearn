package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class lc914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck==null||deck.length<2)return false;
        int n = deck.length;
        // int maxp = n/2;
        int maxp = n/2;
        Arrays.sort(deck);
        for(int i =2;i<=n;i++){
//            System.out.println(i);
            if(can(deck,i)){

                return true;
            }
        }
        return false;
    }
    private boolean can(int[]deck,int k){
        if(k==1){
            for (int i = 0; i <deck.length-1 ; i++) {
                if(deck[i]!=deck[i+1])return false;
            }
            return true;
        }else {
            if (deck.length % k != 0) return false;
            int i = 0;
            for (; i < deck.length; i += k) {

                for (int j = 0; j < k - 1; j++) {
//                    System.out.println(j);
                    if (deck[i + j] != deck[i + j + 1]) return false;
                }
            }
            return i == deck.length;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,0,0,1};
        lc914 sl = new lc914();
        System.out.println(sl.hasGroupsSizeX(num));
    }
}
