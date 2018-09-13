package courseBook.tspbb;

public class  HeapNode implements Comparable
{
    float lcost,//子树费用下界
            cc,//当前费用
            rcost;//X[s:n-1]中顶点最小出边费用和
    int s;//根节点到当前结点的路径为X[0:s]
    int []x;//需要进一步搜索的结点是x[s+1:n-1]

    //HeapNode的构造函数
    HeapNode(float lc,float ccc,float rc,int ss,int []xx)
    {
        lcost=lc;
        cc=ccc;
        s=ss;
        x=xx;
    }//HeapNode 构造函数

    public int compareTo(Object x)
    {
        float xlc=((HeapNode)x).lcost;
        if(lcost<xlc)
            return -1;
        if(lcost==xlc)
            return 0;
        return 1;
    }

}//class HeapNode