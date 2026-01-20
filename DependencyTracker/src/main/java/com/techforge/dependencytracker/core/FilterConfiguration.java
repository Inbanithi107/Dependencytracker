package com.techforge.dependencytracker.core;

import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public abstract class FilterConfiguration {

    static List<AnnotationTypeFilter> filters = new ArrayList<>();

    static void addFilter(Class<? extends Annotation> clazz){
        filters.add(new AnnotationTypeFilter(clazz));
    }

    List<AnnotationTypeFilter> getFilters(){
        return filters;
    }

    static void resetFilters(){
        filters.clear();
    }

    abstract void defaultFilters();

}
