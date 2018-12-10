package leetcode;

public class lc263 {
    public boolean isUgly(int num) {
        while(num >0 && num % 2 ==0){
            num /= 2;
        }
        while(num >0 &&num % 3 ==0){
            num /= 3;
        }


        while(num >0 && num % 5 ==0){
            num /= 5;
        }
        return num ==1;
    }

    public static void main(String[] args) {
        lc263 sl = new lc263();
        System.out.println(sl.isUgly(6));
    }
}
