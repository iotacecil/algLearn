package leetcode;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer>{
    private Iterator<Integer> iter;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        next = iter.next();

    }
    public Integer peek() {
        return next;

    }

    @Override
    public boolean hasNext() {
        return next!=null;
    }

    @Override
    public Integer next() {
        Integer rst = next;
        next = iter.hasNext()?iter.next():null;
        return rst;
    }
}
