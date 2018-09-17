package other_oj;


import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * //todo some problem
 * 41063625 (345^2)可以重排为 56623104 384^3 6643015 405^2
 * 求重排中抢号有5个立方数的最小立方数
 */
public class cubicpermu {

final static int DEPTH = 4;
long result = 0;
cubicpermu(){
    for (int i = 346; result==0; i++) {
        final long cube = i*i*i;
        final List<Long> roots = new ArrayList<>(DEPTH);
        searchermutation(i,L(cube) ,digitCount(cube) ,DEPTH , roots);
        if(roots.size()==DEPTH){
            System.out.println(i +","+ roots.get(0) +","+ roots.get(1) +","+ roots.get(2) +","+ roots.get(3));
            result = cube;
        }


    }
}
int L(final long n){
    return (int) Math.log10(n)+1;
}
byte[] digitCount(long n){
    final byte[] counts = new byte[10];
    for (; n>0; n/=10) {
        counts[(int)(n%10)]++;
    }
    return counts;
}
void searchermutation(final long parentN,final int cubeL,final byte[] counts,final int depth,final List<Long> roots){
    if(depth>0){
        for (long n = parentN+1; true ; n++) {
            final long cube  = n*n*n;
            if(L(cube)>cubeL)break;
            if(Arrays.equals(counts, digitCount(cube))){
                roots.add(n);
                searchermutation(n, cubeL,counts ,depth-1 ,roots );
                return;
            }

        }
    }
}

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        System.out.println(new cubicpermu().result + ", " + (System.currentTimeMillis()-start) + "ms");
    }
}
