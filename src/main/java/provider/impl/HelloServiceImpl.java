package provider.impl;

import api.HelloService;

/**
 * provider中对RPC接口的实现
 * @ClassName HelloServiceImpl
 * @Author xuwen_chen
 * @Date 2021/1/3 0:12
 * @Version 1.0
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("provider..");
       return "hello "+ name;
    }
}
