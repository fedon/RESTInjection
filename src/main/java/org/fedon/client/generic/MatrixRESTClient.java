package org.fedon.client.generic;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.fedon.matrix.model.Matrix;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author Dmytro Fedonin
 *
 */
public class MatrixRESTClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Matrix a = new Matrix();
        a.set(1, 0, 1);
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(getBaseURI());
        System.out.println("a: " + a);
        System.out.println(service.path("math").path("trans").accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, a)
                .getEntity(Matrix.class));
        Matrix b = new Matrix();
        b.set(0, 1, 3);
        Matrix[] arr = new Matrix[2];
        arr[0] = a;
        arr[1] = b;
        System.out.println(service.path("math").path("mult").accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, arr)
                .getEntity(Matrix.class));
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/matrixREST").build();
    }
}
