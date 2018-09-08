package leetcode;




public class Reverse {
    public int reverse(int x) {
        long out = 0;
        for(;x!=0;x/=10){
            out = out*10+x%10;

        }

        return out>Integer.MAX_VALUE||out<Integer.MIN_VALUE? 0 :(int)out;
    }
    public static void main(String[] args){
        Reverse rever1 = new Reverse();
        //匿名数组
        int input = -120;
        System.out.println(rever1.reverse(input));
    }
}

