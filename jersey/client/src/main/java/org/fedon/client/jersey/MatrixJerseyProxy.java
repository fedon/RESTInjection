package org.fedon.client.jersey;

import java.util.concurrent.Future;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fedon.client.connector.AgoraConnector;
import org.fedon.matrix.rest.MatrixIf;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

/**
 * @author Dmytro Fedonin
 * 
 */
public class MatrixJerseyProxy {
    private final static Log log = LogFactory.getLog(MatrixJerseyProxy.class);
    static String base = "http://localhost:8080/matrixREST-jersey/jersey";

    public static void main(String[] args) throws Exception {
        ClientConfig cc = new ClientConfig().connector(new AgoraConnector());
        // ClientConfig cc = new ClientConfig().register(JacksonFeature.class);
        Client resource = ClientBuilder.newClient(cc);
        MatrixIf client = WebResourceFactory.newResource(MatrixIf.class, resource.target(AgoraConnector.dynamicURIPartTemplate));
        // MatrixIf client = WebResourceFactory.newResource(MatrixIf.class, resource.target(base));

        String str = null;

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

        // try {
        // log.info("-------------- call timeout -------------- ");
        // result = client.single();
        // } catch (Exception e) {
        // log.warn("timeout: " + e);
        // }

        try {
            log.info("-------------- call bad -------------- ");
            str = client.badMethod(true);
        } catch (Exception e) {
            log.warn("bad: " + e);
        }
        log.info(str);

        AsyncInvoker ai = resource.target(base).request().async();
        Future<Response> responseFuture = ai.get();
        log.info(responseFuture);
    }
}
