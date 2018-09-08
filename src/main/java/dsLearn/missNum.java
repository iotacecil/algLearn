package dsLearn;

public class missNum {

//    If N = 100k and we have 32-bit integers,
// the computation on then * (n + 1) / 2will overflow,
    public static void main(String[] args) {
        int min = Integer.MIN_VALUE*Integer.MIN_VALUE;
        System.out.println(min);
        System.out.println(min/2);
        System.out.println(Integer.MAX_VALUE*Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE*Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE*Integer.MAX_VALUE);
        int n = 7;
        int[] arr = {1,2,3,4,6,7};
//        sum will hold the correct value of twice the sum, modulo 2^32.
        int sum = n*(n+1);
        for (int i = 0; i <n-1 ; i++) {
            sum-=arr[i]*2;
        }
        System.out.println(sum/2);
    }
}
