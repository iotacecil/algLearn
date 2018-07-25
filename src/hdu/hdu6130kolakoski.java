package hdu;

import java.util.*;
//不知道为什么的wrong answer
//1 2,2 11 ,2
//cnt = 1, 2,next = 2

public class hdu6130kolakoski {
/*
1 22  11 2 1
1  2  2  1 1
 */

    public static void main(String[] args) {

        List<Integer> kola = new ArrayList<>();

        kola.add(1);
        kola.add(2);
        kola.add(2);
        kola.add(1);
        kola.add(1);

        Scanner sc = new Scanner(System.in);
        int batch = sc.nextInt();
        while(batch-->0) {
            int x = sc.nextInt();
            List<Integer> kola_list = new ArrayList<>();
            //index = 4,flag =1 ,group_next_index=3;
            int index = 4;
            int flag = kola.get(index);

            int group_next_index = 3;
            //1
            while (index < x+1  ) {

                int gnum = kola.get(group_next_index);
                for (int i = 1; i <= gnum; i++) {
                    index++;
                    if (flag == 1) {
                        kola.add( 2);
                    } else {
                        kola.add( 1);

                    }
                    //到了一组最后一个
                    if (i == gnum) {
                        group_next_index++;

                        flag = kola.get(index);
                    }
                }
                gnum = kola.get(group_next_index);

            }
            System.out.println(kola.get(x-1));

        }


        //试一下hash
//        System.out.println(Integer.toBinaryString((65535<<1)+1));
//        System.out.println(Integer.toBinaryString((65535<<1)>>>16));
//        int a = (65535<<2)+1;
//        System.out.println(a+" "+Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(a>>>16));
//        int hash=a^(a>>>16);
//        int index = (32-1)&hash;
//        System.out.println(Integer.toBinaryString(hash));
//        System.out.println(Integer.toBinaryString(31));
//        System.out.println("-------------");
//        System.out.println(Integer.toBinaryString(index));
//        System.out.println(hash+" "+index);
    }
}
