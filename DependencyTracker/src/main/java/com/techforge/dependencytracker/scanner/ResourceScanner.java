package com.techforge.dependencytracker.scanner;

import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ResourceScanner {

    private ClassLoader loader;

    public ResourceScanner(){
        this.loader = getClass().getClassLoader();
    }

    public InputStream getStream(String filename){

        return loader.getResourceAsStream("META-INF/resources/dependency-tracker-ui/browser/" + filename + ".html");

    }

}
