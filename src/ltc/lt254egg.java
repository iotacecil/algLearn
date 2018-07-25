package ltc;

public class lt254egg {
    public int dropEggs(int n) {
        if(n==1||n==2)return n;
        int res =0;
        for (int i = 1;  ; ++i) {
            res+=(long)i;
            if(res>=(long)n)
                return i;
        }
//        for (int i = 0; i <=n ; i++) {
//            res = (int)((i+1)*i/2)+1;
//            if(res>=n)return i;
//
//        }return res;
    }

    public static void main(String[] args) {
        lt254egg sl = new lt254egg();
        System.out.println(sl.dropEggs(100));
    }
}
