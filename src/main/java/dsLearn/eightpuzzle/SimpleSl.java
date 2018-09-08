//package dsLearn.eightpuzzle;
//
//public class SimpleSl {
//    int[][] initial = {
//            {1, 2, 3},
//            {5, 6, 0},
//            {7, 8, 4}
//    };
//    int[][] goal    = {
//            {1, 2, 3},
//            {5, 8, 6},
//            {0, 7, 4}
//    };
//    int n = 3;
//    class Node{
//        Node parent;
//        int[][] mat = new int[n][n];
//        //空 的坐标
//        int x,y;
//        int cost;
//        int level;
//    }
//    void print2D(int[][] matrix){
//        for (int i = 0; i <n ; i++) {
//            for (int j = 0; j <n ; j++) {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//    void swap(int[][] matrix,int x,int y,int newX,int newY){
//        int tmp = matrix[x][y];
//        matrix[x][y] = matrix[newX][newY];
//        matrix[newX][newY] = tmp;
//    }
//    Node createNode(int[][] matrix,int x,int y,int newX,int newY,int level,Node parent){
//        Node node = new Node();
//        node.parent = parent;
//        node.mat = matrix.clone();
//        swap(node.mat,x ,y , newX,newY);
//        node.cost = Integer.MAX_VALUE;
//        node.x = newX;
//        node.y = newY;
//        return node;
//    }
//    ThreadLocal
//    //汉明距离
//    int calCost(int[][] from,int[][] end){
//        int cnt = 0;
//        for (int i = 0; i <n ; i++) {
//            for (int j = 0; j <n ; j++) {
//                if(from[i][j]>0&&)
//
//            }
//
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//}
