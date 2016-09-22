/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.connexta.desertcodecamp;

import static java.util.Arrays.asList;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@SpringBootApplication
public class SampleRestApplication {

    /*   The Bus is the backbone of the CXF architecture. It manages extensions and acts as an interceptor provider.
      The interceptors for the bus will be added to the respective inbound and outbound message and
      fault interceptor chains for all client and server endpoints created on the bus (in its context).
      By default, it contributes no interceptors to either of these interceptor chain types,
      but they can be added via configuration files or with Java code, as shown below.*/
    @Autowired
    private Bus bus;

    public static void main(String[] args) {
        SpringApplication.run(SampleRestApplication.class, args);
    }

    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setProvider(new JacksonJsonProvider());
        endpoint.setServiceBeans(asList(new CustomerServiceDefault()));
        endpoint.setAddress("/");
        endpoint.setFeatures(asList(new Swagger2Feature()));
        return endpoint.create();
    }
}