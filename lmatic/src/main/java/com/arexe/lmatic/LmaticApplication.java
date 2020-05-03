package com.arexe.lmatic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmaticApplication {

    private static final Logger logger = LoggerFactory.getLogger(LmaticApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LmaticApplication.class, args);
    }

}
