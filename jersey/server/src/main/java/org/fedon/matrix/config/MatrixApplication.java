package org.fedon.matrix.config;

import org.fedon.matrix.rest.MatrixEndpoint;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Dmytro Fedonin
 *
 */
public class MatrixApplication extends ResourceConfig {
    public MatrixApplication() {
        register(new FacadeBinder());
        // register(JettisonFeature.class);
        // register(MoxyJsonFeature.class);
        register(JacksonFeature.class);
        register(MatrixEndpoint.class);
    }
}
