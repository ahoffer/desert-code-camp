package com.connexta.desertcodecamp;

import java.net.URI;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

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

    //region Implement get Customer
    public Customer getCustomer(String id) {
        System.out.println("----invoking getCustomer, Customer id is: " + id);
        return Database.getCustomer(id);
        // Throw "resource not found exception" if ID is not in the database
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

    //region Implement post Customer
    public Response postCustomer(Customer customer, UriInfo uriInfo) {
        System.out.println("----invoking postCustomer, Customer name is: " + customer.getName());

        //Return the customer ID. Assume database process to create new customer is asynchronous.
        String newCustomerId = Database.post(customer);

        /**
         * The UriBuilder class is part of JAX-RS. It helps you build URI paths. It seems kind
         * of clumsy, but maybe there is a better way to use it. In this example, we get the
         * path to the customer resource "customer/", and append the new customer ID.
         *
         * Send back status code 201 to indicate we accepted the POST request.
         * Also pass back the URL of the resource we will create.
         */

        URI customerUri = uriInfo.getAbsolutePathBuilder()
                .path(newCustomerId)
                .build();
        return Response.created(customerUri)
                .build();

    }
    //endregion

    //region Implement put Customer
    public Response putCustomer(Customer customer) {
        System.out.println("----invoking putCustomer, Customer name is: " + customer.getName());
        Customer updatedCustomer = Database.putCustomer(customer);
        return Response.ok()
                .build();
    }
    //endregion

    //region Implement delete Customer
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

    @Override
    public Product getProduct(String id) {
        return Database.getProduct(id);
    }
    //endregion

    //region Implement Link Headers

    /**
     * HATEOAS with Link Headers. See RFC 5988.
     * Include links to the order's product and customer, as well as an example a link to a
     * fictitious "cancel" action
     */

    @Override
    public Response getOrderWithLinkHeaders(String id, UriInfo uriInfo) {
        Order order = Database.getOrder(id);

        /**
         *
         * The UriBuilder class from JAX-RS again.
         * The getBaseUriBuilder() returns a builder built on "http://localhost:8080/".
         *
         */
        UriBuilder builder = uriInfo.getBaseUriBuilder();

        //
        /**
         * Create customer link. Clone the UriBuilder so it can be used again.
         * Then add the resource path, "/customer" using the UriBuilder's path() method.
         * Finally, call build and pass it the ID of the Customer.
         */
        URI customerUri = builder.clone()
                .path(CodeCampService.class, "getCustomer")
                .build(order.getCustomer()
                        .getId());

        // Create product link
        URI productUri = builder.clone()
                .path(CodeCampService.class, "getProduct")
                .build(order.getProduct()
                        .getId());

        /**
         * Create a Header Link to a fictitious to cancel action.
         * The "rel" attribute is intended to provide meaning to the link.
         */
        Link cancelLink = Link.fromUri(uriInfo.getAbsolutePathBuilder()
                .path("cancel")
                .build())
                .rel("cancel")
                .build();

        /**
         * Add the Customer and Product URIs to the response headers.
         * Add the cancel action Link to the response headers. The string in the second
         * parameter becomes the "rel" for the link.
         */
        return Response.ok(order)
                .link(productUri, "product")
                .link(customerUri, "customer")
                .links(cancelLink)
                .build();
    }

    //endregion
}