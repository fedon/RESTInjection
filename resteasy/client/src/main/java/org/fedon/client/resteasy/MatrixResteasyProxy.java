package org.fedon.client.resteasy;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.fedon.matrix.model.Matrix;
import org.fedon.matrix.rest.MatrixIf;
import org.jboss.resteasy.client.spring.RestClientProxyFactoryBean;

/**
 * @author Dmytro Fedonin
 *
 */
public class MatrixResteasyProxy {

    static String base = "http://localhost:8080/matrixREST-resteasy/easy-matrix";
    static String jersey = "http://localhost:8080/matrixREST-jersey/jersey";

    public static void main(String[] args) throws Exception {
        String url = base;
        if (args.length > 0) {
            url = jersey;
        }
        System.out.println("Working with URL: " + url);
        MatrixIf client = createClient(url);

        Matrix a = new Matrix();
        a.set(1, 0, 1);
        System.out.println("a: " + a);
        Matrix result = client.trans(a);
        System.out.println("trans <a> = " + result);

        Matrix b = new Matrix();
        b.set(0, 1, 3);
        System.out.println("b: " + b);
        result = client.mult(b, a, Matrix.instancE());

        System.out.println("b * a * E = " + result);
        System.out.println("E = " + client.single());

        result = client.mult(Matrix.instancE());
    }

    private static MatrixIf createClient(String url) throws Exception {
        RestClientProxyFactoryBean<MatrixIf> factory = new RestClientProxyFactoryBean<MatrixIf>();
        factory.setServiceInterface(MatrixIf.class);
        factory.setBaseUri(getBaseURI(url));
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    private static URI getBaseURI(String url) {
        return UriBuilder.fromUri(url).build();
    }
}
