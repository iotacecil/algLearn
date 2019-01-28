package javaquickTest;

import java.util.Iterator;
import java.util.PriorityQueue;

public class quick {
//    class test implements Callable<Integer> {
//        final long start;
//        int  i =0;
//        public test(){
//            start= System.currentTimeMillis();
//        }
//        public void run{
//            while (true){
//                i++;
//                if(System.currentTimeMillis() - start >300)
//            }
//            try{
//
//            }
//        }
//
//        @Override
//        public Integer call() throws Exception {
//            return 0;
//        }
//    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 9; i >=0 ; i--) {
            pq.add(i);
        }
        Iterator<Integer> iterator = pq.iterator();
        while (pq.iterator().hasNext()){
            System.out.println(iterator.next());

        }
//        for(int i:pq){
//            System.out.println(i);
//        }
    }
}
