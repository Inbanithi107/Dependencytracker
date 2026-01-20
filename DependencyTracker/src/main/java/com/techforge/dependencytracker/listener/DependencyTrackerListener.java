package com.techforge.dependencytracker.listener;

import com.techforge.dependencytracker.annotation.ApplicationSupporter;
import com.techforge.dependencytracker.core.DependencyTrackerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.bootstrap.ConfigurableBootstrapContext;
import org.springframework.context.ConfigurableApplicationContext;

public class DependencyTrackerListener implements SpringApplicationRunListener {

    private SpringApplication application;

    public DependencyTrackerListener(SpringApplication application, String[] args){
        this.application = application;
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        if(!application.getMainApplicationClass().isAnnotationPresent(ApplicationSupporter.class)){
            return;
        }
        System.out.println("Application error occured");
        System.out.println("Dependency tracker starting the application with support");
        DependencyTrackerApplication.startApplication();
    }

}
