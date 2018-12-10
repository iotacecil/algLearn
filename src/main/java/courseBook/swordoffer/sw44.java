package courseBook.swordoffer;

import java.util.Arrays;

public class sw44 {
    public boolean isContinuous(int[] cards){
        if(cards == null || cards.length <1)return false;
        Arrays.sort(cards);
        int zerocnt = 0;
        for(int card :cards){
            if(card == 0)zerocnt ++;
        }
        int interval = 0;
        for (int i = 1; i <cards.length ; i++) {
            if(cards[i-1] == 0 ||cards[i-1] ==0)continue;
            if(cards[i] == cards[i-1])return false;
            interval += cards[i] - cards[i-1] - 1;

            if(interval > zerocnt)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] cards = {0,3,2,6,4};
        sw44 sl = new sw44();
        System.out.println(sl.isContinuous(cards));
    }
}
