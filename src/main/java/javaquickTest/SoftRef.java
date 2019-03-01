package javaquickTest;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftRef {
    // 强引用
    String str = new String("abc");
    // 软引用
    SoftReference<String> soft = new SoftReference<>(str);


    ReferenceQueue queue = new ReferenceQueue();
    PhantomReference ref = new PhantomReference(str,queue);
    public static void main(String[] args) {

    }
}
