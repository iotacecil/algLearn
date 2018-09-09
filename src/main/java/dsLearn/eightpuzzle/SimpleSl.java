package dsLearn.eightpuzzle;

import java.util.PriorityQueue;

public class SimpleSl {

    int n = 3;
    boolean[][] marked = new boolean[n][n];

    class Node{
        Node parent;
        int[][] mat = new int[n][n];
        //空 的坐标
        int x,y;
        int cost;
        int level;

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
        System.out.println("从"+x+" "+y+"到"+newX+" "+newY);
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[newX][newY];
        matrix[newX][newY] = tmp;
    }
    Node createNode(int[][] matrix,int x,int y,int newX,int newY,int level,Node parent){
        Node node = new Node();
        node.parent = parent;
        node.mat = matrix.clone();
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
                if(from[i][j]>0&&from[i][j]!=end[i][j])cnt++;
            }
        }
        print2D(from);
        System.out.println("到");
        print2D(end);
        System.out.println("距离是 "+cnt);
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
    int row[] = {1,0,-1,0};
    int col[] = {0,-1,0,1};

    void slove(int[][] from,int x,int y,int[][] end){
        PriorityQueue<Node> que = new PriorityQueue<>(
                (node1,node2)->{
                    return (node2.cost+node2.level)-(node1.cost+node1.level);
        }
        );
        Node root = createNode(from,x ,y ,x ,y ,0 , null);
        root.cost = calCost(from,end );
        marked[x][y] =
        que.add(root);
        while(!que.isEmpty()){
            Node min = que.poll();
            //结果，从子节点向上递归打印
            if(min.cost==0){
                print2D(min.mat);
                return;
//                printPath(min);
            }
            //4个方向挪动白块四个方向死循环？？？
            for (int i = 0; i < 4; i++) {
                if(isInBoard(min.x+row[i],min.y+col[i])){
                    Node child = createNode(min.mat,min.x ,min.y , min.x+row[i], min.y+col[i], min.level+1, min);
                    child.cost = calCost(child.mat,end );
//                    if(child.cost<=root.cost)
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
