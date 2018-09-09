package other_oj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class poj3414 {
    class pathNode{
        int a,b;
        int t;

        public pathNode(int a, int b, int t) {
            this.a = a;
            this.b = b;
            this.t = t;
        }

//        @Override
//        public String toString() {
//            return "pathNode{" +
//                    "a=" + a +
//                    ", b=" + b +
//                    ", op=" + t +
//                    '}';
//        }
    }
    class Cell{
        int a,b;

        public Cell(int a, int b) {
            this.a = a;
            this.b = b;
        }

//        @Override
//        public String toString() {
//            return "Cell{" +
//                    "a=" + a +
//                    ", b=" + b +
//                    '}';
//        }
    }


    void Bfs(int A,int B,int C){
        int cnt = 0;
        int[][] marked = new int[A+1][B+1];
        pathNode[] pathNodes = new pathNode[A+B+5];
        int[][] pre =  new int[A+1][B+1];

        Deque<Cell> que = new ArrayDeque<Cell>();
        //初始状态 2个空桶
        que.add(new Cell(0,0));
        marked[0][0] = 1;
        while (!que.isEmpty()){
            Cell cell = que.poll();
            int a = cell.a,b = cell.b;
            //6种操作 满，空，互相倒 x2
            for (int d = 0; d <6 ; d++) {
                int na=0,nb=0;
                //装满A
                if(d==0){na=A;nb=b;}
                else if(d==1){na= a;nb=B;}
                else if(d==2){na=0;nb=b;}
                else if(d==3){na=a; nb=0;}
                //A->B
                else if(d==4){
                    int all = a+b;
                    na = all>=B?all-B:0;
                    nb = all>=B?B:all;
                }
                //B->A
                else if(d==5){
                    int all = a+b;
                    na = all>=A?A:all;
                    nb = all>=A?all-A:0;
                }
                //这个桶状态没试过
                if(marked[na][nb]==0){
                    marked[na][nb] =1;
                    //关键：记录当前操作序号cnt是在node(a,b)是做d操作得来的
                    pathNodes[cnt] = new pathNode(a,b,d);
//                    System.out.println(Arrays.toString(pathNodes));
                    //可以查到对上一个的操作
                    pre[na][nb] = cnt;
                    cnt++;
                    if(na == C||nb==C){
                        Deque<Integer> op = new ArrayDeque<Integer>();
                        int enda = na,endb = nb;
                        while (enda!=0||endb!=0){
                            int p = pre[enda][endb];
                            op.push(pathNodes[p].t);
                            enda = pathNodes[p].a;
                            endb = pathNodes[p].b;
                        }
                        System.out.println(op.size());
                        while (!op.isEmpty()){
                            int x = op.poll();
                            if(x==0||x==1) System.out.printf("FILL(%d)\n",x+1);
                            else if(x==2||x==3)System.out.printf("DROP(%d)\n",x-1);
                            else if(x==4) System.out.printf("POUR(1,2)\n");
                            else if(x==5)System.out.printf("POUR(2,1)\n");
                        }
                        return;
                    }
                    que.add(new Cell(na,nb));


                }
            }
//            System.out.println("下一层");
        }
        System.out.println("impossible");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
//        int A= 3;
//        int B = 5;
//        int C = 4;
        poj3414 sl =  new poj3414();
        sl.Bfs(A, B, C);

    }
}
