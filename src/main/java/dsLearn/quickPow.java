package dsLearn;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class quickPow {
    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance);
    }
    public static int rotateLeft(int i, int distance) {
        return (i << distance) | (i >>> -distance);
    }
    @Test
    void testRotate(){
        Integer integer = Integer.valueOf("1110111101", 2);
        int i = rotateLeft(integer, 1);
        i = rotateRight(integer, 1);
        System.out.println(Integer.toBinaryString(i));
    }
    public String pow(int base,int exponent) {
        if (exponent < 0) {
            throw new ArithmeticException("Negative exponent");
        }
        int signum = base<0?-1:1;
        if (signum == 0) {
            return String.valueOf(exponent == 0 ? 1 : base);
        }

        int partToSquare = Math.abs(base);

        // 二次幂用左移比较快
        // powers of two will be multiplied back at the end.
        int powersOfTwo = numberOfTrailingZeros(partToSquare);
        long bitsToShift = (long)powersOfTwo * exponent;


        int remainingBits;

        // Factor the powers of two out quickly by shifting right, if needed.
//        if (powersOfTwo > 0) {
//            partToSquare = partToSquare.shiftRight(powersOfTwo);
//            remainingBits = partToSquare.bitLength();
//            if (remainingBits == 1) {  // Nothing left but +/- 1?
//                if (signum < 0 && (exponent&1) == 1) {
//                    return NEGATIVE_ONE.shiftLeft(powersOfTwo*exponent);
//                } else {
//                    return ONE.shiftLeft(powersOfTwo*exponent);
//                }
//            }
//        } else {
//            remainingBits = partToSquare.bitLength();
//            if (remainingBits == 1) { // Nothing left but +/- 1?
//                if (signum < 0  && (exponent&1) == 1) {
//                    return NEGATIVE_ONE;
//                } else {
//                    return ONE;
//                }
//            }
//        }
//
//        // This is a quick way to approximate the size of the result,
//        // similar to doing log2[n] * exponent.  This will give an upper bound
//        // of how big the result can be, and which algorithm to use.
//        long scaleFactor = (long)remainingBits * exponent;
//
//        // Use slightly different algorithms for small and large operands.
//        // See if the result will safely fit into a long. (Largest 2^63-1)
//        if (partToSquare.mag.length == 1 && scaleFactor <= 62) {
//            // Small number algorithm.  Everything fits into a long.
//            int newSign = (signum <0  && (exponent&1) == 1 ? -1 : 1);
//            long result = 1;
//            long baseToPow2 = partToSquare.mag[0] & LONG_MASK;
//
//            int workingExponent = exponent;
//
//            // Perform exponentiation using repeated squaring trick
//            while (workingExponent != 0) {
//                if ((workingExponent & 1) == 1) {
//                    result = result * baseToPow2;
//                }
//
//                if ((workingExponent >>>= 1) != 0) {
//                    baseToPow2 = baseToPow2 * baseToPow2;
//                }
//            }
//
//            // Multiply back the powers of two (quickly, by shifting left)
//            if (powersOfTwo > 0) {
//                if (bitsToShift + scaleFactor <= 62) { // Fits in long?
//                    return valueOf((result << bitsToShift) * newSign);
//                } else {
//                    return valueOf(result*newSign).shiftLeft((int) bitsToShift);
//                }
//            }
//            else {
//                return valueOf(result*newSign);
//            }
//        } else {
//            // Large number algorithm.  This is basically identical to
//            // the algorithm above, but calls multiply() and square()
//            // which may use more efficient algorithms for large numbers.
//            BigInteger answer = ONE;
//
//            int workingExponent = exponent;
//            // Perform exponentiation using repeated squaring trick
//            while (workingExponent != 0) {
//                if ((workingExponent & 1) == 1) {
//                    answer = answer.multiply(partToSquare);
//                }
//
//                if ((workingExponent >>>= 1) != 0) {
//                    partToSquare = partToSquare.square();
//                }
//            }
//            // Multiply back the (exponentiated) powers of two (quickly,
//            // by shifting left)
//            if (powersOfTwo > 0) {
//                answer = answer.shiftLeft(powersOfTwo*exponent);
//            }
//
//            if (signum < 0 && (exponent&1) == 1) {
//                return answer.negate();
//            } else {
//                return answer;
//            }
//        }
        return "";
    }
    int pow3(int a,int b){
        int ans = 1,base = a;
        while(b!=0){
            if((b&1)!=0)
                ans*=base;
            base*=base;
            b>>=1;

        }
        return ans;
    }

    static int lowestBitIndex(int num){
        int cnt =0;
        while((num&1)==0){
            num>>=1;
            cnt++;
        }
        return cnt;
    }

    public static int numberOfTrailingZeros(int i) {
        // HD, Figure 5-14
        int y;
        if (i == 0) return 32;
        int n = 31;
        y = i <<16; if (y != 0) { n = n -16; i = y; }
        y = i << 8; if (y != 0) { n = n - 8; i = y; }
        y = i << 4; if (y != 0) { n = n - 4; i = y; }
        y = i << 2; if (y != 0) { n = n - 2; i = y; }
        return n - ((i << 1) >>> 31);
    }

    public static void main(String[] args) {


//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
        BigInteger big = new BigInteger("888");
        System.out.println(big.getLowestSetBit());
        System.out.println(lowestBitIndex(888));
        Integer integer = Integer.valueOf("11111101110000", 2);
        System.out.println(Integer.toBinaryString(888));
        System.out.println(numberOfTrailingZeros(integer));
        long start = System.currentTimeMillis();
        for(int i=777;i<99999999;i++){
            numberOfTrailingZeros(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-start));
        long start2 = System.currentTimeMillis();
        for(int i=777;i<99999999;i++){
            lowestBitIndex(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("用时"+(end2-start2));


//        System.out.println(big);
//
//        quickPow sl = new quickPow();
//        System.out.println(sl.pow3(3,11 ));
    }
}
