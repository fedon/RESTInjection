package org.fedon.client.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.fedon.matrix.model.Matrix;
import org.fedon.matrix.rest.MatrixIf;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

/**
 * @author Dmytro Fedonin
 *
 */
public class MatrixJerseyProxy { // it is not functional due to (bad) ClientBuilder implementation -> see ResteasyProxy

    static String base = "http://localhost:8080/matrixREST/easy-matrix";

    public static void main(String[] args) throws Exception {
        Client resource = ClientBuilder.newClient();
        MatrixIf client = WebResourceFactory.newResource(MatrixIf.class, resource.target(base));
        Matrix a = new Matrix();
        a.set(1, 0, 1);
        System.out.println("a: " + a);
        Matrix result = client.trans(a);
        System.out.println("trans <a> = " + result);
    }
}
