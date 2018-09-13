//package main.java.dsLearn.polygon;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PolygonSimple {
//
//    public static Builder Builder() {
//        return new Builder();
//    }
//    public static class Builder {
//        private List<Point> _vertexes = new ArrayList<Point>();
//        private List<Line> _sides = new ArrayList<Line>();
//        private BoundingBox _boundingBox = null;
//        private boolean _firstPoint = true;
//        private boolean _isClosed = false;
//        //必须按顺序加入点
//        public Builder addVertex(Point point) {
//            if(_isClosed){
//                //每个顶点都新建一个arr？？
//                _vertexes = new ArrayList<Point>();
//                _isClosed = false;
//            }
////            updateBoundingBox(point);
//            _vertexes.add(point);
//
//
//        }
//    }
//
//    //更新多边形
//    private void
//    private static class BoundingBox {
//        public double xMax = Double.NEGATIVE_INFINITY;
//        public double xMin = Double.NEGATIVE_INFINITY;
//        public double yMax = Double.NEGATIVE_INFINITY;
//        public double yMin = Double.NEGATIVE_INFINITY;
//    }
//}
