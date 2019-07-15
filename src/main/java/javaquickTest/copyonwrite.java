package javaquickTest;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class copy implements Runnable{
//    private static List<String>list = Collections.synchronizedList(new ArrayList<>());
    public static List<String>list = new CopyOnWriteArrayList<>();
    static {
        list.add("AA" );
        list.add("BB" );
        list.add("CC" );
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            list.add("DD");
        }
    }
}
public class copyonwrite {
    public static void main(String[] args) throws InterruptedException {
        copy thread = new copy();
        for (int i = 0; i <2 ; i++) {
            Thread thread1 = new Thread(thread);
            Thread t = new Thread(){


                @Override
                public void run() {
                    super.run();
                    System.out.println("aaa");
                }
            };

            thread1.start();
            t.start();

            thread1.join();
            t.join();

        }

        System.out.println(copy.list);
    }
}
