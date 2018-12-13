package courseBook.hadoopbook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface CalculatorProtocol{
    public int add(int a,int b);
    public int subract(int a,int b);
}

class Server implements CalculatorProtocol{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subract(int a, int b) {
        return a-b;
    }
}
class CalculatorHandler implements InvocationHandler{
    private Object objOriginal;

    public CalculatorHandler(Object objOriginal) {
        this.objOriginal = objOriginal;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //预处理
        Object result = method.invoke(this.objOriginal,args);
        //后续
        return result;
    }
}
public class DynamicProxyExample {

    public static void main(String[] args) {
        CalculatorProtocol server = new Server();
        CalculatorHandler handler = new CalculatorHandler(server);
        CalculatorProtocol client = (CalculatorProtocol) Proxy.newProxyInstance(server.getClass().getClassLoader(), server.getClass().getInterfaces(), handler);
        int r = client.add(5, 3);
    }
}
