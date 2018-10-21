package other_oj;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=1495
 */
public class hdu1495 {
    /*
7 4 3
4 1 3
0 0 0

NO
3
     */
    private static long minPorTime(int z,int x,int y){
        int cnt = 0;


        if(z % gcd(x,y) == 0){
            return (z/gcd(x,y ))-1;

        }
        return -1;
    }
    public static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int s = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (s == 0 && n == 0 && m == 0){
                break;
            }
            if((s&1) == 1){
                System.out.println("NO");
            }else{
                int cnt = (int) minPorTime(s, n, m);
                if(cnt == -1){
                    System.out.println("NO");
                }else
                 System.out.println(cnt);
            }
        }

    }

}
