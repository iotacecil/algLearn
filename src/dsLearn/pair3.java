package dsLearn;

public class pair3 {
    //从a到b的边，权值是w
    public int w,a,b;

    public pair3(int w, int a, int b) {
        this.w = w;
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "pair3{" +
                "w=" + w +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
