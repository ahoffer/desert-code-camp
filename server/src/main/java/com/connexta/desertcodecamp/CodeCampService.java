package com.connexta.desertcodecamp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

/**
 * @Path is a JAX-RS annotation. Defines the URL path.
 * See JAX-RS URI Path Templates. The @Path("/") annotations puts the service at the "root" level.
 */
@Path("/")

/**
 *
 * Spring annotation. Means "mark class as a bean so the component-scanning mechanism of spring
 * can pick it up and pull it into the application context".
 */
@Service

public interface CodeCampService {

    //region "Hello World" with annotations

    /**
     * JAX-RS annotations tell CXF additional URI Path information, applicable HTTP verb(s)
     */
    @GET
    @Path("/hello")

    /**
     *
     * JAX-RS annotation tells CXF what MIME how resources can be represented
     *
     */
    @Produces(MediaType.TEXT_PLAIN)

    //Method to invoke and its return type
    String hello();

    //endregion

}