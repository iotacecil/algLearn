package javaquickTest;

import java.io.IOException;

public class Test {
    private class n1{

    }
    public static void main(String[] args) throws IOException {
        int a = 1;int b = 32;
        System.out.println((a<<b)+" "+(1<<32));
//        RandomAccessFile raf = new RandomAccessFile("D:/a.txt", "rw");
//        FileChannel fc = raf.getChannel();
//// 核心 系统调用mmap
//        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
//        FileLock fl = fc.lock();//文件锁

    }
    public void method(Object o){
        System.out.println("Object");
    }
    public void method(String s){
        System.out.println("String");
    }
}