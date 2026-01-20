package com.techforge.dependencytracker.core;

import com.techforge.dependencytracker.dto.AutowireDependencyDTO;

import java.util.List;
import java.util.Set;

public interface ClassPathContextConfiguration {

    void scan();

    Set<Class<?>> getDefinedClasses();

    List<AutowireDependencyDTO> getDependencyGraph();

}
