package javaquickTest;
interface myinterface {
     int a  = 0;
}

public abstract class MyClass {

    public int constInt = 5;
    //普通方法一定要实现
//    public int method();
    //add code here

    //变量可以初始化或不初始化但不能初始化后在抽象类中重新赋值或操作该变量（只能在子类中改变该变量）。
//    constInt = constInt + 5;
//    抽象类中的抽象方法（加了abstract关键字的方法）不能实现。
//    public abstract void anotherMethod() {};
}
