package consumer;

import framework.ProxyFactory;
import api.HelloService;//practice admin practice
import protocol.http.DispatcherServlet;

import java.io.IOException;

/**
 * @ClassName
 * @Author xuwen_chen
 * @Date 2021/1/3 0:34
 * @Version 1.0
 */

public class Consumer {
    public static void main(String[] args) throws IOException {

         //动态代理helloService代口，实现上底层发起了rpc远程调用
        HelloService proxy = ProxyFactory.getProxy(HelloService.class);

        String result = proxy.sayHello("cxw");

        System.out.println(result);
    }
}
