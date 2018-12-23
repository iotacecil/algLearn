package javaquickTest;

import java.io.IOException;
import java.io.RandomAccessFile;

public class file10 {

    public static void main(String[] args) throws IOException {
        String file = "D:\\algLearn\\src\\main\\java\\javaquickTest\\file.dat";
//        FileInputStream in=new FileInputStream("file.dat"); in.skip(9); int c=in.read();

//        FileInputStream in=new FileInputStream("file.dat"); in.skip(10); int c=in.read();

//        FileInputStream in=new FileInputStream("file.dat"); int c=in.read();

        RandomAccessFile in = new RandomAccessFile(file, "r");
        in.skipBytes(9);
        int c = in.readByte();
        System.out.println((char)c);
    }
}
