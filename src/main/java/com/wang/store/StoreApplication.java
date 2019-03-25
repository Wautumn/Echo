package com.wang.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StoreApplication  extends SpringBootServletInitializer {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "hello,bookstore!";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StoreApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

}
