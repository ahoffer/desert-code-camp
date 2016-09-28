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

@Configuration
public class RestApplicationConfiguration {
    /* he Bus is the backbone of the CXF architecture. It manages extensions and acts as an interceptor provider.
      The interceptors for the bus will be added to the respective inbound and outbound message and
      fault interceptor chains for all client and server endpoints created on the bus (in its context).
      By default, it contributes no interceptors to either of these interceptor chain types,
      but they can be added via configuration files or with Java code, as shown below.
    */
    @Autowired
    private Bus bus;

    @Bean
    public Server codeCampServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setServiceBeans(asList(new CodeCampServiceDefault()));
        endpoint.setAddress("/");
        //region Add swagger
        endpoint.setFeatures(asList(new Swagger2Feature()));
        //endregion
        //region Add JSON
        endpoint.setProvider(new JacksonJsonProvider());
        //endregion
        return endpoint.create();
    }
}
