package provider;

import java.util.HashMap;
import java.util.Map;

/**
 * 本地注册  接口名称 -> 接口实现  映射关系
 * @ClassName LocalRegister
 * @Author xuwen_chen
 * @Date 2021/1/3 0:05
 * @Version 1.0
 */
public class LocalRegister {

    private static Map<String, Class<?>> map = new HashMap<>();

    public static void register(String interfaceName, Class<?> implClass){
        map.put(interfaceName, implClass);
    }

    public static  Class<?> get(String interfaceName){
        return map.get(interfaceName);
    }

}
