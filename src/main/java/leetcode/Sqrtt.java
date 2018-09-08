package leetcode;

public class Sqrtt {
    public static int mySqrt(int x) {
        //牛顿迭代法
        long n = x;
        while(n*n>x){
//            System.out.println("x/n:"+x+n+x/n);
            //8+1/2=4 ;x=8,n=4,4+2/2=3;
            n = (n+x/n)>>1;
//            System.out.println(n);
        }
        return (int)n;
    }

    public static void main(String[] args) {
        int x = 8;
        mySqrt(x);
    }
}
