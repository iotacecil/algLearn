package dsLearn;

public class threewaypart {
    private static int charAt(String s,int d){
        if(s.length()>d)return s.charAt(d);
        else return -1;
    }
    private static void swap(String[] a ,int i,int j){
        String tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    private static void sort(String[] a,int lo,int hi,int d){
        if(hi<=lo)return;
        int lt = lo,gt = hi;
        int v = charAt(a[lo],d);
        int i = lo+1;
        while (i<=gt){
            int t = charAt(a[i],d);
            if(t<v)swap(a,lt++,i++);
            else if(t>v)swap(a,i,gt++);
            else i++;
        }
    }
}
