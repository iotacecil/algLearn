package niuke.huawei;

import java.util.*;

public class suijishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        ArrayList<Integer> arr = new ArrayList<>(set);
        arr.sort((a,b)->a-b);
        for(int a:arr){
            System.out.println(a);
        }
    }
}
