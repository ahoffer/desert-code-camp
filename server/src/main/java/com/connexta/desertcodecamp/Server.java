package com.connexta.desertcodecamp;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.service.factory.ServiceConstructionException;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class Server {

    Server() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setAddress("http://0.0.0.0:9000");
        sf.setResourceClasses(CustomerService.class);
        sf.setResourceProvider(CustomerService.class,
                new SingletonResourceProvider(new CustomerService()));
        sf.setProvider(new JacksonJsonProvider());

        try {
            sf.create();
        } catch (ServiceConstructionException e) {
            System.err.println("\n" + "░█▀▀ ░█▀█ ░█ ░█▀▀ ░░█▀▀ ░█▀█ ░█ ░█\n"
                    + "░█▀▀ ░█▀▀ ░█ ░█ ░░░░█▀▀ ░█▀█ ░█ ░█\n"
                    + "░▀▀▀ ░▀ ░░░▀ ░▀▀▀ ░░▀ ░░░▀░▀ ░▀ ░▀▀▀");
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Server ready...");
    }

    public static void main(String args[]) throws Exception {
        new Server();

        Thread.sleep(60 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(2);
    }
}