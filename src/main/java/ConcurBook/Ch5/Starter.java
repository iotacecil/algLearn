package ConcurBook.Ch5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Starter {
    public static void startIndexing(File[] roots){
        BlockingQueue<File> queue = new LinkedBlockingDeque<>(100);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };
        for(File root:roots){
            new Thread(new FileCrawler(queue,filter,root)).start();
        }

        // 消费者线程永远不会退出。

        for (int i = 0; i < 100; i++) {
            new Thread(new Indexer(queue)).start();

        }
    }

    public static void main(String[] args) {

    }
}
