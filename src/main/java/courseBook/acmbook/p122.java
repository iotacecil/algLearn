package courseBook.acmbook;

import java.math.BigInteger;
import java.util.Arrays;

//carmichael number
//https://zh.wikipedia.org/wiki/%E5%8D%A1%E9%82%81%E5%85%8B%E7%88%BE%E6%95%B8
public class p122 {
    static boolean[] primes = new boolean[65001];//global array for our sieve

    private static void eratosthenes() {//build a sieve of eratosthenes
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        return primes[n];
    }
    public static long mod_pow(long  x,long n,long mod){
        long res = 1;
        while (n>0){
            if((n&1)!=0)
                res = res*x %mod;
            x = x*x%mod;
            n>>=1;

        }
        return res;
    }

    /**是否存在x 1<x<n
     *  x^n === x mod n
     * @param n  
     * @return n是否是carmichael
     */
    public static boolean isCarmichael(int n){
        //如果素数 false
        if (isPrime(n)) {
            return false;
        }
        BigInteger numbi = BigInteger.valueOf(n);
        for (int x = 2; x < n; x++) {
            if(x!=BigInteger.valueOf(x).modPow(numbi,numbi ).intValue())return false;

//            if(mod_pow(x,n-1 ,n )!=1)return false;
        }
        return true;
    }
    public static void main(String[] args) {
        eratosthenes();
        //no
        int n = 17;
        // yes
        int n2 = 561;
        //no
        int n3 = 4;
        System.out.println(isCarmichael(n2));
    }
}
