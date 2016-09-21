package com.connexta.desertcodecamp;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;

@Api("/customerservice")
public class CustomerServiceDefault implements CustomerService {

    long currentId = 123;

    Map<Long, Customer> customers = new HashMap<>();

    Map<Long, Order> orders = new HashMap<>();

    public CustomerServiceDefault() {
        Customer c = new Customer();
        c.setName("John");
        c.setId(123);
        customers.put(c.getId(), c);

        Order o = new Order();
        o.setDescription("order 223");
        o.setId(223);
        orders.put(o.getId(), o);
    }

    public String hello() {
        return "Hello World!";
    }

    public Customer getCustomer(String id) {
        System.out.println("----invoking getCustomer, Customer id is: " + id);
        long idNumber = Long.parseLong(id);
        Customer c = customers.get(idNumber);
        return c;
    }
}
