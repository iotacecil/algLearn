package gfg;

public class cutrod {
    public static void main(String[] args) {
        int[] price = {1, 5, 8};
        cutrod sl = new cutrod();
        sl.cutRod(price,price.length);
        System.out.println(sl.dpcutRod(price, price.length));
    }
    private int cutRod(int[] price,int n){
        if(n<=0)return 0;
        int maxv=-1;
        for (int i = 0; i <n; i++) {
            //i=0~7 n-1-i+i
            maxv = Math.max(maxv,price[i]+cutRod(price,n-1-i ));
        }
        return maxv;
    }
    private int dpcutRod(int[] price,int n){
        int[] val= new int[n+1];
        val[0]=0;

        //i=[1,n] j = [0,i)->[0,n-1]
        for (int i = 1; i <=n; i++) {
            int maxv = -1;
            for (int j = 0; j <i ; j++) {
                maxv=Math.max(maxv,price[j]+val[i-1-j] );
            }
            val[i]=maxv;
        }
        return val[n];
    }
}
