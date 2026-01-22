package com.techforge.dependencytracker.core;

import com.techforge.dependencytracker.initializer.DependencyTrackerInitializer;
import com.techforge.dependencytracker.supporter.ApplicationSourceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;

public class DependencyTrackerApplication {

    public static void startApplication(){

        SpringApplication application = new SpringApplication(ApplicationSourceProvider.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.addInitializers(new DependencyTrackerInitializer());
        application.run();

    }

    public static void main(String[] args){
        startApplication();
    }

}
