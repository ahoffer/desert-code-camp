package com.connexta.desertcodecamp;

import io.swagger.annotations.Api;

// Annotation tells Swagger this class implements services
@Api("/codecamp")

public class CodeCampServiceDefault implements CodeCampService {

    public String hello() {
        System.out.println("-----Invoking Hello World service");
        return "Hello World!";
    }

}