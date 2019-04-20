package javaquickTest;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Test {
    private class n1{

    }
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("D:/a.txt", "rw");
        FileChannel fc = raf.getChannel();
// 核心 系统调用mmap
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        FileLock fl = fc.lock();//文件锁

    }
    public void method(Object o){
        System.out.println("Object");
    }
    public void method(String s){
        System.out.println("String");
    }
}