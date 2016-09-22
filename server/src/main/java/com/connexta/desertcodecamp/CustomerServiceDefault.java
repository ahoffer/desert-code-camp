package com.connexta.desertcodecamp;

import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;

@Api("/customerservice")
public class CustomerServiceDefault implements CustomerService {

    public String hello() {

        return "Hello World!";
    }

    public Response putCustomer(Customer customer) {
        System.out.println("----invoking putCustomer, Customer name is: " + customer.getName());
        Customer updatedCustomer = Database.putCustomer(customer);
        Response response;
        if (updatedCustomer != null) {
            response = Response.ok()
                    .build();
        } else {
            response = Response.notModified()
                    .build();
        }

        return response;
    }

    public Customer getCustomer(String id) {
        System.out.println("----invoking getCustomer, Customer id is: " + id);

        return Database.getCustomer(id);

        //TODO: Return 404 if ID is not in the database
        //        Customer customer = Database.getCustomer(id);
        //        if (customer == null) {
        //            throw new NotFoundException("Cannot find customer id " + id);
        //        }
        //
        //        return customer;

    }

    public Response postCustomer(Customer customer) {
        System.out.println("----invoking postCustomer, Customer name is: " + customer.getName());
        return Response.ok(Database.post(customer))
                .build();
    }
}