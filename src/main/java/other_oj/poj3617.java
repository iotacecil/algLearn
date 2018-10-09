package other_oj;

import java.util.Scanner;
//ac3848K	1766MS
public class poj3617 {
    /**
     * 不断取Min(S头/尾)放到T末尾
     * 相等：判断下一个字符希望先用到小的字符
     * 可以的操作：
     * 从S头删除一个加到T尾
     * 从S尾删除一个加到T尾
     *
     * @param S ACDBCB
     * @return 构造字典序尽可能小的字符串T ABCBCD
     */
    public static String BestCowLine(String S){
        int a = 0,b = S.length()-1;
        StringBuilder sb = new StringBuilder();
        while (a<=b){
            //关键
            boolean left = false;
            //a+i<b关键
            for (int i = 0; a+i <= b ; i++) {
                if(S.charAt(a+i)<S.charAt(b-i)){
                    left = true;
                    break;
                }else if(S.charAt(a+i)>S.charAt(b-i)){
                    left = false;
                    break;
                }
            }
            if(left)sb.append(S.charAt(a++));
            else sb.append(S.charAt(b--));

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(sc.next());

        }
        //一行80个字符
        String s = BestCowLine(sb.toString());
//        s= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String S = sc.next();
        int len = 80;
        for (int i = 0; i <s.length() ; i+=len) {

            System.out.println(s.substring(i, i + Math.min(len, s.length() - i)));
        }



    }
}
