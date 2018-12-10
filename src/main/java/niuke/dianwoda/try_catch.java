package niuke.dianwoda;

public class try_catch {
    public static int test(){
        try{
            int i = 1/0;
            return 1;
        }catch(Exception e){
            System.out.println("执行");
            return 2;
        }finally {
            return 3;
        }
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}
