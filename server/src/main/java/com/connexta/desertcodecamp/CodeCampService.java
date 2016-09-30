package com.connexta.desertcodecamp;

import java.util.Map;

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

@Path("/codecamp")
@Service
public interface CodeCampService {

    //region "Hello World" with annotations
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    String hello();
    //endregion

    //region Get customer with annotations
    @GET
    @Path("/customer/{id}/")
    Customer getCustomer(@PathParam("id") String id);
    //endregion

    //region Put, post, delete Customer. Get Order. Get Product.
    @PUT
    @Path("/customer/")
    public Response putCustomer(Customer customer);

    @POST
    @Path("/customer/")
    public Map<String, String> postCustomer(Customer customer);

    @DELETE
    @Path("/customer/{id}/")
    public Response deleteCustomer(@PathParam("id") String id);

    @GET
    @Path("/order/{id}/")
    public Order getOrder(@PathParam("id") String id);

    @GET
    @Path("/product/{id}")
    public Product getProduct(@PathParam("id") String id);

    @GET
    @Path("/hateoas/order/{id}")
    public Response getOrderHateoas(@PathParam("id") String id, @Context UriInfo uriInfo);
    //endregion

}