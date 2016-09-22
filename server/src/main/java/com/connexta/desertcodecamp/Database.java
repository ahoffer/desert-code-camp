package com.connexta.desertcodecamp;

import java.util.HashMap;
import java.util.Map;

public class Database {


    static Map<String, Customer> customers = new HashMap<>();

    static Map<String, Order> orders = new HashMap<>();

    static Map<String, Product> products = new HashMap<>();

    static Map<Class<?>, Long> idMap = new HashMap<>();

    static {
    }

    public static void restore() {

        customers = new HashMap<>();
        orders = new HashMap<>();
        products = new HashMap<>();
        idMap = new HashMap<>();

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

    public static Customer deleteCustomer(String id) {
        Customer customer = customers.get(id);
        customers.remove(id);
        return customer;
    }

    public static Product getProduct(String id) {
        return products.get(id);
    }

    static String getNextId(Class<?> clazz) {
        Long nextId = idMap.get(clazz);
        nextId += 1;
        idMap.put(clazz, nextId);
        return String.valueOf(nextId);
    }

    public static String post(Customer customer) {
        customer.setId(Database.getNextId(Customer.class));
        customers.put(customer.getId(), customer);
        return customer.getId();

    }

    public static Order getOrder(String id) {
        return orders.get(id);
    }
}

