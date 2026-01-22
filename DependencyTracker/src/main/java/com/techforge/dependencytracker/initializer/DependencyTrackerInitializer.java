package com.techforge.dependencytracker.initializer;

import org.springframework.boot.tomcat.servlet.TomcatServletWebServerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DependencyTrackerInitializer implements ApplicationContextInitializer<GenericApplicationContext> {

    @Override
    public void initialize(GenericApplicationContext applicationContext) {
        applicationContext.registerBean(TomcatServletWebServerFactory.class);
        applicationContext.registerBean(DispatcherServlet.class);
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(applicationContext);
        scanner.scan("com.techforge.dependencytracker");
    }
}
