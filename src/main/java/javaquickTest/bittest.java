package javaquickTest;

public class bittest {
    public static void main(String[] args) {
        System.out.println(0b10);
        System.out.println(011);
        int num = Integer.parseInt("0001010101", 2);
        System.out.println(num);
        int i = ~num & ((Integer.highestOneBit(num) << 1) - 1);
        int idx = 0;
        System.out.println((num>>7)&((2<<29)-1));
        System.out.println(Integer.toBinaryString((num>>6)));
        System.out.println(Integer.toBinaryString(((2<<29)-1)));
        while (((num>>idx)&((2<<29)-1))!=0){
            //
          //  System.out.println(Integer.toBinaryString(((num>>idx++)&((2<<29)-1))));
            if(((num>>idx)&1)!=0){
                System.out.println("输出");
                System.out.println(idx);

            }

            idx++;

        }
        System.out.println(i);
    }
}
