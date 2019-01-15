package designpattern.single;

import java.io.*;

public class SeriesTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(instance);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hungrysigle"));
        oos.writeObject(instance);
        File file = new File("hungrysigle");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HungrySingleton newinstance = ((HungrySingleton) ois.readObject());
        System.out.println(newinstance);
    }
}
