package weiruan;
class point {
    double x;
    double y;

    public point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
public class wr279 {
        // 计算AB 和 AC的叉积 边AB和点C的叉积
        double Product(point A, point B,point C){
            return (B.x - A.x)*(C.y-A.y)-(C.x-A.x)*(B.y-A.y);
        }
        boolean isIn(point A,point B,point C,point D){
            if(Product(A, B, D) >= 0 && Product(B, C, D) >=0 && Product(C,A,D) >=0){
                return true;
            }
            return false;
        }

    public static void main(String[] args) {
        wr279 sl = new wr279();
        System.out.println(sl.isIn(new point(0, 0), new point(2, 0), new point(2, 2), new point(1, 1)));
    }
}
