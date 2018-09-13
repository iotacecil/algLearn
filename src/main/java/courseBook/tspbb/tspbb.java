package courseBook.tspbb;

import java.util.Scanner;

public class tspbb {
    static float [][]a={
            {-1,30,6,4},
            {30,-1,5,10},
            {6,5,-1,20},
            {4,10,20,-1}
    };
    public static void main(String[] args) {
//        Scanner s=new Scanner(System.in);
        int n=4;//结点的个数
//        String line=s.nextLine();//读入n
//        n=Integer.parseInt(line);
//        a=new float[n][n];
        int []vv=new int[n];
        System.out.println(bbTsp(vv));
    }
    public static int  bbTsp(int []v)
    {
        int n=v.length;
        MinHeap heap=new MinHeap(100);
        float []minOut=new float[n];//minOut[i]是顶点i的最小出边费用
        float minSum=0;//最小出边费用和
        //计算最小出边费用和
        for(int i=0;i<n;i++) {
            //min是[0][j]的最小cost
            float min = Float.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (j!=i && a[i][j] < min)
                    min = a[i][j];
            }//for j
            if (min == Float.MAX_VALUE) {
                return -1;
            }//if
            minOut[i] = min;
            //minsum是整条路径走每个点出发的最短边的最低估计
            minSum += min;
        }
        //未来路径0,1,2,3
        int []x=new int[n];
        for(int i=0;i<n;i++)
        {
            x[i]=i;
        }

        HeapNode enode=new HeapNode(0,0,minSum,0,x);
        float bestc = Float.MAX_VALUE;

        while (enode!=null&&enode.s<n-1){
            x = enode.x;
            if(enode.s==n-2){
                //a[x[n-2]][x[n-1]]!=0&&a[x[n-1]][1]!=-1
                if(bestc == Float.MAX_VALUE){
                    bestc = enode.cc+a[x[n-2]][x[n-1]]+a[x[n-1]][0];
                    enode.cc = bestc;
                    enode.lcost = bestc;
                    enode.s++;
                    heap.put(enode);
                }
            }else{
                for (int i = enode.s+1; i < n; i++) {
                    if(a[x[enode.s]][x[i]]!=-1){
                        float cc = enode.cc+a[x[enode.s]][x[i]];
                        float rcost = enode.rcost-minOut[x[enode.s]];
                        float b = cc+rcost;
                        if(b<bestc){
                            int[] xx = new int[n];
                            for (int j = 0; j <n ; j++) {
                                xx[j] = x[j];
                                xx[enode.s+1] = x[i];
                                xx[i] = x[enode.s+1];
                                HeapNode node = new HeapNode(b,cc,rcost,enode.s+1,xx);
                                heap.put(node);
                            }
                        }//当前路径可能更短
                    }

                }
            }
            enode = (HeapNode)heap.removeMin();
        }
        for (int i = 0; i < n; i++) {
            v[i] = x[i];
            return (int)bestc;
        }

        return 0;
    }
    //最小堆

}
