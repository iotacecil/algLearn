package niuke.wangyi;

public class 和为k的组合数 {
    public static void main(String[] args) {
        int k = 10;
        int cnt = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                int l = k - i - j;
                if (l >= j && i + j < k) {
                    cnt++;
                    System.out.println(i + " " + j + " " + l);
                }


            }

        }
        System.out.println(cnt);
    }

}
