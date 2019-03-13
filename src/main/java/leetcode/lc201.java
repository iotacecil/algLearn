package leetcode;

public class lc201 {

    public int rangeBitwiseAnd(int m, int n) {
        while(m<n) n = n & (n-1);
        return n;
    }
    public static void main(String[] args) {
        lc201 sl = new lc201();
        System.out.println(Integer.valueOf("11100", 2));
        System.out.println(sl.rangeBitwiseAnd(0b11101, 0b11110));
    }
}
