package provider;

import framework.URL;
import protocol.http.HttpServer;
import api.HelloService;
import provider.impl.HelloServiceImpl;
import register.RemoteMapRegister;

/**
 * @ClassName Provider
 * @Author xuwen_chen
 * @Date 2021/1/3 0:02
 * @Version 1.0
 *
 * 服务导出过程：
 * 1）本地注册：完成服务口名和实现类的映射
 * 2) 远程注册：将本地服务名对应ip port信息注册到注册中心
 * 3) 暴露服务：任意一个可以接收外部invoke调用的容器，这里用tomcat实现
 */
public class Provider {

    public static void main(String[] args) {
        //1.本地注册
        //服务名：实现类
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        //2.远程注册
        //服务名：List
        URL url = new URL("localhost",8080);
        RemoteMapRegister.register(HelloService.class.getName(), url);

        //3.启动tomcat(暴露服务)
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",8080);
    }


}
