import java.util.Scanner;
public class mt01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int dx = sc.nextInt();
        int dy = sc.nextInt();
        double dif = Math.sqrt((sx-dx)*(sx-dx)+(sy-dy)*(sy-dy));
//        System.out.printf("%.12f",dif);
        double difzero = Math.sqrt(sx*sx+sy*sy);
//        System.out.println();
//        System.out.println("difzero"+difzero);
        double slop=1;
        double dif2 =0;
        if(sx!=0) {
            slop = sy / sx;
            double absx = Math.sqrt((r * r) / (1 + slop * slop));
            double absy = slop * absx;
//            System.out.println("absX:" + absx + "absY:" + absy);
            double cx = sx > 0 ? -absx : absx;
            double cy = sy > 0 ? -absy : absy;
//            System.out.println("cx:" + cx + "cy:" + cy);
            dif2=r-difzero+Math.sqrt((cx-dx)*(cx-dx)+(cy-dy)*(cy-dy));
        }else{
            double cx = 0;
            double cy = sy>0?-r:r;
            dif2 = r-Math.abs(sy)+Math.sqrt((cx-dx)*(cx-dx)+(cy-dy)*(cy-dy));
        }

//        assert cx*cx+cy*cy==r*r;
//0+


        double out = Math.min(dif,dif2);
        System.out.printf("%.12f",out);



    }
}
