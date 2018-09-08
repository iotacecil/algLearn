package dsLearn.basic;

import java.util.*;
//https://algs4.cs.princeton.edu/23quicksort/
public class QuickS {

    public static <T extends Comparable> void sort2elem(T[] a){
        int lt =  0,gt = a.length-1;
        int i =0;
        while(i<=gt){
            int cmp = a[i].compareTo(a[lt]);
            if      (cmp < 0) swap(a, lt++, i++);
            else if (cmp > 0) swap(a, i, gt--);
            else              i++;
        }
    }
    //3way
    public static<T extends Comparable> void sort3way(T[] a){
//        KnuthShaffle.shuffle(a);
        sort2(a,0,a.length-1);
    }
    private static<T extends Comparable> void sort2(T[] a,int lo,int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) swap(a, lt++, i++);
            else if (cmp > 0) swap(a, i, gt--);
            else              i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);

    }

        //普通
    private static <T extends Comparable> void swap(T[] a,int lo,int hi){
        T tmp = a[lo];
        a[lo] = a[hi];
        a[hi] = tmp;
    }
    private static<T extends Comparable> int partition(T[] a,int lo,int hi){
        int i = lo,j = hi+1;
        while (true){
            while (a[++i].compareTo(a[lo])<0){
                if(i==hi)break;
            }
            while (a[lo].compareTo(a[--j])<0){
                if(j==lo)break;
            }
            if(i>=j) break;
            swap(a, i, j);
        }
        swap(a,lo ,j );
        return j;
    }
    public static<T extends Comparable> void sort(T[] a){
//        KnuthShaffle.shuffle(a);
        sort(a,0,a.length-1);
    }
    private static<T extends Comparable> void sort(T[] a,int lo,int hi){
        if(hi<=lo)return;
        int j = partition(a,lo ,hi );
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static void main(String[] args) {
        Integer[] arr = {9,7,3,5,7,8,4, 0,2,24};
        sort3way(arr);
        Integer[] towele = {1,0,1,0,1,0,1};
        sort2elem(towele);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(towele));

        Random rd = new Random(1024);
        int len = 1000;
        int cases = 100;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i <cases ; i++) {
            Integer[] tmp = new Integer[len];
            for (int j = 0; j <len ; j++) {
                tmp[j] = rd.nextInt(1000);
            }
            list.add(tmp);
        }
        List<Integer[]> copytest = new ArrayList<>(list);
        List<Integer[]> copytest2 = new ArrayList<>(list);
        long start = System.currentTimeMillis();
        for(Integer[] testarr:list){
            sort(testarr);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        long start2 = System.currentTimeMillis();
        for(Integer[] testarr:copytest){
            Arrays.sort(testarr);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);


        long start3= System.currentTimeMillis();
        for(Integer[] testarr:copytest2){
            Arrays.sort(testarr);
        }
        long end3 = System.currentTimeMillis();
        System.out.println(end2-start2);



    }

}
