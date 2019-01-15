package designpattern.single;

public class LazySinglenton {
    public static LazySinglenton instance = null;

    private LazySinglenton() {
    }
    //锁了整个1 class
    public synchronized static LazySinglenton getInstance(){
        if(instance == null)
        instance = new LazySinglenton();
        return instance;
    }
}
