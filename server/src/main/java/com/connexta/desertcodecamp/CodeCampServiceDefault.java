package com.connexta.desertcodecamp;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import io.swagger.annotations.Api;

@Api("/codecamp")
public class CodeCampServiceDefault implements CodeCampService {

    // Create test data
    public CodeCampServiceDefault() {
        Database.restore();
    }

    //region implement a "Hellow World" service to test the plumbing
    public String hello() {
        System.out.println("-----invoking Hello World service");
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
    public Map<String, String> postCustomer(Customer customer) {
        System.out.println("----invoking postCustomer, Customer name is: " + customer.getName());

        //Return the customer ID. Assume database process to create new customer is asynchronous.
        String newCustomerId = Database.post(customer);
        Map<String, String> jsonObject = new HashMap();
        jsonObject.put("id", newCustomerId);
        jsonObject.put("resource", "http://blah");

        //TODO: Use a Response.created to send a 201 status code
        return jsonObject;
    }
    //endregion

    //region Implement put customer
    public Response putCustomer(Customer customer) {
        System.out.println("----invoking putCustomer, Customer name is: " + customer.getName());
        Customer updatedCustomer = Database.putCustomer(customer);
        return Response.ok().build();
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

    // SIMPLE IMPLEMENTATION
    //region Implement get Order and Product
    public Order getOrder(String id) {
        return Database.getOrder(id);
    }

    @Override
    public Product getProduct(String id) {
        return Database.getProduct(id);
    }

    // HATEOAS IMPLEMENTATION USING LINK HEADERS. SEE RFC 5988.
    public Response getOrderHateoas(String id, UriInfo uriInfo) {

        Order order = Database.getOrder(id);

        UriBuilder builder = uriInfo.getBaseUriBuilder();
        builder.path(CodeCampService.class);

        // Create customer link
        URI customerUri = builder.clone()
                .path(CodeCampService.class, "getCustomer")
                .build(order.getCustomer()
                        .getId());

        // Create product link
        URI productUri = builder.clone()
                .path(CodeCampService.class, "getProduct")
                .build(order.getProduct()
                        .getId());

        //Create fictitious cancel link
        Link cancelLink = Link.fromUri(uriInfo.getAbsolutePathBuilder()
                .path("cancel")
                .build())
                .rel("cancel")
                .build();

        return Response.ok(order)
                .link(productUri, "product")
                .link(customerUri, "customer")
                .links(cancelLink)
                .build();
    }

    //endregion
}