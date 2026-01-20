package com.techforge.dependencytracker.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DependencyTrackerPropertyConfiguration {

    @Value("${com.techforge.dependencytracker.root}")
    private String rootpackage;

    @Value("${com.techforge.dependencytracker.enable}")
    private boolean enabled;

    public void setPackage(String Package){
        this.rootpackage = Package;
    }

    public String getRootpackage() {
        return rootpackage;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
