package niuke.tecent;

import java.util.*;

interface cl1{
    int a =1;
}

public class dif implements cl1{



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        Iterator<Integer> iterator = list.iterator();
//        list.add(1 );
//        while (iterator.hasNext()){
//            list.add(1 );
//            list.add(1 );
//            list.add(1 );
//            list.add(1 );
//        }
//        System.out.println(list);

        Scanner sc = new Scanner(System.in);
        System.out.println(a);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int difmin = Integer.MAX_VALUE;
        int difmax = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        if(arr[0] == arr[n-1]){
            System.out.println(n*(n-1)/2+" "+n*(n-1)/2);
            return;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num :arr){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        System.out.println(Arrays.toString(arr));
        int mincnt = 0;
        int minval = 0;
        int mindif = Integer.MAX_VALUE;
//        for(Integer key:map.keySet()){
//            int val = map.get(key);
//            if(val > 1){
//                mincnt +=
//            }
//        }
        for (int i = 1; i <n ; i++) {
            if(arr[i] - arr[i-1] == 0){
                Integer num = map.get(arr[i]);

                mincnt += (num * (num-1)/2);
                minval = Math.max(minval, mincnt);
            }
            else{
                if(arr[i]-arr[i-1] < mindif){
                    minval = Math.max(minval, mincnt);
                    mincnt=1;
                    mindif = arr[i]-arr[i-1];
                }else if(arr[i]-arr[i-1] == mindif){
                    mincnt++;
                }
            }
        }
        System.out.print(minval+" ");

        int max = 0;
        int min_cnt = map.get(arr[0]) >map.get(arr[n-1]) ? map.get(arr[n-1]):map.get(arr[0]);
        System.out.print(min_cnt*(min_cnt-1));



    }
}
