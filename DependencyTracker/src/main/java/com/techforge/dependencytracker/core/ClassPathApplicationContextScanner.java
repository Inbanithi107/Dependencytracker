package com.techforge.dependencytracker.core;

import com.techforge.dependencytracker.configuration.DependencyTrackerPropertyConfiguration;
import com.techforge.dependencytracker.dto.AutowireDependencyDTO;
import com.techforge.dependencytracker.scanner.AutowireScanner;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ClassPathApplicationContextScanner implements ClassPathContextConfiguration{


    private final DependencyTrackerPropertyConfiguration configuration;

    private final AutowireScanner autowireScanner;

    private FilterConfiguration filters;

    public ClassPathApplicationContextScanner(DependencyTrackerPropertyConfiguration config, AutowireScanner scanner){
        this.configuration=config;
        this.autowireScanner=scanner;
    }

    private Set<BeanDefinition> definitions;


    @Override
    public void scan() {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        for (var types : filters.getFilters()){
            scanner.addIncludeFilter(types);
        }
        definitions = scanner.findCandidateComponents(configuration.getRootpackage());
    }

    @Override
    public Set<Class<?>> getDefinedClasses() {
        return Set.of();
    }

    @Override
    public List<AutowireDependencyDTO> getDependencyGraph() {
        List<AutowireDependencyDTO> graph = new ArrayList<>();
        for(BeanDefinition definition : definitions){
            try {
                graph.add(new AutowireDependencyDTO(definition.getBeanClassName(), autowireScanner.getDependents(definition)));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return graph;
    }

    public Set<BeanDefinition> getDefinitions(){
        return this.definitions;
    }

    @PostConstruct
    public void init(){
        filters = new Filters();
        filters.defaultFilters();
    }
}
