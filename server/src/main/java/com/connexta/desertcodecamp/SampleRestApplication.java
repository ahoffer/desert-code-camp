package com.connexta.desertcodecamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleRestApplication {

    public static void main(String[] args) {
        Database.restore();
        SpringApplication.run(SampleRestApplication.class, args);
    }
}