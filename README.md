<!-- $theme: default -->

# Building REST Services with Apache CXF  


![Desert Code Camp Logo](logo-desert-code-camp.png)
##### Desert Code Camp 2016

---

# Presenters
###### Aaron Hoffer
###### Travis McMahon

## Connexta
![Connexta Logo](logo-connexta.jpg) 

---

## Things we will demo
- Running REST services
- JAX-RS
- REST CRUD: Get, Post, Put, Delete
- Changing resource representation between XML and JSON
- Autogenerating API documentation 
- Enabling SSL/TLS
- REST HATEOAS using link headers
 
---

## What is CXF?
- Framework for service-oriented applications
- Supports multiple service approaches:
    - SOAP, REST, POX, and other flavors
- Supports multiple transports
     - HTTP, message queues, others
- Standards driven
  - JAX-WS, JAX-RS, lots of OASIS WS* standards

---
  
## CXF  part of Apache Service Mix 
 - Suite of software to create an enterprise service bus
   - Includes ActiveMQ, Camel, CXF, Karaf
 - Other Code Camp 2016.1 presentations:
   - *Building Micro-services with OSGi Apache Karaf* (1:00-2:00)
   - *Using Apache Camel for Enterprise Integration*, (2:15-3:15)

---
  
## What is JAX-RS?   
- Java API for RESTful Web Services
- Add annotations to create services
- It's a standard
  - JSR-339 specification
- Implementations include CXF, Jersey, RESTEasy, others
    
---
 
## About JAX-RS
- Use annotations to control:
   - When a method is invoked
   - What is passed into the method
   - What method should return
- JAX-RS Annotation you will see today
   - @Path (The URL)
   - @GET, @PUT, @POST, (The HTTP verb)
   - @Produces (The MIME type of the response)
   - @PathParam
   - @Context
- There are other JAX-RS annotations as well

---

## More JAX-RS
- Providers
   - Provide (HTTP) message body readers/writers
   - Provide object serialization/deserialization 
   - JAXB to convert between Java objects to XML
   - Jackson to convert between Java objects and JSON
- Other classes
   - Request
   - Response
   - UriInfo
   - UriBuilder
   - Link