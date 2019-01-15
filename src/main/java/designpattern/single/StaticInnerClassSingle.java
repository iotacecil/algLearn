package designpattern.single;

public class StaticInnerClassSingle {
    private StaticInnerClassSingle(){
    }
    // jvm会加初始化索 同步多个线程对一个class的初始化
    // 类初始化 哪个线程先拿到innerclass的初始化锁
    private static class InnerClass{
        private static StaticInnerClassSingle instance = new StaticInnerClassSingle();
    }
    public static StaticInnerClassSingle getInstance(){
        return InnerClass.instance;
    }
}
