package ConcurBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());
    public boolean putIfAbsent(E x){
        // 客户端加锁
        synchronized (list){
            boolean absent = !list.contains(x);
            if(absent){
                list.add(x);
            }
            return absent;
        }
    }

}
