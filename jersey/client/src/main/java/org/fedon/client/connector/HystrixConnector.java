package org.fedon.client.connector;

import java.net.URI;
import java.util.concurrent.Future;

import javax.ws.rs.core.UriBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.client.ClientRequest;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.client.HttpUrlConnector;
import org.glassfish.jersey.client.spi.AsyncConnectorCallback;

/**
 * @author Dmytro Fedonin
 *
 */
public class HystrixConnector extends HttpUrlConnector {
    private final Log log = LogFactory.getLog(this.getClass());
    public static final String dynamicURIPartTemplate = "eureka";

    public HystrixConnector() {
        super();
    }

    /**
     * @param connectionFactory
     */
    public HystrixConnector(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public ClientResponse apply(final ClientRequest request) {
        log.debug("Invoke Histrix command -- " + request.getUri());
        request.setUri(eurekaUri(request.getUri()));
        log.debug("discover -- " + request.getUri());

                return _apply(request);
    }

    ClientResponse _apply(ClientRequest request) {
        log.info("Inside Histrix command...");
        return super.apply(request);
    }

    @Override
    public Future<?> apply(final ClientRequest request, final AsyncConnectorCallback callback) {
        log.debug("Invoke async Histrix command -- " + request.getUri());

                return _apply(request, callback);
    }

    Future<?> _apply(ClientRequest request, AsyncConnectorCallback callback) {
        log.info("Inside async Histrix command...");
        return super.apply(request, callback);
    }

    protected URI eurekaUri(URI uri) {
        String str = uri.toString();
        String replacement = str.replaceFirst(dynamicURIPartTemplate, "replacement");
        return UriBuilder.fromUri(replacement).build();
    }
}
