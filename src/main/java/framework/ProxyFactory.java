package framework;

import api.HelloService;
import protocol.http.HttpClient;
import register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyFactory
 * @Author xuwen_chen
 * @Date 2021/1/7 0:04
 * @Version 1.0
 */

public class ProxyFactory {

    public static <T> T getProxy(final Class<T> interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient client = new HttpClient();
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(),method.getParameterTypes(),args);

                //本地缓存的远程接口注册信息
                URL url = RemoteMapRegister.get(interfaceClass.getName());

                //根据ip+port 方法名参数发起http调用
                String result = client.send(url.getHostname(), url.getPort(), invocation);
                return result;
            }
        });
    }
}
