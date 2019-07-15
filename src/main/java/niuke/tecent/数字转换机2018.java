package niuke.tecent;

import java.util.Scanner;

public class 数字转换机2018 {
    static class State {
        int a;
        int b;
        //int cnt;
    }


    private static int solu(int a, int b, int A, int B) {
        if (a > A || b > B) return -1;
        if (a == A && b == B) return 1;
        int rst = Integer.MAX_VALUE;
        int cnt1 = 1 + solu(a + 1, b + 1, A, B);
        int cnt2 = 1 + solu(a * 2, b * 2, A, B);
        if (cnt1 != -1)
            rst = Math.min(cnt1, rst);
        if (cnt2 != 1) {
            rst = Math.min(cnt2, rst);
        }
        return rst == Integer.MAX_VALUE ? -1 : rst;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
//        System.out.println(a+ " "+b+" "+A+" "+B);

        // +  n次   * m次
        System.out.println(solu(a, b, A, B));
//        int cnt = 0;
//        while (A!=a&&B!=b){
//            if(A%2==0 && B%2==0){
//                A/=2;
//                B/=2;
//                cnt++;
//            }else if(A%2!=0 && B%2!=0){
//                A--;
//                B--;
//            }else{
//                cnt=-1;
//                break;
//            }
//        }
//        System.out.println(cnt);


//        Deque<int[]> que = new ArrayDeque<>();
//        que.add(new int[]{a,b});
//        int step = 0;
//        boolean found = false;
//        out:
//        while (!que.isEmpty()){
//            int size=que.size();
//            while (size-->0){
//                int[] top = que.poll();
//                if(top[0]==A&&top[1]==B){
//                    System.out.println(step);
//                    found = true;
//                    break out;
//                }
//                if(top[0]*2<=A&&top[1]*2<=B){
//                    que.add(new int[]{top[0]*2,top[1]*2});
//                }
//                if(top[0]+1 <=A && top[1]+1<=B){
//                    que.add(new int[]{top[0]+1,top[1]+1});
//                }
//
//            }
//            step+=1;
//        }
//        if(!found) System.out.println(-1);

    }


}
