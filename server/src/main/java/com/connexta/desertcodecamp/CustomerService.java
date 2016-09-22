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

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Path("/customerservice")
@Service
public interface CustomerService {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    String hello();

    @GET
    @Path("/customer/{id}/")
    Customer getCustomer(@PathParam("id") String id);

    @PUT
    @Path("/customer/")
    public Response putCustomer(Customer customer);

    @POST
    @Path("/customer/")
    public Response postCustomer(Customer customer);

    //    @DELETE
    //    @Path("/customer/{id}/")
    //    public Response deleteCustomer(@PathParam("id") String id) {
    //        System.out.println("----invoking deleteCustomer, Customer id is: " + id);
    //        long idNumber = Long.parseLong(id);
    //        Customer c = customers.get(idNumber);
    //
    //        Response r;
    //        if (c != null) {
    //            r = Response.ok()
    //                    .build();
    //            customers.remove(idNumber);
    //        } else {
    //            r = Response.notModified()
    //                    .build();
    //        }
    //
    //        return r;
    //    }
    //
    //    @Path("/order/{orderId}/")
    //    public Order getOrder(@PathParam("orderId") String orderId) {
    //        System.out.println("----invoking getOrder, Order id is: " + orderId);
    //        long idNumber = Long.parseLong(orderId);
    //        Order c = orders.get(idNumber);
    //        return c;
    //    }
    //

}