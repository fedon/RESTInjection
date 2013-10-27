package org.fedon.client.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.fedon.matrix.model.Matrix;
import org.fedon.matrix.rest.MatrixIf;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.jettison.JettisonFeature;

/**
 * @author Dmytro Fedonin
 *
 */
public class MatrixJerseyProxy {
    static String base = "http://localhost:8080/matrixREST-jersey/jersey";

    public static void main(String[] args) throws Exception {
        ClientConfig cc = new ClientConfig().register(JettisonFeature.class);
        Client resource = ClientBuilder.newClient(cc);
        MatrixIf client = WebResourceFactory.newResource(MatrixIf.class, resource.target(base));

        Matrix result = client.single();
        System.out.println("E = " + result);

        Matrix a = new Matrix();
        a.set(1, 0, 1);
        System.out.println("a: " + a);
        result = client.trans(a);
        System.out.println("trans <a> = " + result);

        Matrix b = new Matrix();
        b.set(0, 1, 3);
        System.out.println("b: " + b);
        result = client.mult(b, a, Matrix.instancE());

        System.out.println("b * a * E = " + result);

        result = client.mult(Matrix.instancE());

    }
}
