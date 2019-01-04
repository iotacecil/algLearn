package courseBook.javaweb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CastExeption {
    public static Map m = new HashMap(){{
        put("a","2" );
    }};

    public static void main(String[] args) {
        Serializable isInt = (Serializable)m.get("a");
        System.out.println(isInt);
        CastExeption ce = new CastExeption();
        ClassLoader classLoader = ce.getClass().getClassLoader();
        System.out.println(classLoader.getClass().getName());
        ClassLoader parent = classLoader.getClass().getClassLoader().getParent();
        System.out.println(parent.getClass().getName());
        System.out.println(classLoader.getClass().getClass().getCanonicalName());
    }
}
