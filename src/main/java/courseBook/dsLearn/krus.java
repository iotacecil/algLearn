package courseBook.dsLearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class krus {
    int find(int x){
        if(fathers[x]==x)return x;
        return find(fathers[x]);
    }
    void unit(int x,int y){
        int fx = find(x);
        int fy = find(y);
        fathers[fx]=fy;
    }
    int[] fathers = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        krus samp = new krus();
        for (int i = 0; i <100 ; i++) {
            samp.fathers[i]=i;
        }
        int n,m;
        int a,b,w;
        ArrayList<pair3> edges = new ArrayList<pair3>();
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <m ; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            w = sc.nextInt();
            edges.add(new pair3(w,a,b));
        }
        int mst_weight =0,mst_edges = 0;
        //index
        int mst_ni=0;
        Collections.sort(edges, new Comparator<pair3>() {
            @Override
            public int compare(pair3 o1, pair3 o2) {
                return o1.w-o2.w;
            }
        });
        while ((mst_edges<n-1||(mst_ni<m))){
            a = edges.get(mst_ni).a;
            b = edges.get(mst_ni).b;
            w = edges.get(mst_ni).w;
            if(samp.find(a)!=samp.find(b)){
                samp.unit(a,b);
                mst_weight+=w;
                System.out.println(a+" "+b+" "+w);
                mst_edges++;
            }
            mst_ni++;
        }
        System.out.println(mst_weight);
    }
}
