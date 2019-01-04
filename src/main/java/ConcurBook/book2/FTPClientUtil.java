package ConcurBook.book2;


import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
// 外部调用尽可能早调用newInstance，返回一个票据FutureTask 尽可能晚调用.get

public class FTPClientUtil {
    // 实现一个线程池
    private volatile static ThreadPoolExecutor threadPoolExecutor;
    static{
        threadPoolExecutor = new ThreadPoolExecutor(1,
                Runtime.getRuntime().availableProcessors() * 2,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }
                },new ThreadPoolExecutor.CallerRunsPolicy());
    }


    private final FtpClient ftp = FtpClient.create();
    private final Map<String,Boolean> dirCreateMap = new HashMap<>();
    private FTPClientUtil(){}
    //Promisor.compute
    public static Future<FTPClientUtil> newInstance(final String ftpServer,final String userName,final String password){
        Callable<FTPClientUtil> callable = new Callable<FTPClientUtil>() {
            @Override
            public FTPClientUtil call() throws Exception {
                FTPClientUtil self = new FTPClientUtil();
                self.init(ftpServer,userName,password);
                return self;
            }
        };
        // task 相等于promise
        final FutureTask<FTPClientUtil> task = new FutureTask<FTPClientUtil>(callable);

        // executor
        threadPoolExecutor.execute(task);
        return task;
    }

    private void init(String ftpServer,String userName,String password) throws IOException, FtpProtocolException {
        int reply;

        ftp.connect(new InetSocketAddress(ftpServer,21));
        System.out.println(ftp.getLastResponseString());
        reply = ftp.getLastReplyCode().getValue();

       ftp.setType(FtpClient.TransferType.ASCII);
    }

    public void upload(File file) throws FileNotFoundException {
        InputStream dataIn = new BufferedInputStream(new FileInputStream(file),1024*8);
        String dirName = file.getParentFile().getName();
        String fileName = dirName + "/" + file.getName();
        ByteArrayInputStream checkFileInputStream = new ByteArrayInputStream("".getBytes());
        boolean isOK;
//        try{
//
//        }

    }

    public static void main(String[] args) {
        Future<FTPClientUtil> Promise = FTPClientUtil.newInstance("111","name" , "password");

    }



}
