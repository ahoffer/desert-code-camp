package com.connexta.desertcodecamp;

import io.swagger.annotations.Api;

/**
 * @Api annotation tells Swagger this class implements services and names it.
 */
@Api("CODECAMP")
public class CodeCampServiceDefault implements CodeCampService {

    public String hello() {
        System.out.println("-----Invoking Hello World service");
        return "Hello World!";
    }

}