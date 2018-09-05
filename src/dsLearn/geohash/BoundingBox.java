package dsLearn.geohash;

public class BoundingBox {

        private double minLat;
        private double maxLat;
        private double minLon;
        private double maxLon;
        public BoundingBox(Point p1, Point p2) {
            this(p1.getLatitude(), p2.getLatitude(), p1.getLongitude(), p2.getLongitude());
        }
        public BoundingBox(double y1, double y2, double x1, double x2) {
            minLon = Math.min(x1, x2);
            maxLon = Math.max(x1, x2);
            minLat = Math.min(y1, y2);
            maxLat = Math.max(y1, y2);
        }

    public Point getUpperLeft() {
        return new Point(maxLat, minLon);
    }
    public Point getLowerRight() {
        return new Point(minLat, maxLon);
    }
    public String toString() {
        return getUpperLeft() + " -> " + getLowerRight();
    }

}
