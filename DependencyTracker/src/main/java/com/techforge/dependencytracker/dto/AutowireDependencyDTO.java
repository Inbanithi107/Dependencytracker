package com.techforge.dependencytracker.dto;

import java.util.List;

public class AutowireDependencyDTO {

    private String name;

    private List<Class<?>> dependencies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Class<?>> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Class<?>> dependencies) {
        this.dependencies = dependencies;
    }

    public AutowireDependencyDTO(String name, List<Class<?>> dependencies) {
        this.name = name;
        this.dependencies = dependencies;
    }
}
