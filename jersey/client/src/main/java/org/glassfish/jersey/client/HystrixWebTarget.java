package org.glassfish.jersey.client;

import javax.ws.rs.core.UriBuilder;

import com.google.common.base.Preconditions;

/**
 * Brute force Hystrix integration enter point.
 * 
 * @author Dmytro Fedonin
 * 
 */
public class HystrixWebTarget extends JerseyWebTarget {

    /**
     * @param uriBuilder
     * @param clientConfig
     */
    public HystrixWebTarget(UriBuilder uriBuilder, ClientConfig clientConfig) {
        super(uriBuilder, clientConfig);
    }

    @Override
    public HystrixBuilder request(String... acceptedResponseTypes) {
        getConfiguration().getClient().checkNotClosed();
        HystrixBuilder result = new HystrixBuilder(getUri(), getConfiguration().snapshot());
        result.request().accept(acceptedResponseTypes);
        return result;
    }

    @Override
    public JerseyWebTarget path(String path) throws NullPointerException {
        getConfiguration().getClient().checkNotClosed();
        Preconditions.checkNotNull(path, "path is 'null'.");

        return new HystrixWebTarget(getUriBuilder().path(path), getConfiguration().snapshot());
    }
}
