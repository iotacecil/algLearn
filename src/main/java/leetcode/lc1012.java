package leetcode;

public class lc1012 {
    public int bitwiseComplement(int N) {
        int rst = 0;
        //1010 // 1 + 2 //1<<2 = 4
        for (int i = 0; i < 32; i++) {
            rst+=(((N)&1)==0)?(1<<i):0;
//            System.out.println(((N>>>i)&1) +" " +(N>>>i));
//            rst<<=1;
            N>>>=1;
            if(N==0)break;

        }
//        // 010   101 101
//        for(int i =0;i<32;i++){
//            if((N&(N-1))!=0){
//
//                rst+=((N>>i)&1)==0?1:0;
//                rst<<=1;
//                N>>>=1;
//            }else break;
//
//        }
        return rst;
    }

    public static void main(String[] args) {
        lc1012 sl = new lc1012();
        System.out.println(sl.bitwiseComplement(7));
        System.out.println(sl.bitwiseComplement(5));
        System.out.println(sl.bitwiseComplement(10));
    }

}
