package com.techforge.dependencytracker.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public interface ApplicationTrackerConfiguration {

    AnnotationConfigApplicationContext getApplicationContext();

}
