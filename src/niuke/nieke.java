package niuke;

import java.util.Arrays;

interface  inter {

}
abstract class ex{
    public void over(int x,int y){}
}
public class nieke extends ex{


    public static void main(String[] args) {
        String[] a = new String[8];
        System.out.println(Arrays.toString(a));

    }

    @Override
    public int  over(int x, int y) {
        super.over(x, y);
        return 1;
    }
}
