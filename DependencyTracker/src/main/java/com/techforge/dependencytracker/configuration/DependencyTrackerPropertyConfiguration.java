package com.techforge.dependencytracker.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "com.techforge.dependencytracker")
public class DependencyTrackerPropertyConfiguration {
    private String root;
    private boolean enabled;

    public String getRoot() {
        if(root==null){
            throw new NullPointerException("No value in the root");
        }
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
