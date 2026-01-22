package com.techforge.dependencytracker.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DefaultApplicationTrackerConfiguration implements ApplicationTrackerConfiguration{

    @Autowired
    private DependencyTrackerPropertyConfiguration configuration;

    @Override
    public AnnotationConfigApplicationContext getApplicationContext(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan(configuration.getRootpackage());
        try {
            applicationContext.refresh();
        }catch (Exception e){
            return null;
        }
        return applicationContext;
    }

}
