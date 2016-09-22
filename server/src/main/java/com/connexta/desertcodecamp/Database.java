package com.connexta.desertcodecamp;

import java.util.HashMap;
import java.util.Map;

public class Database {

    static Map<String, Customer> customers = new HashMap<>();

    static Map<String, Order> orders = new HashMap<>();

    static Map<String, Product> products = new HashMap<>();

    static Map<Class<?>, Long> idMap = new HashMap<>();

    static {

        Customer c = new Customer();
        c.setName("John");
        c.setId("1");
        customers.put(c.getId(), c);

        Order o = new Order();
        o.setDescription("code camp order");
        o.setId("1");
        orders.put(o.getId(), o);

        Product p = new Product();
        p.setId("1");
        p.setDescription("Prince Albert in a tin");
        products.put(p.getId(), p);
    }

    public static Customer putCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        return customer;
    }

    public static Customer getCustomer(String id) {
        return customers.get(id);
    }

    public static Product getProduct(int id) {
        return products.get(id);
    }

    static String getNextId(Class<?> clazz) {
        Long nextId = idMap.get(clazz);
        nextId += 1;
        idMap.put(clazz, nextId);
        return String.valueOf(nextId);
    }

    public static Customer post(Customer customer) {

        customer.setId(Database.getNextId(Customer.class));
        customers.put(customer.getId(), customer);
        return customer;

    }

}

