package courseBook.dsLearn;

import java.util.Arrays;

public class MSD {
    private static String[] aux;
    private static int R = 256;
    private static final int M = 3;
    private static int charAt(String s,int d){
        if(s.length()>d)return s.charAt(d);
        else return -1;
    }
    public static void sort(String[] a){
        aux = new String[a.length];
        sort(a,0,a.length-1,0);
    }
    private static boolean less(String v,String w,int d){
        for (int i = d; i <Math.min(v.length(),w.length()) ; i++) {
            if(v.charAt(i)<w.charAt(i))return true;
            if(v.charAt(i)>w.charAt(i))return false;
        }
        return  v.length()<w.length();
//        return v.substring(d).compareTo(w.substring(d))<0;
    }
    private static void sort(String[] a,int lo,int hi,int d){
        if(hi<=lo)return;
        //添加一步阈值，如果a长度太小，直接用插入排序
        if(hi<=lo+M){
            for (int i = lo; i <=hi ; i++) {
                for (int j = i; j >lo&&less(a[j],a[j-1],d);j--) {
                    String tmp = a[j];
                    a[j]=a[j-1];
                    a[j-1]=tmp;
                }
            }
            return;
        }
        //0位留作字符串结尾？
        int[] count = new int[R+2 ];
        for (int i = lo; i <=hi ; i++) {
            count[charAt(a[i],d)+2]++;
        }
        for (int i = 0; i <R+1 ; i++) {
            count[i+1]+=count[i];
        }
        for (int i = lo; i <=hi ; i++) {
            aux[count[charAt(a[i],d)+1]++] = a[i];
        }
        for (int i = lo; i <=hi ; i++) {
            a[i] =aux[i-lo];
        }
        for (int i = 0; i <R ; i++) {
            sort(a,lo+count[i],lo+count[i+1]-1,d+1);
        }
    }

    public static void main(String[] args) {
        String[] words = {"4PGC938","2iye230","2iye231","3cio720","fds","1","4PGC933","4PGC9382","4PGC9384","4PGC9385","4PGC9387","4PGC9388","4PGC9389"};
        sort(words);
        System.out.println(Arrays.toString(words));
    }
}
