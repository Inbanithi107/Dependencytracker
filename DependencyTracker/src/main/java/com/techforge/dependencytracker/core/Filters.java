package com.techforge.dependencytracker.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

public final class Filters extends FilterConfiguration {

    @Override
    void defaultFilters() {
        addFilter(Component.class);
        addFilter(Service.class);
        addFilter(Configuration.class);
        addFilter(Controller.class);
        addFilter(RestController.class);
    }



}
