package com.skotori.sunzboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SunzBootApplication {

    private final static Logger log = LoggerFactory.getLogger(SunzBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SunzBootApplication.class, args);
        log.info("SunzBootApplication started successfully!");
    }

}
