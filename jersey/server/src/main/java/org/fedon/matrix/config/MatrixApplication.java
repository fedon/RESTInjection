package org.fedon.matrix.config;

import org.glassfish.jersey.jettison.JettisonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Dmytro Fedonin
 *
 */
public class MatrixApplication extends ResourceConfig {
    public MatrixApplication() {
        register(new FacadeBinder());
        register(JettisonFeature.class);
        packages("org.fedon.matrix.rest");
    }
}
