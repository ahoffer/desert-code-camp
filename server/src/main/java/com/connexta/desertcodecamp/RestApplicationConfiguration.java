package com.connexta.desertcodecamp;

import static java.util.Arrays.asList;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

//Spring annotation is equivalent of XML's <beans/> element. Like <beans/> and it provides an
// opportunity to explicitly set defaults for all enclosed bean definitions.
@Configuration

public class RestApplicationConfiguration {
    /*
      The Bus is the backbone of the CXF architecture. It manages extensions and acts as an interceptor provider.
      The interceptors for the bus will be added to the respective inbound and outbound message and
      fault interceptor chains for all client and server endpoints created on the bus (in its context).
      By default, it contributes no interceptors to either of these interceptor chain types,
      but they can be added via configuration files or with Java code, as shown below.
    */
    @Autowired
    private Bus bus;

    @Bean
    public Server codeCampServer() {

        // Create the REST Server. Start by getting a factor.
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();

        endpoint.setBus(bus);

        // Tell the server who is providing the services
        endpoint.setServiceBeans(asList(new CodeCampServiceDefault()));

        // Set the endpoint. Forget this and get a Null Pointer Exception when you build.
        endpoint.setAddress("/");

        // Install Swagger to get API documentation
        // The URL http://localhost:8080/services will provide a link to the Swagger page
        endpoint.setFeatures(asList(new Swagger2Feature()));

        /**
         *
         * RESTful resources can be represented many ways. XML and JSON are both population
         * representations. CXF comes with JAXB at the ready for XML serialization of
         * Java objects. We add a new entity provider that will serialize Java objects
         * as JSON.
         *
         */
        endpoint.setProvider(new JacksonJsonProvider());

        //Finally, create the actual server from the server factory.
        return endpoint.create();
    }
}
