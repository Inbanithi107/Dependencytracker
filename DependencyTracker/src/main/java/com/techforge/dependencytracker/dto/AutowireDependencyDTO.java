package com.techforge.dependencytracker.dto;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

public class AutowireDependencyDTO {

    private String name;

    private List<String> annotations;

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

    public List<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<String> annotations) {
        this.annotations = annotations;
    }

    public AutowireDependencyDTO(String name, List<Class<?>> dependencies) {
        this.name = name;
        this.dependencies = dependencies;
        try {
            this.annotations = Arrays.stream(Class.forName(name).getDeclaredAnnotations()).map(Annotation::toString).toList();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
