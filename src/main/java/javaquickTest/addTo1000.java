package javaquickTest;

import java.util.concurrent.*;

class Calculator extends RecursiveTask<Integer>{

    private int start;
    private int end;

    public Calculator(int start, int end) {
        this.start = start;
        this.end = end;
    }
    private  static final int THRESHOLD =10;

    @Override
    protected Integer compute() {
        int sum =0;
        if((end-start)<THRESHOLD){
            for (int i = start; i <=end ; i++) {
                sum+=i;
            }

            }else{
            int mid = start+((end-start)>>2);
            Calculator left = new Calculator(start,mid);
            Calculator right = new Calculator(mid+1,end);
            left.fork();
            right.fork();
            sum+=left.join()+right.join();

        }
        return sum;
        }


    }

    public class addTo1000 {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            Future<Integer> reult = forkJoinPool.submit(new Calculator(1,10000));
            System.out.println(reult.get());
        }


}
