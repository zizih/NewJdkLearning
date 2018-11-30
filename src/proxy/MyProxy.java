package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: hezi.hz
 * Date: 11/28/18
 */
public class MyProxy {

    public static void main(String[] args) {
        Handler handler = (Handler) Proxy.newProxyInstance(Handler.class.getClassLoader(),
            new Class[] { Handler.class }, new ProxyHandler()); // Error: proxy.Handler is not an interface
        handler.say();
    }
}

class Handler {
    public void say() {
        System.out.println("hello");
    }
}

class ProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy say, before method invoke!");
        return method.invoke(proxy, args);
    }
}
