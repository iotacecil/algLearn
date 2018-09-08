package dsLearn.basic;

import java.util.Arrays;

/*
洗牌算法
 */
public class KnuthShaffle {
    public static<T extends Comparable> void shuffle(T[] arr){
        int n = arr.length;
        for (int i = 0; i <n ; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random()*(i+1));
            T tmp = arr[r];
            arr[r] = arr[i];
            arr[i] = tmp;
        }
    }
    public static<T extends Comparable> void shuffle2(T[] arr) {
        int n = arr.length;
        for (int i = 0; i <n ; i++) {
            int r = i+(int)(Math.random()*(n-i));
            T tmp = arr[r];
            arr[r] = arr[i];
            arr[i] = tmp;
        }

    }


    public static void main(String[] args) {
        Integer[] arr = {9, 7, 3, 5, 7, 8, 4, 0, 2, 24};
        shuffle(arr);
        System.out.println(Arrays.toString(arr));

        int testCase = 100;
        int arrlen = 10;
        int[] freq = new int[arrlen];

        for (int i = 0; i < testCase; i++) {
            Integer[] test= new Integer[]{1, 1, 1, 1, 1, 0, 0, 0, 0, 0};

           shuffle(test);

            for (int j = 0; j <arrlen ; j++) {
                freq[j]+=test[j];
            }
        }
        for (int i = 0; i < arrlen; i++) {
            System.out.println(i+" "+(freq[i]/(double)testCase));

        }
    }
}
