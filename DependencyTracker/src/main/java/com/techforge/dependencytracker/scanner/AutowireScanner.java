package com.techforge.dependencytracker.scanner;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AutowireScanner {

    private DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    private AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();

    public List<Class<?>> getDependents(BeanDefinition definition) throws ClassNotFoundException {

        Class<?> clazz = Class.forName(definition.getBeanClassName());

        List<Class<?>> dependency = new ArrayList<>();

        for (Constructor<?> ctor : clazz.getDeclaredConstructors()) {
            if (ctor.isAnnotationPresent(Autowired.class) || ctor.getParameterCount() == 1) {
                dependency.addAll(Arrays.asList(ctor.getParameterTypes()));
            }
        }

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                dependency.add(field.getType());
            }
        }

        return dependency;

    }

    @PostConstruct
    public void init(){
        beanPostProcessor.setBeanFactory(beanFactory);
    }

}
