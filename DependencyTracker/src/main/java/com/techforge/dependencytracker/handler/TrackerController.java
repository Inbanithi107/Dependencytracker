package com.techforge.dependencytracker.handler;

import com.techforge.dependencytracker.core.ClassPathApplicationContextScanner;
import com.techforge.dependencytracker.dto.AutowireDependencyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TrackerController {

    @Autowired
    private ClassPathApplicationContextScanner scanner;

    @GetMapping("/details")
    public List<String> getDetails(){
        scanner.scan();
        return scanner.getDefinitions().stream().map(BeanDefinition::getBeanClassName).toList();
    }

    @GetMapping("/check")
    public String get(){
        return "hello";
    }

    @GetMapping("/graph")
    public List<AutowireDependencyDTO> dependencyGraph(){
        scanner.scan();
        return scanner.getDependencyGraph();
    }

}
