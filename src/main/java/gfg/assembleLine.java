package gfg;

public class assembleLine {
    //打印路径好像有问题
    //https://www.cnblogs.com/Anker/archive/2013/03/09/2951785.html
    public void printStation(){
        int i = lastl;
        int j;
        System.out.printf("line %d station %d \n",i,4);
        for(j = 3;j>0;j--){
            i = l[i-1][j];
            System.out.printf("line %d station %d \n",i,j);

        }
    }
    int[][] l;
    int lastT=0;
    int lastl=0;
    public int assembly(int[][]line,int[][]t,int[]e,int[]x){
        int n = line[0].length;
        int[] T1 = new int[n];
        int[] T2 = new int[n];
        l = new int[n][n];
        l[0][0] = 1;
        l[1][0] = 2;

        //两条线经过第一个station后的用时
        T1[0] = e[0]+line[0][0];
        T2[0] = e[1]+line[1][0];
        for(int i =1;i<n;i++){
            if(T1[i-1]<T2[i-1]+t[1][i]){
                T1[i] =T1[i-1]+line[0][i];
                l[0][i] = 1;
            }else {
                T1[i] = T2[i-1]+t[1][i]+line[0][i];
                l[0][i] = 2;
            }
            if(T2[i-1]<T1[i-1]+t[0][i]){
                T2[i] = T1[i-1]+t[0][i]+line[1][i];
                l[1][i] = 1;
            }else {
                T2[i] =T2[i-1]+line[1][i];
                l[1][i] = 2;
            }
            //line1上第二个station用时是line1前一个用时+当前station 和 从line2上跳过来的用时的min
//            T1[i] = Math.min(T1[i-1]+line[0][i],T2[i-1]+t[1][i]+line[0][i]);
//            T2[i] = Math.min(T2[i-1]+line[1][i],T1[i-1]+t[0][i]+line[1][i]);
        }
        if(T1[n-1]+x[0]<T2[n-1]+x[1]){
            lastT = T1[n-1]+x[0];
            lastl = 1;
        }else {
            lastT = T2[n-1]+x[1];
            lastl = 2;

        }
        return Math.min(T1[n-1]+x[0],T2[n-1]+x[1]);
    }
    public static void main(String[] args) {
        //statin num
        int n = 4;
        //[2][4]两条装配线上4个station的耗时
        int[][] line ={
                {4, 5, 3, 2},
                {2, 10, 1, 4}};
        //两条装配线上换装配线到下一个station的额外开销
        int[][] t = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
//        entry time ei and exit time xi
        //要加上的开始时间和结束时间
        int e[] = {10,12};
        int x[] = {18,7};
        assembleLine sl = new assembleLine();

        System.out.println(sl.assembly(line, t, e, x));
        sl.printStation();
    }
}
