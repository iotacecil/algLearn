package courseBook.dsLearn.polygon;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class awtTest {
    public static void main(String[] args) {
        int[] xy = {0,0,0,1,2,1,2,2,1,3,0,2};
        int[] triangle = {0,0,0,1,2,1,2,2,1,3,0,2};
        int len = xy.length;
        int[] x = new int[len/2];
        int[] y = new int[len/2];

        for (int i=0,idx=0; i <len ; i+=2,idx++) {

            x[idx] = xy[i];
            y[idx] = xy[i+1];
        }
//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));

        Polygon a = new Polygon(x,y,x.length);
        System.out.println(a.getBounds2D());
        Point2D point = new Point2D.Double(0,1);
        Line2D line = new Line2D.Double(1,1,2,2);
        System.out.println(line.ptLineDistSq(point));
//        System.out.println(a.contains(point));



    }
}
