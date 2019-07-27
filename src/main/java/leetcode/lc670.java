package leetcode;

public class lc670 {


    public int swap(char[] num, int i, int j) {
        char tmp = num[i];
        num[i] = num[j];

        num[j] = tmp;
        return Integer.parseInt(new String(num));

    }

    public int maximumSwap(int num) {
        //2 7 3 6->7 -1 6 -1
        String str = "" + num;
        int n = str.length();
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[str.charAt(i) - '0'] = i;

        }
        for (int i = 0; i < n; i++) {
            for (int j = 9; j >= 0; j--) {
                // 2 7 3 6
                // 0 1 2 3
                //           0 2 3 1
                if (last[str.charAt(i) - '0'] < last[j]) {
                    return swap(str.toCharArray(), i, j);
                }

            }

        }
        return num;


    }

    public static void main(String[] args) {
        lc670 sl = new lc670();
        System.out.println(sl.maximumSwap(2736));
    }
}
