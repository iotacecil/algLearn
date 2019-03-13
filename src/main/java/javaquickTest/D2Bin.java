package javaquickTest;

public class D2Bin {
//2->10
    public String D2Bin(int de){
        StringBuilder sb = new StringBuilder();
        while (de != 0){
            sb.insert(0,de&1);
            de >>>= 1;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int a = 1;
        int b = -1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        D2Bin sl = new D2Bin();
        System.out.println(sl.D2Bin(a));
        System.out.println(sl.D2Bin(b));
    }
}
