package leetcode;

/**
 * Input: secret = "1807", guess = "7810"
 * <p>
 * Output: "1A3B"
 * <p>
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 */
public class lc299 {

    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int n = secret.length();
        //告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
        //有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）
        //[1][2][3]  //[0][1]
        int[] cnt1 = new int[10];
        int[] cnt2 = new int[10];
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                cnt1[secret.charAt(i) - '0']++;
                cnt2[guess.charAt(i) - '0']++;
            }

        }
        for (int i = 0; i < 10; i++) {
            if (cnt1[i] > 0 && cnt2[i] > 0) {
                b += Math.min(cnt1[i], cnt2[i]);
            }
        }
        return "" + a + "A" + b + "B";
    }

    public static void main(String[] args) {
//        String secret = "11";String guess = "10";
        String secret = "1123", guess = "0111";
        lc299 sl = new lc299();
        System.out.println(sl.getHint(secret, guess));

    }

}
