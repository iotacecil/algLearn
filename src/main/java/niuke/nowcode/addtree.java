package niuke.nowcode;

import java.util.*;
class node{
    long val;
    long sum;
    List<Long> path;
    List<Character> funcs;


    public node(int sum,int val, List<Long> path, List<Character> funcs) {
        this.val = val;
        this.sum = sum;
        this.path = path;
        this.funcs = funcs;
    }
    public node(node a) {
        this.val = a.val;
        this.sum = a.sum;
        this.path = new ArrayList<>(a.path);
        this.funcs =new ArrayList<>( a.funcs);
    }
}
public class addtree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int rst = 0;
        PriorityQueue<node> que = new PriorityQueue<>((a,b)->(int)(a.sum-b.sum));
//        Queue<node> que = new ArrayDeque<>();
        ArrayList<Long> path = new ArrayList<>();
        path.add(1l);
        ArrayList<Character> funcs = new ArrayList<>();
        funcs.add('+');

        node node1 = new node(1,1,path,funcs);
        ArrayList<Long> path2 = new ArrayList<>();
        path2.add(-1l);
        ArrayList<Character> funcs2 = new ArrayList<>();
        funcs2.add('-');
        node node2 = new node(1,-1,path2,funcs2);
        que.add(node1);
        que.add(node2);

        int level = 1;
        label:
        while (level<=k){
            int size = que.size();
            while (size-->0){
                node cur = que.poll();
                for (long i = 1<<level; i < (1<<(level+1)); i++) {
                    if (cur.val+i==n) {

                        int pa = cur.path.size();
                        for (int j = 0; j <pa ; j++) {
                            System.out.println(Math.abs(cur.path.get(j))+" "+cur.funcs.get(j));
                        }
                        System.out.println(i+" "+"+");
                        break label;

                    }else if (cur.val+i==n) {

                        int pa = cur.path.size();
                        for (int j = 0; j <pa ; j++) {
                            System.out.println(Math.abs(cur.path.get(j))+" "+cur.funcs.get(j));
                        }
                        System.out.println(i+" "+"+");
                        break label;
                    }else{
                        node n1 = new node(cur);
                        n1.sum+=i;
                        n1.val+=i;
                        n1.path.add(i);
                        n1.funcs.add('+');
                        que.add(n1);

                        node n2 = new node(cur);
                        n2.sum+=i;
                        n2.val-=i;
                        n2.path.add(i);
                        n2.funcs.add('-');
                        que.add(n2);
                    }
                }
            }

            level++;
        }
    }
}
