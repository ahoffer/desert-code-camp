# Building REST Services with Apache CXF

## Putting the pieces together

### CXF
 - Framework for service-oriented application
 - Supports multiple protocols (styles?) for a service 
 - Supports multiple transports (HTTP, message queues, CORBA)
 - Standards driven
  - JAX-WS 
  - JAX-RS
  - Lots of OASIS WS-* standards
  - Part of Service Mix 
   - Suite of Apache software to create an enterprise service bus
  
### JAX-RS    
 - JAX-RS Java API for RESTful Web Services
 - JSR-339 specification
 - Implementions include CXF, Jersey, RESTEasy, others
 - Add annotations to create services
    
### Spring Boot
 - Wait, what?
  - Spring Boot seen as CXF "competitor" 
 - CXF needs a web container like Jetty or Tomcat
 - CXF can integrate with an application server
   - WebSphere
   - JBoss
   - Glassfish
   - Spring Boot
   - ... others...
 - This presentation started with Jetty, but it was easier to get SSL/TLS working with Spring Boot
 - "Why didn't you Sprint Boot instead of CXF?"
   - Simple answer: "Our company uses Service Mix, so we did a presentation on CXF."
   - Our customers like standards based development. CXF implements standards.
   - Had early need for new transports like message queues 
 
 ### Other
  - Maven to managage dependencies
  - Maven Sprint Boot pluging to make building and running easy
  - Swagger to create a nice summary of our web service API
  - Free advice: in a world of annotations, pay attention to the logs 
 
 ## About JAX-RS
 - Use annotations to control:
  - When a method is invoked
  - What is passed into the method
  - What method should return
 - JAX-RS Annotation you will see today
   - @Path and @GET, @PUT, @POST, ...
  -  @Consumes, @PathParam
  -  @Produces
 - Annotations you won't see today
   - @QueryParam, @CookieParam, @HeaderParam, @Context
- Install new providers/mappers to serve new MIME types
  - JAXB to convert between Java objects to XML
  - Jackson to convert between Java objects and JSON
  
 ## About REST
  - CRUD methods for resources
  - "Accept" header for alternate representations of a resource 
  - Using status codes
  - HATEOS with link / headers CXF UriBuilder / RFC 6570 - URI Template
  
 ## Things we left out
  - CXF Interceptors (reading and writing), Filters
   - Useful for authentication, authorization steps
  - Streaming input and output
  - Alternate transports like JMS
  - Other "styles" of services like SOAP
  - Integration with Apache Camel for ESB
  - Generating WSDLs for SOAP or WADLs for REST services
  - Using CXF as a client instead of a server
  
