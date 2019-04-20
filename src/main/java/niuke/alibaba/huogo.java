package niuke.alibaba;

// M 个鱼丸 N个肉丸 分到k个碗中，鱼丸和肉丸不能混在一个碗，
// M = N = 1 k = 3只有一种，因为(1,1,0) (1,0,1) (0,1,1)是同一种
// 对1000 取mod

import java.rmi.Remote;

enum Single{
    SINGLE(1),
    Two();
    int a ;
    Single(){}
    private Single(int  a){
        this.a = a;
    }
}

class c1 implements Remote{

}
abstract class c2 extends c1{
    abstract int add();
}
public class huogo {


    public static void main(String[] args) {
        Single single = Single.SINGLE;
        Single Two = Single.Two;
        System.out.println(single.a);
        System.out.println(Two.a);

    }
}
