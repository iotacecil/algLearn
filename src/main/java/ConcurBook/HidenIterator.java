package ConcurBook;

import java.util.*;

public class HidenIterator {
    //用普通的set可能会报错
//    private  final Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
    private final Set<Integer> set = new HashSet<>();
    public synchronized void add(Integer i){
        set.add(i);
    }
    public synchronized void remove(Integer i){
        set.remove(i);
    }
    public void addThenThings(){
        // 报错的是这句 隐含的迭代器
        System.out.println("之前"+set);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            add(r.nextInt()%10);
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println("为什么不报错"+set);

    }

    public static void main(String[] args) {
        HidenIterator hid = new HidenIterator();
        hid.addThenThings();
        System.out.println(hid.set);
        new Thread(hid::addThenThings).start();
        new Thread(hid::addThenThings).start();
    }
}
