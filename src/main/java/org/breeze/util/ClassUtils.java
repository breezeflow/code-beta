package org.breeze.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {

    /**
     * 通过接口获取所有的实现类
     * @param clazz
     * @return
     */
    public static List<Class> getAllClassByInterface(Class clazz){

        List<Class> result = new ArrayList<>();

        //如果不是一个接口，则不做处理
        if(clazz.isInterface()){
            String packageName = clazz.getPackage().getName(); //获得当前的包名
            try {
                List<Class> allClass = getClasses(packageName); //获得当前包下以及子包下的所有类

                //判断是否是同一个接口
                for(int i=0;i<allClass.size();i++){
                    if(clazz.isAssignableFrom(allClass.get(i))){ //判断是不是一个接口
                        if(!clazz.equals(allClass.get(i))){ //本身不加进去
                            result.add(allClass.get(i));
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    //获取包 及 子包 下所有的 类
    private static List<Class> getClasses(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".","/");
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName)
            throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." +
                        file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' +
                        file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

}
