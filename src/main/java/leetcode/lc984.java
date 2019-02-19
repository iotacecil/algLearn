package leetcode;

public class lc984 {
    public String strWithout3a3b(int A, int B) {
        char[] ans = new char[A+B];
        int idx = 0;
        char a = 'a';
        char b = 'b';
        int acnt = 0;
        int bcnt = 0;
        while(A >0 || B >0)
        {
            while(A>0 && B >0 && A==B){
                ans[idx++] = a;
                A--;
                ans[idx++] = b;
                B--;
            }
            while(A>0 && A>B && acnt <2){
                bcnt = 0;
                ans[idx++] = a;
                A--;
                acnt++;
            }
            if(acnt ==2 && B>0){
                ans[idx++] = b;
                B--;
                bcnt++;
                acnt = 0;
            }
            while(B>0 && B>A && bcnt <2){
                acnt = 0;
                ans[idx++] = b;
                B--;
                bcnt++;
            }
            if(bcnt ==2 && A>0){
                ans[idx++] = a;
                A--;
                acnt++;
                bcnt = 0;
            }

        }
        return new String(ans);
    }

    public static void main(String[] args) {
        lc984 sl = new lc984();
        System.out.println(sl.strWithout3a3b(1, 3));
    }
}
