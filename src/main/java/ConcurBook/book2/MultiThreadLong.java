package ConcurBook.book2;

public class MultiThreadLong {
    public static long t = 0;


    public static class ChangeT implements Runnable{
        private long to;
        public ChangeT(long to){
            this.to = to;
        }
        @Override
        public void run(){
            while (true){
                MultiThreadLong.t = to;
                Thread.yield();
            }
        }
    }

    public static class ReadT implements Runnable{

        @Override
        public void run() {
            while (true){
                long tmp = MultiThreadLong.t;
                if(tmp!=111L && tmp!=-999L && tmp!=333L && tmp!=-444L){
                    System.out.println(tmp);
                }
//                System.out.println(tmp);
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-999));
        System.out.println(Integer.toBinaryString(-999>>2));
        System.out.println(Integer.toBinaryString(-999>>>2));
        System.out.println(-999>>>2);
        System.out.println(Integer.parseInt("00111111111111111111111100000110",2));
        System.out.println(Integer.bitCount(-999));
        new Thread(new ChangeT(111L)).start();
        new Thread(new ChangeT(-999L)).start();
        new Thread(new ChangeT(333L)).start();
        new Thread(new ChangeT(-444L)).start();
        // 可能读到任何一个值 应该没有任何输出 如果32位虚拟机会出现奇怪的数字
        new Thread(new ReadT()).start();

    }
}
