package com.techforge.dependencytracker.handler;

import com.techforge.dependencytracker.scanner.ResourceScanner;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class DependencyTrackerController {

    @Autowired
    private ResourceScanner scanner;

    private byte[] graphHtml;

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/dependencyTracker")
    public void serve(HttpServletResponse response) throws IOException {
            if (graphHtml == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            response.setContentType("text/html");

            response.getOutputStream().write(graphHtml);
    }

    @PostConstruct
    public void init() throws IOException {
        try(InputStream stream = scanner.getStream("graph")) {
            if(stream!=null){
                this.graphHtml = stream.readAllBytes();
            }
        }


    }

}
