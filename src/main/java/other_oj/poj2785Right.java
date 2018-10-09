package other_oj;

import java.util.Scanner;

public class poj2785Right {

        static Scanner scn = new Scanner(System.in);

        static final int MAXN = 4100;
        static int[][] numbers = new int[4][MAXN];
        static int[] sumAB = new int[MAXN*MAXN];
        public static void main(String[] args) {
            int t;
            t = scn.nextInt();
            while ((t--) > 0) {
                int n;
                n = scn.nextInt();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 4; j++) {
                        numbers[j][i] = scn.nextInt();
                    }
                }
                int p1 = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sumAB[p1++] = numbers[0][i] + numbers[1][j];
                    }
                }
                Tool.quickSort(sumAB,0,p1-1);
                //输出看看
//            for (int i = 0; i < p1; i++) {
//                System.out.print(sumAB[i] + " ");
//            } //成功
                //开始枚举-c-d
                int answer = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        answer += Tool.uppper(sumAB, 0, p1, -numbers[2][i] - numbers[3][j]) - Tool.lower(sumAB, 0, p1, -numbers[2][i] - numbers[3][j]);
                    }
                }
                System.out.println(answer);
                if(t > 0)
                    System.out.println();
            }
            System.exit(0);
        }
    }
    class Tool {
        public static int lower(int[] array, int low, int high, int number) {
            //[low,high)
            int i = low, j = high, m;
            while (i < j) {
                m = i + (j - i) / 2;
                if (array[m] >= number)
                    j = m;
                else
                    i = m+1;
            }
            return i;
        }
        public static int uppper(int[] array, int low, int high, int number) {
            int i = low, j = high, m;
            while (i < j) {
                m = i + (j - i) / 2;
                if (array[m] <= number)
                    i = m+1;
                else
                    j = m;
            }
            return i;
        }
        public static void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int m = partition(array, low, high);
                quickSort(array, low, m-1);
                quickSort(array, m+1, high);
            }
        }
        private static int partition(int[] array, int low, int high) {
            int mNumber = array[low];
            int i = low, j = high;
            while (i < j) {
                while (i < j && array[j] >= mNumber) {--j;}
                array[i] = array[j];
                while (i < j && array[i] <= mNumber) {++i;}
                array[j] = array[i];
            }
            array[i] = mNumber;
            return i;
        }

}
