package protocol.http;

import framework.Invocation;
import org.apache.commons.io.IOUtils;
import provider.LocalRegister;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName HttpServerHandler
 * @Author xuwen_chen
 * @Date 2021/1/2 23:57
 * @Version 1.0
 */
public class HttpServerHandler {


    public void handler(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //处理请求，返回结果
        ServletInputStream inputStream = req.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        //这里假设接收到的都是invoke请求
        Invocation invocation = (Invocation) objectInputStream.readObject();


        //读取到服务名，根据服务名找本地服务实际提供的类
        Class<?> implClass = LocalRegister.get(invocation.getInterfaceName());

        //反射调用
        Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        String invoke = (String) method.invoke(implClass.newInstance(), invocation.getParams());
        IOUtils.write(invoke, resp.getOutputStream());
    }
}
