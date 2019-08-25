package niuke.zhaoyin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
6 8 11 3
4
 */
/*
https://www.nowcoder.com/practice/336d00e600f8496287d0d472678da774?tpId=98&tqId=32863&rp=2&ru=%2Fta%2F2019test&qru=%2Fta%2F2019test%2Fquestion-ranking
 */



public class Test5_3 {
    public static int N=100;          //默认定义数组大小
    static int[][] a=new int[N][N];   //图用邻接矩阵表示
    static int [] x=new int[N];       //是否将第i个节点加入团中
    static int [] bestx=new int[N];   //记录最优解
    static int bestn;                 //记录最优值
    static int cn;                    //当前已放入团中的节点数量
    static int n,m;                   //n为图中节点数  m为图中边数

    public static void main(String [] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入部落的人数n（节点数):");
        n=sc.nextInt();
        System.out.println("请输入人与人的友好关系(边数):");
        m=sc.nextInt();
        System.out.println("请依次输入有友好关系的两个人(有边相连的两个节点u,v）用空格分开:");
        int u,v;                      //有边相连的两个节点u,v
        for(int i=1;i<=m;i++) {
            u=sc.nextInt();
            v=sc.nextInt();
            a[u][v]=a[v][u]=1;        //边数为1
        }


        bestn=0;                     //初始最优值为0
        cn=0;                        //初始的团中节点也为0
        backTrack(1);                //从第一个节点进行深度搜索
        System.out.println("国王护卫队的最大人数为:"+bestn);
        System.out.println("国王护卫队的成员：");
        for(int i=0;i<=n;i++) {
            if(bestx[i]==1)          //打印最优解中记录为1的节点标号
                System.out.print(i+" ");
        }
    }

    /*进行深度搜索*/
    private static void backTrack(int t) { //t：当前扩展节点在第t层
        if(t>n) {    //达到根节点  记录可行解 并记录此时节点数目
            for(int i=1;i<=n;i++)
                bestx[i]=x[i];
            bestn=cn;
            return;
        }

        if(place(t)) {       //判断是否满足约束条件（边是否连通）-->左子树-->把节点加入团中
            x[t]=1;          //左子树 标记为1
            cn++;            //当前节点数+1

            backTrack(t+1);  //继续搜索t+1层
            cn--;            //回溯   加多少就减多少   回退
        }

        if(cn+ n-t> bestn) {  //满足限界条件  -->右子数
            x[t]=0;
            backTrack(t+1);
        }


    }

    private static boolean place(int t) {  //判断是否可以把节点t加入团中
        boolean ok=true;
        for(int j=1;j<t;j++) {
            if(x[j]==1&& a[t][j]==0) {
                ok=false;
                break;
            }
        }

        return ok;

    }
}

public class 爱吃喵粮的小招财猫2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(" ");
        int H = Integer.parseInt(bf.readLine());

        int[] h = new int[split.length];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <split.length ; i++) {
            h[i] = Integer.parseInt(split[i]);
            max = Math.max(max, h[i]);
            min = Math.min(min, h[i]);
        }
        for (int i = 1; i <=max ; i++) {
            int cut = 0;
            for(int itm:h){

                if(itm%i==0){
                    cut+= itm/i;
                }else {
                    cut += (itm/i)+1;
                }
            }
            //System.out.println(i+" "+cut);
            if(cut<=H){
                System.out.println(i);
                return;
            }

        }
        System.out.println(-1);


    }
}
