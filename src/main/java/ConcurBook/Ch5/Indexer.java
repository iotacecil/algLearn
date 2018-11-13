package ConcurBook.Ch5;

import java.io.File;
import java.util.concurrent.BlockingQueue;

// 消费者 取出文件名并建立索引
public class Indexer implements Runnable{
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
                indexFile(queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(File file) {
    }
}
