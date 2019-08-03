package niuke.wangyi;


import java.util.Arrays;
import java.util.Scanner;

public class 整理房间right {
    static class Node {
        int a, b, x, y;

        public Node(int a, int b, int x, int y) {
            this.a = a;
            this.b = b;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "a=" + a +
                    ", b=" + b +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void rotate(Node node) {
        int a = node.a, b = node.b;
        node.a = node.x - (b - node.y);
        node.b = node.y + (a - node.x);
    }

    public static int len_2(int x1, int x2, int y1, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public static boolean vaild(Node[] nodes) {
        if (nodes[1].a == nodes[2].a && nodes[1].b == nodes[2].b) return false;
        if (nodes[1].a == nodes[3].a && nodes[1].b == nodes[3].b) return false;
        if (nodes[2].a == nodes[3].a && nodes[2].b == nodes[3].b) return false;
        int l1 = len_2(nodes[0].a, nodes[1].a, nodes[0].b, nodes[1].b);
        int l2 = len_2(nodes[0].a, nodes[2].a, nodes[0].b, nodes[2].b);
        int l3 = len_2(nodes[0].a, nodes[3].a, nodes[0].b, nodes[3].b);
        //System.out.println(l1 + " " + l2 + " " + l3);
        if (l1 != 0 && l1 == l2 && l1 * 2 == l3) return true;
        if (l1 != 0 && l1 == l3 && l1 * 2 == l2) return true;
        if (l2 != 0 && l2 == l3 && l2 * 2 == l1) return true;
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[4];
        while (n-- > 0) {
            for (int i = 0; i < 4; i++) {
                nodes[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++, rotate(nodes[0])) {
                for (int j = 0; j < 4; j++, rotate(nodes[1])) {
                    for (int k = 0; k < 4; k++, rotate(nodes[2])) {
                        for (int l = 0; l < 4; l++, rotate(nodes[3])) {
//                          for (int t = 0; t < 4; t++) {
//                              System.out.print(nodes[t].a + " " + nodes[t].b + ";");
//                          }
//                          System.out.println(i + " " + j + " " + k + " " + l);
                            if (vaild(nodes)) {
                                System.out.println(i + " " + j + " " + k + " " + l);
                                System.out.println(Arrays.toString(nodes));

                                min = Math.min(min, i + j + k + l);
                                //
                            }
                        }
                    }
                }
            }
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }
}

