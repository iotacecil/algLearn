package leetcode;

public class lc984 {
    public String strWithout3a3b(int A, int B) {
        int acnt = 0;
        int bcnt = 0;
        char[] sb = new char[A+B];
        int idx =0;
        char more = 'a' ;
        char less =  'b';
        //StringBuilder sb = new StringBuilder();
        if(A < B){
            int tmp = A;
            A = B;
            B = tmp;

            more = 'b';
            less = 'a';
        }

        int alla = 0;
        int allb = 0;
        while(idx<A+B){
            while ((acnt+1)%3!=0 && alla <A){
                sb[idx++] = more;
                alla++;
                acnt++;

                bcnt =0;
            }
            if ((bcnt+1)%3!=0 && allb <B){
                sb[idx++] = less;
                bcnt++;
                allb++;
                acnt =0;
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        lc984 sl = new lc984();
        System.out.println(sl.strWithout3a3b(4, 4));
    }
}
