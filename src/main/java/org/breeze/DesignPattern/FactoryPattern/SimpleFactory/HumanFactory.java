package org.breeze.DesignPattern.FactoryPattern.SimpleFactory;


import org.breeze.DesignPattern.FactoryPattern.Human;
import org.breeze.util.ClassUtils;

import java.util.List;
import java.util.Random;

/**
 * 简单工厂方法：省去if else  改用反射
 */
public class HumanFactory {

    public static Human createHuman(Class clazz){
        Human human = null;
        try{
            human = (Human) Class.forName(clazz.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("create human error ....");
        }
        return human;
    }

    public static Human createHuman(){
        Human human=null;
        List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class);
        Random random = new Random();
        //随机获取对象，也可以自己指定
        int rand = random.nextInt(concreteHumanList.size());
        human = createHuman(concreteHumanList.get(rand));
        return human;
    }

}
