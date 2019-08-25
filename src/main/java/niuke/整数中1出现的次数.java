package niuke;

// 来自编程之美
// 这个做法不对
public class 整数中1出现的次数 {
//10000
// [0,1][9] 10000- 9x9x9x9


    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }


    public static void main(String[] args) {
        整数中1出现的次数 sl = new 整数中1出现的次数();
        System.out.println(sl.NumberOf1Between1AndN_Solution(10000));
    }
}
