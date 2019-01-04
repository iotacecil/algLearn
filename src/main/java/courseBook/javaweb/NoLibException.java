package courseBook.javaweb;
//java.lang.UnsatisfiedLinkError: no NoLib in java.library.path

public class NoLibException {
    public native void nativeMethod();
    static{
        System.loadLibrary("NoLib");
    }

    public static void main(String[] args) {
        new NoLibException().nativeMethod();
    }
}
