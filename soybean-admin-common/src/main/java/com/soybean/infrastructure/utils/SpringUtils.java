package com.soybean.infrastructure.utils;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

public class SpringUtils extends SpringUtil {
    /**
     * 根据对象返回类名
     */
    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return getBeanFactory().getType(name);
    }

    /**
     * 根据类返回对象
     */
    public static <T> T getBean(Class<T> clazz) throws NoSuchBeanDefinitionException {
        return getBeanFactory().getBean(clazz);
    }

    /**
     * 获取Spring上下文
     */
    public static ApplicationContext getContext() {
        return getApplicationContext();
    }

    /**
     * 判断对象是否为单例
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException{
        return getBeanFactory().isSingleton(name);
    }

    /**
     * 判断对象是否存在于BeanFactory中
     */
    public static boolean contains(String name) throws NoSuchBeanDefinitionException{
        return getBeanFactory().containsBean(name);
    }
}
