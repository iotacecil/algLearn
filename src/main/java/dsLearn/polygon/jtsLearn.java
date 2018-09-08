package dsLearn.polygon;

import com.vividsolutions.jts.algorithm.distance.DistanceToPoint;
import com.vividsolutions.jts.awt.PolygonShape;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.operation.distance.DistanceOp;
import com.vividsolutions.jts.operation.overlay.PolygonBuilder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class jtsLearn {
    private static GeometryFactory geometryFactory = new GeometryFactory();

    public static void pointInPolygon(double x,double y,String geometry) throws ParseException {

        Coordinate coord = new Coordinate(x,y);
        Point point = geometryFactory.createPoint( coord );

        WKTReader reader = new WKTReader( geometryFactory );
      Polygon polygon = (Polygon) reader.read(geometry);
        System.out.println(DistanceOp.distance(polygon, point));

        System.out.println(point.intersects(polygon));
        System.out.println(point.within(polygon));
    }
    public static void main(String[] args) throws ParseException {

     pointInPolygon(3,4, "POLYGON((0 0,0 2,2 2,2 0,0 0))" );
     pointInPolygon(3,0 ,"POLYGON((0 0,0 2,2 2,2 0,0 0))" );
     pointInPolygon(0,0 ,"POLYGON((0 0,0 2,2 2,2 0,0 0))" );
    }

//    DistanceOp sl = new DistanceOp()
}
