package niuke;

public class quickmul {
    public double Power(double ba, int ex) {
        // ex = 3  2  4 ex = 1
        double rst = 1;
        while(ex >0){
            if((ex&1) != 0){
                rst = rst*ba;
            }
            rst = rst*rst;
            ex>>=1;
        }
        return rst;
    }
    public static void main(String[] args) {

    }
}
