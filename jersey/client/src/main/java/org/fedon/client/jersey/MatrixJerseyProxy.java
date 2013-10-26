package org.fedon.client.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.fedon.matrix.model.Matrix;
import org.fedon.matrix.rest.MatrixIf;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

/**
 * @author Dmytro Fedonin
 *
 */
public class MatrixJerseyProxy { // it is not functional due to (bad) ClientBuilder implementation -> see ResteasyProxy

    static String base = "http://localhost:8080/matrixREST/jersey";

    public static void main(String[] args) throws Exception {
        ClientConfig cc = new ClientConfig().register(JacksonJaxbJsonProvider.class);
        // cc..put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client resource = ClientBuilder.newClient(cc);
        MatrixIf client = WebResourceFactory.newResource(MatrixIf.class, resource.target(base));

        Matrix result = client.single();
        System.out.println("E = " + result);

        Matrix a = new Matrix();
        a.set(1, 0, 1);
        System.out.println("a: " + a);
        result = client.trans(a);
        System.out.println("trans <a> = " + result);
    }
}
