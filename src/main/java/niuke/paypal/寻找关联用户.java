package niuke.paypal;

import java.util.*;

/*
2.0
5
3.0 5.0
6.0 13.0
2.0 6.0
7.0 12.0
0.0 2.0

5.2
10
1.2 2.4
3.6 4.8
22.5 6.9
11.8 9.227
1.1 5.7
19.6 30.8
100.7 100.8
98.6 22.7
43.2 23.7
10.1 12.3

5.2
5
1.2 2.4
3.6 4.8
22.5 6.9
11.8 9.227
1.1 5.7
 */
public class 寻找关联用户 {
    static class Node {
        double[] po = new double[2];
        int id;

        public Node(double x, double y, int id) {
            this.po[0] = x;
            this.po[1] = y;
            this.id = id;
        }
    }

    public static double distance(double[] a, double[] b) {
//
        double v = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);

        return Math.sqrt(v);
    }

    public static void union(int node1, int node2) {
        int find1 = find(node1);
        int find2 = find(node2);
        if (find1 != find2) {
            parent[find1] = find2;

        }
    }

    public static int find(int node) {
        if (parent[node] == node) return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        parent = new int[n];
//        double[][] users = new double[n][2];

//        List[] map = new List[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(sc.nextDouble(), sc.nextDouble(), i);
            parent[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (distance(nodes[i].po, nodes[j].po) <= d) {
                    System.out.println(i + " " + Arrays.toString(nodes[i].po));
                    System.out.println(j + " " + Arrays.toString(nodes[j].po));
                    System.out.println(distance(nodes[i].po, nodes[j].po));
                    union(nodes[i].id, nodes[j].id);
                    System.out.println(Arrays.toString(parent));
                }
            }

        }
        System.out.println(Arrays.toString(parent));
        HashMap<Integer, List<Integer>> rst = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!rst.containsKey(parent[i])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                rst.put(parent[i], list);
            } else {
                rst.get(parent[i]).add(i);
            }

        }
        System.out.println(rst.values());
//        System.out.println("");
//        for(List<Integer> list:rst.values()){
//
//        }


    }
}
