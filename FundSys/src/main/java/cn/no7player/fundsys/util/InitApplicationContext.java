package cn.no7player.fundsys.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zl on 2/9/2015.
 */
public class InitApplicationContext {
    private static ApplicationContext context = null;

    private InitApplicationContext(){

    }
    public static ApplicationContext getApplicationContext(){
        if(context == null){
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
        }
        return context;
    }
}
