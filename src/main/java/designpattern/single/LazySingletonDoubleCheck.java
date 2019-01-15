package designpattern.single;

public class LazySingletonDoubleCheck {

    // 用volatile可以禁止2，3重排序 用缓存一致性协议
    public volatile static LazySingletonDoubleCheck instance = null;

    private LazySingletonDoubleCheck() {
    }

    public  static LazySingletonDoubleCheck getInstance(){
        if(instance == null){
            synchronized (LazySingletonDoubleCheck.class){
                if(instance == null){
                    instance = new LazySingletonDoubleCheck();
                    // new其实包括3步
                    // 1 分配内存
                    // 2 初始化对象
                    // 3 将那块内存空间 赋值给instance
                    // 对于单线程 2，3互换不会改变执行结果，所以多线程里可以重排序
                    // 多线程 第一个线程先3 instance有了内存空间不是null 但还没初始化
                    //       第二个线程访问并返回

                }
            }
        }
        return instance;
    }
}
