package leetcode;

public class lc754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int cnt = 1;
        while (target > sum || (target - sum) % 2 != 0) {
            sum += cnt;
            cnt++;
            System.out.println(cnt + " " + sum);

        }
        return cnt - 1;
    }

    public static void main(String[] args) {
        lc754 sl = new lc754();
        System.out.println(sl.reachNumber(12));
    }
}
