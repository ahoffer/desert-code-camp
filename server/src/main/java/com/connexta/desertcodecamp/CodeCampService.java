package com.connexta.desertcodecamp;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    String hello();

    /**
     * Method declarations for GET, PUT, POST, DELETE for the Customer resource
     * GET method declaration for Order and Product resources.
     *
     * These methods are the basic RESTful operations
     */

    /**
     * The HTTP verb GET
     */
    @GET

    /**
     *
     * "/customer/{id}/" is an example of a URI template, a path with a parameter.
     * JAX-RS supports several types of parameters:
     *
     *  @QueryParam Extracts the value of a URI query parameter.
     *  @PathParam Extracts the value of a URI template parameter.
     *  @CookieParam Extracts the value of a cookie.
     *  @HeaderParam Extracts the value of a header.
     *
     * The @PathParam injects the value of the ID into the getCustomer method.
     * For example, http://localhost/codecamp/customer/9944 would pass the string "9944"
     * into the method getCustomer("9944").
     *
     * A JAX-RS implementation like CXF will convert simple types like int, float, double and String
     * and some collections like lists and sets.
     *
     */

    @Path("/customer/{id}/")
    Customer getCustomer(@PathParam("id") String id);

    /**
     * PUT will replace and existing resource with a new value.
     * Does not use a template PATH because the customer ID is part of the customer object.
     * -
     * The parameter, customer is created from the body of the HTTP request. This is an example
     * of serializing a complex object, the Customer from an XML or JSON string.
     * -
     * CXF uses JAXB to serialize more complicated object to XML. This can be enabled by adding
     * an annotation. See Customer.java for an example.
     *
     * @XmlRootElement(name = "Customer")
     * -
     * Also, the service does not return an object like a String or a Customer. It returns a
     * Response. The Response class is a part of JAX-RS. It allows for more fiddling.
     */
    @PUT
    @Path("/customer/")
    Response putCustomer(Customer customer);

    /**
     * POST is used to create a new (Customer) resource.
     * It does not
     */

    @POST
    @Path("/customer/")
    Response postCustomer(Customer customer, @Context UriInfo uriInfo);

    @DELETE
    @Path("/customer/{id}/")
    Response deleteCustomer(@PathParam("id") String id);

    @GET
    @Path("/order/{id}/")
    Order getOrder(@PathParam("id") String id);

    @GET
    @Path("/product/{id}")
    Product getProduct(@PathParam("id") String id);

    @GET
    @Path("/hateoas/order/{id}")
    public Response getOrderWithLinkHeaders(@PathParam("id") String id, @Context UriInfo uriInfo);

}