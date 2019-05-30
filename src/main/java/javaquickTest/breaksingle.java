package javaquickTest;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class breaksingle implements Serializable,Cloneable {
    private final static breaksingle instance;
    static {
        instance = new breaksingle();
    }
    private breaksingle(){
        if(instance != null){
            throw new RuntimeException("单利模式禁止反射调用");
        }
    }
    public static breaksingle getInstance(){
        return instance;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private Object readResolve(){
        return instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        breaksingle ins = breaksingle.instance;
        Method method = ins.getClass().getDeclaredMethod("clone");
        System.out.println(Arrays.toString(ins.getClass().getDeclaredConstructors()));
        Constructor<? extends breaksingle> declaredConstructor = ins.getClass().getDeclaredConstructor();
//       declaredConstructor.setAccessible(true);
        breaksingle breaksingle = declaredConstructor.newInstance(null);
        System.out.println(breaksingle);

        method.setAccessible(true);
        breaksingle sin = (breaksingle) method.invoke(ins);
        System.out.println(sin);
        System.out.println(ins);

    }


}
