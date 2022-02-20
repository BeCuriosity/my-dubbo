package register;

import framework.URL;

import java.io.*;
import java.util.*;

/**
 * @ClassName RemoteMapRegister
 * @Author xuwen_chen
 * @Date 2021/1/3 0:16
 * @Version 1.0
 */

public class RemoteMapRegister {
    private static Map<String, List<URL>> map = new HashMap<>();

    public static void register(String interfaceName,URL url){
        List<URL> list = map.get(interfaceName);
        if (list == null) {
            List<URL> urls = new ArrayList<>();
            urls.add(url);
            map.put(interfaceName,urls);
        }else {
            list.add(url);
        }
        saveFile();
    }

    private static void saveFile() {
        //写入本地硬盘
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\temp.txt",false));
            oos.writeObject(map);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static URL get(String interfaceName){
        readFile();
        List<URL> list = map.get(interfaceName);
        return list.get(0);
    }

    private static void readFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\temp.txt"));
            Object o = ois.readObject();
            if(o instanceof Map){
                map = (Map<String, List<URL>>) o;
                System.out.println("反序列化成功");
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
