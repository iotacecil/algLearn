package leetcode;

public class lc476 {
    public int comp(int num){
        int mask = ~0;
        System.out.println(Integer.toBinaryString(mask));
        while ((num&mask)!=0){
            mask<<=1;
            System.out.println(Integer.toBinaryString(mask));
        }
        System.out.println(Integer.toBinaryString(~num));
        return ~num^mask;
    }

    public static void main(String[] args) {
        String two = "100010101010";
        int i = Integer.parseInt(two, 2);
        Integer valueOf = Integer.valueOf(two, 2);
        System.out.println(i);
        System.out.println(valueOf);
        System.out.println(Integer.toBinaryString(i));

        i |= (i >>  1);
        System.out.println(Integer.toBinaryString(i));
        i |= (i >>  2);
        System.out.println(Integer.toBinaryString(i));

        i |= (i >>  4);
        System.out.println(Integer.toBinaryString(i));

        i |= (i >>  8);
        System.out.println(Integer.toBinaryString(i));

        i |= (i >> 16);
        System.out.println(Integer.toBinaryString(i));

//        lc476 sl = new lc476();
//        int comp = sl.comp(5);
//        System.out.println(comp);
    }
}
