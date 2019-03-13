package jvmLearn;

class singleton2 {
    public static int counter1;
    public static int counter2 = 0;
    //放到下面
    private static singleton2 single1 = new singleton2();

    private static volatile singleton2 single2;
    public static singleton2 getInstance(){
        if(single2 == null){
            synchronized (singleton.class){
                if(single2 == null){
                    single2 = new singleton2();
                }
            }
        }
        return single2;
    }
    private singleton2() {
        counter1++;
        counter2++;
    }

    public static singleton2 getSingle() {
        return single1;
    }
}
public class singleton {
    private static singleton single = new singleton();
    public static  int counter1;
    public static int counter2=0;
    private singleton(){
        counter1++;
        counter2++;
    }
    public static singleton getSingle(){
        return single;
    }

    public static void main(String[] args) {

        singleton sg = singleton.getSingle();
        //1
        System.out.println(singleton.counter1);
        //0
        System.out.println(singleton.counter2);
//
        singleton2 sg2 = singleton2.getSingle();
        //1
        System.out.println(singleton2.counter1);
        //1
        System.out.println(singleton2.counter2);
        System.exit(-1);
    }

}





