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

    static String base = "http://localhost:8080/matrixREST/easy-matrix";

    public static void main(String[] args) throws Exception {
        MatrixIf client = createClient();

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
    }

    private static MatrixIf createClient() throws Exception {
        RestClientProxyFactoryBean<MatrixIf> factory = new RestClientProxyFactoryBean<MatrixIf>();
        factory.setServiceInterface(MatrixIf.class);
        factory.setBaseUri(getBaseURI());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri(base).build();
    }
}
