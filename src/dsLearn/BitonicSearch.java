package dsLearn;


import java.util.Random;

// an increasing sequence of integers followed immediately by a decreasing sequence of integers
// given a bitonic array of N distinct int values, determines whether a given integer is in the array
public class BitonicSearch {

    public static int[] create(int N){
        Random random = new Random(1024);
        int mid = random.nextInt(N);
        System.out.println("mid "+mid);
        int[] a = new int[N];
        for(int i = 1;i<mid;i++){
            a[i] = a[i-1]+1+random.nextInt(9);
        }
        if(mid>0)a[mid] = a[mid-1]+random.nextInt(10)-5;
        for(int i = mid+1;i<N;i++){
            a[i] = a[i-1]-1-random.nextInt(9);
        }
        for (int i = 0; i <N ; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        return a;
    }
    // find the index of the maximum in a bitonic subarray a[lo..hi]
    public static int max(int[] a, int lo, int hi) {
        if (hi == lo) return hi;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < a[mid + 1]) return max(a, mid+1, hi);
        if (a[mid] > a[mid + 1]) return max(a, lo, mid);
        else return mid;
    }
    public static void main(String[] args) {
        int[] ints = new int[]  {-3, 7, 8, 20, 17, 5, 99};
        System.out.println(max(ints, 0, ints.length));
        int[] ints1 = create(9);
        System.out.println(max(ints1, 0, ints1.length));

    }
}
