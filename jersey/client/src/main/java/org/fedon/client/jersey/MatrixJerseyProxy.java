package org.fedon.client.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fedon.matrix.rest.MatrixIf;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * @author Dmytro Fedonin
 * 
 */
public class MatrixJerseyProxy {
    private final static Log log = LogFactory.getLog(MatrixJerseyProxy.class);
    static String base = "http://localhost:8080/matrixREST-jersey/jersey";

    public static void main(String[] args) throws Exception {
        // ClientConfig cc = new ClientConfig().register(JettisonFeature.class).connector(new AgoraConnector());
        ClientConfig cc = new ClientConfig().register(JacksonFeature.class);
        Client resource = ClientBuilder.newClient(cc);
        // MatrixIf client = WebResourceFactory.newResource(MatrixIf.class, resource.target(AgoraConnector.dynamicURIPartTemplate));
        MatrixIf client = WebResourceFactory.newResource(MatrixIf.class, resource.target(base));

        log.info("-------------- call bad method -------------- ");

        String str = client.badMethod(true);
        log.info(str);

        // Matrix result;
        // Matrix a = new Matrix();
        // a.set(1, 0, 1);
        // log.info("a: " + a);
        //
        // result = client.trans(a);
        // log.info("trans <a> = " + result);
        //
        // Matrix b = new Matrix();
        // b.set(0, 1, 3);
        // log.info("b: " + b);
        //
        // result = client.mult(b, a, Matrix.instancE());
        // log.info("b * a * E = " + result);
        //
        // try {
        // log.info("-------------- call timeout -------------- ");
        // result = client.single();
        // } catch (Exception e) {
        // log.warn("timeout: " + e);
        // }
        //
        // try {
        // log.info("-------------- call bad -------------- ");
        // result = client.mult(Matrix.instancE());
        // } catch (Exception e) {
        // log.warn("bad: " + e);
        // }
    }
}
