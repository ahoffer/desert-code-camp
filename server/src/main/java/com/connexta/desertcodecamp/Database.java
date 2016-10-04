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
        c.setName("John Foo");
        c.setId(getNextId(Customer.class));
        customers.put(c.getId(), c);

        Product p = new Product();
        p.setId(getNextId(Product.class));
        p.setDescription("Prince Albert in a tin");
        products.put(p.getId(), p);

        Order o = new Order();
        o.setDescription("Code camp order");
        o.setId(getNextId(Order.class));
        o.setCustomer(c);
        o.setProduct(p);
        orders.put(o.getId(), o);
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
        if (nextId == null) {
            nextId = 0L;
        }
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

