package com.connexta.desertcodecamp;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.service.factory.ServiceConstructionException;

public class Server {

    Server() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(CustomerService.class);
        sf.setResourceProvider(CustomerService.class,
                new SingletonResourceProvider(new CustomerService()));
        sf.setAddress("http://localhost:9000/");
        sf.setProvider(new JacksonJsonProvider());

        try {
            sf.create();
        } catch (ServiceConstructionException e) {
            System.err.println("\n" +
                    "░█▀▀ ░█▀█ ░█ ░█▀▀ ░░█▀▀ ░█▀█ ░█ ░█\n" +
                    "░█▀▀ ░█▀▀ ░█ ░█ ░░░░█▀▀ ░█▀█ ░█ ░█\n" +
                    "░▀▀▀ ░▀ ░░░▀ ░▀▀▀ ░░▀ ░░░▀░▀ ░▀ ░▀▀▀");
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Server ready...");
    }

    public static void main(String args[]) throws Exception {
        new Server();

//        Thread.sleep(5 * 6000 * 1000);
//        System.out.println("Server exiting");
//        System.exit(0);
    }
}