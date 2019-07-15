package niuke.alibaba;


public class Test {
    protected float afun(float a, float b) {
        return 0.0f;
    }

    float anofun(float a, float b) {
        return 0.0f;
    }

    public float afubn(float a, float b) {
        return 0.0f;
    }

    static class par {
        protected static float afun(float a, float b) {
            return 0.0f;
        }

        public static float bbfun(float a, float b) {
            return 0.0f;
        }

    }

    static class child extends par {

    }

    static {
        int x = 5;
    }

    static int x, y;

    public static void main(String args[]) {


        System.out.println(Runtime.getRuntime().maxMemory());

        int a = 0;
        System.out.println(a++ + ++a);

        x--;
        myMethod();
        System.out.println(x + y + ++x);
    }

    public static void myMethod() {
        y = x++ + ++x;
        System.out.println("y:" + y);
    }
}

