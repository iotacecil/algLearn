package leetcode;

public class lc190 {
    public int reverseBits2(int n) {
        int rst = 0;
        //
        for(int i = 0;i<32;i++){
            rst  += n&(1<<(31-i));
            rst <<= 1;
        }
        return rst;
    }
    public int reverseBits(int n) {
        int rst = 0;
        //1101
        //   1 >>0110
        //1111 | 0110->1110

        for (int i = 0; i < 32; ++i) {
            //最后一位
            int last = (n&1);

            n >>>= 1;
            rst |= last<<(31-i);


        }
        return rst;
    }

    public static void main(String[] args) {
        lc190 sl = new lc190();
//        System.out.println(sl.reverseBits(43261596));
        System.out.println(1>>1);
        System.out.println(sl.reverseBits2(111));
    }
}
