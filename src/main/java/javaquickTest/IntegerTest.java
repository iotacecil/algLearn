package javaquickTest;

public class IntegerTest {
    class C1{
        int a;
    }
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     //
        System.out.println(a.getClass().getClassLoader());
        int[] arr = {1,2,3,4};
        System.out.println(arr.getClass().getClassLoader());
        C1[] arr2 =new C1[2];
        // 数组的类加载器和元素的类型的类加载器是相同的
        System.out.println(arr2.getClass().getClassLoader());
    }
}
