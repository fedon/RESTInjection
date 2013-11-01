package org.fedon.client.connector;

import java.util.concurrent.Future;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.client.ClientRequest;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.client.HttpUrlConnector;
import org.glassfish.jersey.client.spi.AsyncConnectorCallback;

import com.odesk.agora.hystrix.O2HystrixCommand;

/**
 * @author Dmytro Fedonin
 *
 */
public class AgoraConnector extends HttpUrlConnector {
    private final Log log = LogFactory.getLog(this.getClass());

    public AgoraConnector() {
        super();
    }

    /**
     * @param connectionFactory
     */
    public AgoraConnector(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public ClientResponse apply(final ClientRequest request) {
        log.debug("Invoke Histrix command -- " + request.getUri());

        return new O2HystrixCommand<ClientResponse>("matrix", request.getUri().toString()) {
            @Override
            protected ClientResponse run() throws Exception {
                return _apply(request);
            }
        }.execute();
    }

    ClientResponse _apply(ClientRequest request) {
        log.info("Inside Histrix command...");
        return super.apply(request);
    }

    @Override
    public Future<?> apply(final ClientRequest request, final AsyncConnectorCallback callback) {
        log.debug("Invoke async Histrix command -- " + request.getUri());

        return new O2HystrixCommand<Future<?>>("matrix", request.getUri().toString()) {
            @Override
            protected Future<?> run() throws Exception {
                return _apply(request, callback);
            }
        }.execute();
    }

    Future<?> _apply(ClientRequest request, AsyncConnectorCallback callback) {
        log.info("Inside async Histrix command...");
        return super.apply(request, callback);
    }
}
