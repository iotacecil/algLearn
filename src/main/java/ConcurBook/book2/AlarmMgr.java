//package ConcurBook.book2;
//
//import ConcurBook.GuardedSuspension.AlarmAgent;
//
//import java.lang.ref.WeakReference;
//import java.util.Queue;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class AlarmMgr {
//    private static final AlarmMgr INSTANCE = new AlarmMgr();
//    private volatile boolean shutdownRequested = false;
//    // 发送线程
//    private final AlarmSendingThread alarmSendingThread;
//
//    private AlarmMgr(){
//        alarmSendingThread = new AlarmSendingThread();
//    }
//
//    public static AlarmMgr getInstance(){
//        return INSTANCE;
//    }
//
//    // 输入：类型，编号，参数。
//    // 返回：count = -1表示已经关闭
//    public int sendAlarm(String type,String id,String extraInfo){
//        int duplicatedSubmissionCount = 0;
//        try{
//            duplicatedSubmissionCount = alarmSendingThread.sendAlarm("info");
//        }catch(Throwable t){
//            t.printStackTrace();
//        }
//        return duplicatedSubmissionCount;
//    }
//
//    public void init(){
//        alarmSendingThread.start();
//    }
//
//    public synchronized void shutdown(){
//        if(shutdownRequested){
//            throw new IllegalStateException("已经请求关闭了");
//        }
//
//        alarmSendingThread.terminate();
//        shutdownRequested = true;
//    }
//}
//
//interface Terminatable{
//
//}
//
//abstract class AbstractTerminatableThread extends Thread implements Terminatable{
//    public final TerminationToken terminationToken;
//
//    public AbstractTerminatableThread(){
//        this(new TerminationToken());
//    }
//    public AbstractTerminatableThread(TerminationToken terminationToken){
//        super();
//        this.terminationToken = terminationToken;
//        terminationToken.register(this);
//    }
//
//
//}
//
//class TerminationToken{
//    protected volatile boolean toShutdown = false;
//    final AtomicInteger reservations = new AtomicInteger(0);
//    //?
//    private final Queue<WeakReference<Terminatable>> coordinatedThreads;
//
//    public TerminationToken(){
//        coordinatedThreads = new ConcurrentLinkedDeque<>();
//    }
//
//    protected void register(Terminatable thread){
//
//    }
//
//}
//
//class AlarmSendingThread extends AbstractTerminatableThread{
//    private final AlarmAgent alarmAgent = new AlarmAgent();
//
//    private final BlockingQueue<String> alarmQueue;
//    private final ConcurrentMap<String,AtomicInteger> submittedAlarmRegistry;
//
//
//
//
//    public AlarmSendingThread() {
//        this.alarmQueue = new ArrayBlockingQueue<>(100);
//        this.submittedAlarmRegistry = new ConcurrentHashMap<>();
//        alarmAgent.init();
//    }
//
//    protected void doRun() throws InterruptedException {
//        String alarminfo;
//        alarminfo = alarmQueue.take();
//        terminationToken.reservations.decrementAndGet();
//        try{
//            alarmAgent.sendAlarm(alarminfo);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public AlarmSendingThread(TerminationToken terminationToken, BlockingQueue<String> alarmQueue, ConcurrentMap<String, AtomicInteger> submittedAlarmRegistry) {
//        super(terminationToken);
//        this.alarmQueue = alarmQueue;
//        this.submittedAlarmRegistry = submittedAlarmRegistry;
//    }
//}
