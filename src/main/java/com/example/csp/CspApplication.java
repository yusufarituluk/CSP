package com.example.csp;

import com.example.csp.problem.TimeScheduleProblem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CspApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CspApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CspApplication.class, args);
    }

    @Bean
    public TimeScheduleProblem getCSP() { return new TimeScheduleProblem(); }
}
