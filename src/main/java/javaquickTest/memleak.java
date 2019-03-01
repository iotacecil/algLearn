package javaquickTest;

public class memleak {
    public memleak childNode;
}

class problem{
    public static void main(String[] args) {
        memleak o1 = new memleak();
        memleak o2 = new memleak();
        // 循环引用
        o1.childNode = o2;
        o2.childNode = o1;
    }
}
