package com.techforge.dependencytracker.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DependencyTrackerPropertyConfiguration.class)
public class PropertyBindingConfiguration {
}
