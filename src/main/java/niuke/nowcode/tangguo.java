package niuke.nowcode;

import java.util.Scanner;

public class tangguo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
//        PriorityQueue<Integer> que1 = new PriorityQueue<>();
//        PriorityQueue<Integer> que2 = new PriorityQueue<>();

        int[] arr2 = new int[n];
        int sum1 = 0;
        int mindif = 0;
        int sum2 = 0;
        for (int i = 0; i <n ; i++) {
            int tmp = sc.nextInt();
            arr1[i] = tmp;
            sum1+=tmp;
            //que1.add(tmp);
        }

        for (int i = 0; i <n ; i++) {
            int tmp = sc.nextInt();
            arr2[i] = tmp;
            sum2+=tmp;
       //     que2.add(tmp);
        }

        if(sum1==sum2) System.out.println(0);
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
        int rst = Integer.MAX_VALUE;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                rst = Math.min(rst, Math.abs(arr2[i]-arr1[j]));
            }

        }
        if(sum1<sum2)
        System.out.println(-rst);
        else System.out.println(rst);

//        long rst1 = 0;
//        long rst2 =0;
//
//        while (!que1.isEmpty() || !que2.isEmpty()){
//            if(que1.isEmpty()){
//                que2.poll();
//            }
//            Integer tmp1 = que1.peek();
//            Integer tmp2 = que2.peek();
//            if(tmp2 > tmp1){
//                que2.poll();
//            }
//            if(tmp1>tmp2){
//                rst1+=que1.poll();
//            }
//        }

    }
}
