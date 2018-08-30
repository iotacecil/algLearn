package javaquickTest.lambdaStream;

import java.text.DecimalFormat;
import java.util.function.Function;

@FunctionalInterface
interface interface1{
    int doubleNum(int i);
    default int add(int x,int y){
        return x+y;
    }
}

interface IMoneyFormat{
    String format(int i);
}
class MyMoney{
    private final int money;
    public MyMoney(int money){
        this.money = money;
    }
    public void printMoney(IMoneyFormat moneyFormat){
        System.out.println("存款："+moneyFormat.format(this.money));
    }
    public void printMoneyJDK8(Function<Integer,String> moneyFormat){
        System.out.println("存款："+moneyFormat.apply(this.money));
    }
}
public class lambdaLearn2 {
    public static void main(String[] args) {
        MyMoney me = new MyMoney(99999);
        me.printMoney(i->new DecimalFormat("#,###").format(i));
        me.printMoneyJDK8(i->new DecimalFormat("#,###").format(i));
       Function<Integer,String> moneyFormat = i->new DecimalFormat("#,###").format(i);
       me.printMoneyJDK8(moneyFormat.andThen(s->"RMB"+s));
        interface1 i1 = (i)->i*2;
        interface1 i2 = i->i*2;

        interface1 i3 = (int i)->i*2;
        interface1 i4 = (int i)->{return i*2;};
        System.out.println(i4.add(1, 2));

    }
}
