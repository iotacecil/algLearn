package leetcode;

class test{
//    private test t = new test();

    {
        System.out.println("dlma");
    }
    static{
        System.out.println("static");
    }
    public test(){
        System.out.println("gouzao");
    }
}

class T extends Thread{
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class lc330 {
    public int minPatches(int[] nums, int n) {
        int miss = 1;
        int len = nums.length;
        int idx = 0;
        int cnt = 0;

        while(miss <= n){
            //如果可以
            if(idx < len && nums[idx] <= miss){
                miss++;
                idx++;
            }else if(nums[idx] > miss){
                cnt++;
                miss+=miss;
            }
        }
        return cnt;
    }
    static int f(int x){
        int y = 0;
        if(x == 1) y = 2;
        else y = x/2+f(x-1);
        return y;
    }
    public static void main(String[] args) {
//        System.out.println(f(6));
//        new test();
//        byte b = 12;
////        float f = 12.4;
//int i = 'x';
        T t1 = new T();
        T t2 = new T();
        t1.start();
        System.out.println(Thread.activeCount());
        t2.start();


    }
}
