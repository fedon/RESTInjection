package org.fedon.matrix.config;

import org.fedon.matrix.facade.MatrixManager;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * @author Dmytro Fedonin
 *
 */
public class FacadeBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(MatrixManager.class).to(MatrixManager.class);
    }
}
