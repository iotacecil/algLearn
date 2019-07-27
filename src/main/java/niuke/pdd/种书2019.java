package niuke.pdd;

import java.util.Scanner;

/*
字典序最小的方案

1 2 4
4 1 4 2 4 2 4


 */
public class 种书2019 {
    static class Tree {
        int type;
        int num;

        public Tree(int type, int num) {
            this.type = type;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "type=" + type +
                    ", num=" + num +
                    '}';
        }
    }

    /*


686 1 3 1 1 2 5 1 2 2 1 5 4 4 2 1 1 3 1 4 4 1 1 3 2 1 1 2 4 3 3 2 3 1 4 4 1 1 2 1 2 1 2 1 3 2 1 3 3 2 2 2 1 1 1 4 1 1 3 1 1 1 2 5 2 1 1 3 1 1 3 1 2 1 1 1 3 3 1 2 3 2 3 1 2 1 3 1 2 1 1 4 2 3 1 1 1 6 2 1 6 3 6 3 3 1 1 1 1 1 2 2 1 3 1 2 1 1 1 1 1 1 1 1 1 1 3 1 1 1 1 1 2 3 1 1 1 5 1 2 2 1 1 1 2 2 1 4 2 1 1 4 1 4 1 1 2 1 2 2 2 2 2 2 3 2 1 1 1 1 5 1 3 1 1 2 4 3 1 2 1 4 1 2 2 3 4 1 3 2 1 2 3 1 2 4 2 1 1 3 1 4 4 2 4 2 7 1 2 4 3 1 3 1 5 2 1 1 1 2 3 1 1 1 4 1 1 5 1 1 2 1 1 5 3 1 3 2 2 1 1 3 1 1 1 3 2 4 1 1 3 3 3 1 1 1 4 2 2 5 1 6 1 1 1 5 1 2 1 5 5 1 1 3 4 3 1 2 3 2 3 3 5 1 1 2 1 1 1 6 1 1 4 1 1 2 1 1 1 2 1 2 2 1 1 1 1 3 2 1 2 2 1 1 2 2 1 5 3 1 1 3 4 6 1 2 4 1 3 1 2 1 1 1 5 1 1 5 1 2 2 3 1 1 1 2 1 2 1 2 1 1 2 4 2 1 1 2 2 1 4 2 1 1 1 5 3 1 4 2 2 3 2 1 1 3 2 1 2 1 1 2 1 2 3 2 3 2 2 4 4 5 1 2 1 2 1 1 1 1 4 1 1 1 6 2 1 2 3 4 1 2 1 1 3 1 4 1 3 1 1 2 1 2 1 2 2 2 4 2 4 2 1 1 1 1 1 1 2 2 1 4 1 1 4 1 3 1 4 1 2 3 1 1 3 1 1 1 2 2 1 1 1 2 1 5 5 2 2 1 3 6 3 1 4 1 1 4 1 1 2 1 2 2 3 1 7 1 3 1 1 1 1 2 1 3 1 1 2 2 1 1 4 2 3 1 2 1 1 1 3 3 2 1 1 2 1 1 1 5 2 4 5 4 2 2 1 1 2 5 1 1 2 6 1 4 2 3 1 3 2 2 4 5 1 1 2 4 1 3 4 1 1 4 1 1 1 2 5 2 4 1 2 1 2 5 2 2 4 1 1 1 1 4 1 1 1 1 1 3 1 1 4 1 4 2 4 1 1 3 1 1 3 2 1 1 1 1 1 1 2 1 4 1 1 1 1 4 1 1 7 1 3 2 1 3 1 3 5 3 3 3 2 3 2 7 3 1 4 5 1 2 1 2 2 1 1 1 3 4 4 2 2 1 1 1 5 6 2 6 1 2 4 4 3 1 2 6 5 2 4 3 1 2 3 3 1 1 1 2 1 1 3 3 1 5 1 6 2 2 2 1 2 2 1 5 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  int m = sc.nextInt();
        int n = sc.nextInt();
        Tree[] tree = new Tree[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Tree(i + 1, sc.nextInt());
        }
        //  System.out.println(Arrays.toString(tree));

        // Arrays.sort(tree,(a,b)->b.num-a.num);
        StringBuilder sb = new StringBuilder();
        int first = 0;

        boolean shibai = false;

        while (first < n) {
            while (first < n && tree[first].num == 0) {
                first++;
            }
            int idx = first + 1;
            out:
            while (idx < n) {
                while (idx < n && tree[idx].num == 0) {
                    idx++;

                }
                while (idx < n && first < n && tree[idx].num > 0 && tree[first].num > 0) {

                    sb.append(tree[first].type)
                            .append(" ")
                            .append(tree[idx].type)
                            .append(" ");
                    tree[idx].num--;
                    tree[first].num--;
                    if (tree[first].num == 0) {
                        first++;
                        break out;
                    }
                }
            }
//            System.out.println(Arrays.toString(tree));
//            System.out.println(idx);
            if (idx > n - 1) {
                if (tree[first].num == 0) break;
                if (tree[first].num == 1) {
                    sb.append(tree[first].type);
                    break;
                } else {
                    System.out.println("-");
                    shibai = true;
                    break;
                }
            }
        }

//        while (true){
//            if(tree[0].num==1){
//                sb.append(tree[0].type);
//                break;
//            }
//            if(tree[1].num==0){
//                System.out.println("-");
//                shibai=true;
//                break;
//            }
//            while (tree[1].num>0){
//                sb.append(tree[0].type).append(" ").append(tree[1].type).append(" ");
//                tree[0].num--;
//                tree[1].num--;
//            }
//            //System.out.println(sb.toString());
//          //  System.out.println(Arrays.toString(tree));
//        //    Arrays.sort(tree,(a,b)->b.num-a.num);
//
//        }
        if (!shibai) {
            System.out.println(sb.toString());
        }


    }
}
