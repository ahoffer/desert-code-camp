package com.connexta.desertcodecamp.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public final class Client {

    private Client() {
    }

    public static void main(String args[]) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:9000/customerservice/customers/123");
        httpGet.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML);
//        httpGet.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            System.out.println(EntityUtils.toString(entity1));
            EntityUtils.consume(entity1);
        }

/*
   // Sent HTTP GET request to query customer info
        System.out.println("Sent HTTP GET request to query customer info");
        URL url = new URL("http://localhost:9000/customerservice/customers/123");
        InputStream in = url.openStream();
        System.out.println(getStringFromInputStream(in));

        // Sent HTTP GET request to query sub resource product info
        System.out.println("\n");
        System.out.println("Sent HTTP GET request to query sub resource product info");
        url = new URL("http://localhost:9000/customerservice/orders/223/products/323");
        in = url.openStream();
        System.out.println(getStringFromInputStream(in));

*/

        // Sent HTTP PUT request to update customer info
/*
        System.out.println("\n");
        System.out.println("Sent HTTP PUT request to update customer info");
        Client client = new Client();
        String inputFile = client.getClass().getResource("/update_customer.xml").getFile();
        URIResolver resolver = new URIResolver(inputFile);
        File input = new File(resolver.getURI());
        PutMethod put = new PutMethod("http://localhost:9000/customerservice/customers");
        RequestEntity entity = new FileRequestEntity(input, "text/xml; charset=ISO-8859-1");
        put.setRequestEntity(entity);
        HttpClient httpclient = new HttpClient();

        try {
            int result = httpclient.executeMethod(put);
            System.out.println("Response status code: " + result);
            System.out.println("Response body: ");
            System.out.println(put.getResponseBodyAsString());
        } finally {
            // Release current connection to the connection pool once you are
            // done
            put.releaseConnection();
        }

        // Sent HTTP POST request to add customer
        System.out.println("\n");
        System.out.println("Sent HTTP POST request to add customer");
        inputFile = client.getClass().getResource("/add_customer.xml").getFile();
        resolver = new URIResolver(inputFile);
        input = new File(resolver.getURI());
        PostMethod post = new PostMethod("http://localhost:9000/customerservice/customers");
        post.addRequestHeader("Accept", "text/xml");
        entity = new FileRequestEntity(input, "text/xml; charset=ISO-8859-1");
        post.setRequestEntity(entity);
        httpclient = new HttpClient();

        try {
            int result = httpclient.executeMethod(post);
            System.out.println("Response status code: " + result);
            System.out.println("Response body: ");
            System.out.println(post.getResponseBodyAsString());
        } finally {
            // Release current connection to the connection pool once you are
            // done
            post.releaseConnection();
        }

        System.out.println("\n");
        System.exit(0);
    }

    private static String getStringFromInputStream(InputStream in) throws Exception {
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
        return bos.getOut().toString();
    }

*/
    }
}