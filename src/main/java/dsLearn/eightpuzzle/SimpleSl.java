package dsLearn.eightpuzzle;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SimpleSl {
    int n = 3;
    int row[] = {1,0,-1,0};
    int col[] = {0,-1,0,1};

    class Node{
        Node parent;
        int[][] mat = new int[n][n];
        //空 的坐标
        int x,y;
        int cost;
        int level;

//        public Node(int[][] matrix, int x, int y, int newX, int newY, int level, Node parent) {
//            this.parent = parent;
//            this.mat = new int[matrix.length][];
//            for (int i = 0; i < matrix.length; i++) {
//                this.mat[i] = matrix[i].clone();
//            }
//
////            this.mat = matrix.clone();
//            // Swap value
//            this.mat[x][y]       = this.mat[x][y] + this.mat[newX][newY];
//            this.mat[newX][newY] = this.mat[x][y] - this.mat[newX][newY];
//            this.mat[x][y]       = this.mat[x][y] - this.mat[newX][newY];
//
//            this.cost = Integer.MAX_VALUE;
//            this.level = level;
//            this.x = newX;
//            this.y = newY;
//        }

        @Override
        public String toString() {
            print2D(mat);
            return "Node{" +
                    "parent=" + parent +

                    ", x=" + x +
                    ", y=" + y +
                    ", cost=" + cost +
                    ", level=" + level +
                    '}';
        }
    }
    void print2D(int[][] matrix){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    void swap(int[][] matrix,int x,int y,int newX,int newY){
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[newX][newY];
        matrix[newX][newY] = tmp;
    }
    Node createNode(int[][] matrix,int x,int y,int newX,int newY,int level,Node parent){
        Node node = new Node();
        node.parent = parent;

        node.mat = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            node.mat[i] = matrix[i].clone();
        }
        swap(node.mat,x ,y , newX,newY);
        node.cost = Integer.MAX_VALUE;
        node.x = newX;
        node.y = newY;
        return node;
    }


    //汉明距离
    int calCost(int[][] from,int[][] end){
        int cnt = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(from[i][j]!=0&&from[i][j]!=end[i][j])cnt++;
            }
        }
//        print2D(from);
//        System.out.println("到");
//        print2D(end);
//        System.out.println("距离是 "+cnt);
        return cnt;
    }

    boolean isInBoard(int x,int y){
        return (x>=0&&x<n&&y>=0&&y<n);
    }
    //从root到结果的矩阵变化情况
    void printPath(Node root){
        if(root == null)return;
        printPath(root.parent);
        print2D(root.mat);
        System.out.println();
    }


    void slove(int[][] from,int x,int y,int[][] end){
        //扩展距离小的
        PriorityQueue<Node> que = new PriorityQueue<>(
                Comparator.comparingInt(node -> (node.cost + node.level))

        );
        Node root = createNode(from,x ,y ,x ,y ,0 , null);
        root.cost = calCost(from,end );

        que.add(root);
        while(!que.isEmpty()){
            Node min = que.poll();
            //结果，从子节点向上递归打印
            if(min.cost==0) {
//                print2D(min.mat);
                printPath(min);

                return;
            }
            //4个方向挪动白块四个方向为什么不会重复状态死循环
            for (int i = 0; i < 4; i++) {
                if(isInBoard(min.x+row[i],min.y+col[i])){
                    Node child = createNode(min.mat,min.x ,min.y , min.x+row[i], min.y+col[i], min.level+1, min);
                    child.cost = calCost(child.mat,end );
                    que.add(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleSl sl = new SimpleSl();
        int[][] initial = {
                {1, 2, 3},
                {5, 6, 0},
                {7, 8, 4}
        };
        int[][] end    = {
                {1, 2, 3},
                {5, 8, 6},
                {0, 7, 4}
        };
        sl.slove(initial, 1,2 , end);
    }
}
