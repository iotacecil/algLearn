//package ConcurBook.GuardedSuspension;
//
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//import java.util.function.Predicate;
//
//public class AlarmAgent {
//    private volatile boolean connectedToServer = false;
//
//    //
//    private final Predicate agentConnected = new Predicate() {
//        @Override
//        public boolean test(Object o) {
//            return connectedToServer;
//        }
//    };
//
//    private final Blocker blocker = new ConditionVarBlocker();
//
//    // 与网络socket对接 应该等待连接建立 需要等待心跳保证连接建立
//    public void sendAlarm(String msg){}
//    public void init(){}
//}
//
//
//class GuardedAction<V>{
//
//}
//interface Blocker{
//    // 条件成立时执行 否则阻塞
//    <V> V callWithGuard(GuardedAction<V> guardedAction)throws Exception;
//
//    // 执行后唤醒一个线程
//    void signalAfter(Callable<Boolean> stateOperation)throws Exception;
//    void signal() throws InterruptedException;
//
//    // 执行后是否唤醒所有线程
//    void broadcastAfter(Callable<Boolean> stateOperation) throws Exception;
//}
//
//class ConditionVarBlocker implements Blocker{
//
//    private final Lock lock;
//    private final Condition condition;
//
//    public ConditionVarBlocker(Lock lock){
//        this.lock = lock;
//        this.condition = lock.newCondition();
//    }
//
//    public ConditionVarBlocker(){
//        this.lock = new ReentrantLock();
//        this.condition = lock.newCondition();
//    }
//
//    @Override
//    public <V> V callWithGuard(GuardedAction<V> guardedAction) throws Exception {
//        lock.lockInterruptibly();
//        V result;
//        try{
//            final Predicate guard = guardedAction.guard;
//            while(!guard.test()){
//                condition.await();
//            }
//            result = guardedAction.call();
//            return result;
//        }finally {
//            lock.unlock();
//        }
//    }
//
//    @Override
//    public void signalAfter(Callable<Boolean> stateOperation) throws Exception {
//
//    }
//
//    @Override
//    public void signal() throws InterruptedException {
//
//    }
//
//    @Override
//    public void broadcastAfter(Callable<Boolean> stateOperation) throws Exception {
//
//    }
//}