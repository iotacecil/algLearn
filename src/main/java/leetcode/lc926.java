package leetcode;

public class lc926 {
    public int minFlipsMonoIncr(String S) {
        if(S == null ||S.length() <= 0){
            return 0;
        }
        char[] sChars = S.toCharArray();
        int flipCount = 0;
        int onesCount = 0;

        for (int i = 0; i <sChars.length ; i++) {

            if(sChars[i] == '0') {
                // 遇到第一个0
                if (onesCount == 0) {
                    continue;
                } else {
                    // 第一个1 后面所有0都变成1
                    flipCount++;
                }
            }else {
                // 记录1的数量
                onesCount++;
            }

            // 还不如把所有的 1都变成0
            if(flipCount >onesCount){
                flipCount = onesCount;
            }
            System.out.println(i);
            System.out.println(onesCount);
            System.out.println(flipCount);
            System.out.println();

        }
        return flipCount;
    }

    public static void main(String[] args) {
        String zo = "0101100011";
        lc926 sl =new lc926();
        System.out.println(sl.minFlipsMonoIncr(zo));
    }
}
