package dsLearn;

import java.util.Arrays;
import java.util.Random;

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
            else if(t>v)swap(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1,d);
        if(v>=0)sort(a, lt, gt, d+1);
        sort(a,gt+1,hi , d );
    }

    public static void main(String[] args) {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String[] words2 = new String[100000];
        Random random=new Random();
        for (int  j= 0; j <words2.length ; j++) {
            StringBuffer sb=new StringBuffer();
            int length = random.nextInt(500);
            for(int i=0;i<length;i++){
                int number=random.nextInt(62);
                sb.append(str.charAt(number));
            }
            words2[j] = sb.toString();
        }
        String[] word3 = words2.clone();
        String[] word4 = words2.clone();




        long start = System.currentTimeMillis();
        sort(words2, 0,words2.length-1 ,0 );
        long end = System.currentTimeMillis();
        System.out.println(end-start);


        long start2 = System.currentTimeMillis();
        MSD.sort(word3);
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);

        long start3 = System.currentTimeMillis();
        Arrays.sort(word4);
        long end3 = System.currentTimeMillis();
        System.out.println(end3-start3);

    }
}
