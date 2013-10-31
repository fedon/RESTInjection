package org.glassfish.jersey.client;

import javax.ws.rs.core.UriBuilder;

import com.google.common.base.Preconditions;

/**
 * @author Dmytro Fedonin
 *
 */
public class AgoraWebTarget extends JerseyWebTarget {

    /**
     * @param uriBuilder
     * @param clientConfig
     */
    public AgoraWebTarget(UriBuilder uriBuilder, ClientConfig clientConfig) {
        super(uriBuilder, clientConfig);
    }

    @Override
    public AgoraBuilder request(String... acceptedResponseTypes) {
        getConfiguration().getClient().checkNotClosed();
        AgoraBuilder result = new AgoraBuilder(getUri(), getConfiguration().snapshot());
        result.request().accept(acceptedResponseTypes);
        return result;
    }

    @Override
    public JerseyWebTarget path(String path) throws NullPointerException {
        getConfiguration().getClient().checkNotClosed();
        Preconditions.checkNotNull(path, "path is 'null'.");

        return new AgoraWebTarget(getUriBuilder().path(path), getConfiguration().snapshot());
    }
}
