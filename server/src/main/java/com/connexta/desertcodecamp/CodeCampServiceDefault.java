package com.connexta.desertcodecamp;

import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;

@Api("/codecamp")
public class CodeCampServiceDefault implements CodeCampService {

    // Create test data
    public CodeCampServiceDefault() {
        Database.restore();
    }

    //region implement a "Hellow World" service to test the plumbing
    public String hello() {

        return "Hello World!";
    }
    //endregion

    //region Implement get customer
    public Customer getCustomer(String id) {
        System.out.println("----invoking getCustomer, Customer id is: " + id);
        return Database.getCustomer(id);
        //region Throw resource not found exception if ID is not in the database
            /*
            Customer customer = Database.getCustomer(id);
                if (customer == null) {
                    throw new NotFoundException("Cannot find customer id " + id);
                }

                return customer;
            */
        //endregion

    }
    //endregion

    //region Implement post customer
    public Response postCustomer(Customer customer) {
        System.out.println("----invoking postCustomer, Customer name is: " + customer.getName());

        //Return the customer ID. Assume database process to create new customer is asynchronous.
        return Response.ok(Database.post(customer))
                .build();
    }
    //endregion

    //region Implement put customer
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
    //endregion

    //region Implement delete customer
    public Response deleteCustomer(String id) {
        System.out.println("----invoking deleteCustomer, Customer id is: " + id);
        Customer customer = Database.deleteCustomer(id);
        Response.ResponseBuilder responseBuilder =
                (customer != null) ? Response.ok() : Response.status(Response.Status.NOT_FOUND);
        return responseBuilder.build();
    }
    //endregion

    //region Implement get Order and Product
    public Order getOrder(String id) {
        return Database.getOrder(id);
    }

    public Product getProduct(String id) {
        return Database.getProduct(id);
    }
    //endregion
}