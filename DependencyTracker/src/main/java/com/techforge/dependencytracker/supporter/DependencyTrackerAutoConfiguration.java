package com.techforge.dependencytracker.supporter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;

@ConditionalOnProperty("com.techforge.dependencytracker.enabled")
@ComponentScan(basePackages = "com.techforge.dependencytracker")
public class DependencyTrackerAutoConfiguration {
}
