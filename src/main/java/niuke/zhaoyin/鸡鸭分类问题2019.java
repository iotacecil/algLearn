package niuke.zhaoyin;

import java.util.Scanner;

public class 鸡鸭分类问题2019 {
    //CCDDCC->CCDCDC->CCDCCD->CCCDCD->CCCCDD
    //CCDCC->CCCDC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //C在D前
        int ccnt = 0;
        int cbefored = 0;
        int dcnt = 0;
        int dbeforec = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'C') {
                ccnt++;
                dbeforec += dcnt;
            }
            if (str.charAt(i) == 'D') {
                dcnt++;
                cbefored += ccnt;
            }

        }
        System.out.println(Math.min(cbefored, dbeforec));


    }
}
