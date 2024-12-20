package com.pearus.bavilonbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BavilonBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BavilonBeApplication.class, args);
    }

}
