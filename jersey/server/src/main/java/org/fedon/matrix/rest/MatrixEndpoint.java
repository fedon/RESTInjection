
package org.fedon.matrix.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fedon.matrix.facade.MatrixManager;
import org.fedon.matrix.model.Matrix;

/**
 * @author Dmytro Fedonin
 */
@Path("/jersey")
public class MatrixEndpoint implements MatrixIf {
    private final Log log = LogFactory.getLog(this.getClass());
    @Inject
    MatrixManager matrixManager;

    public String supportedOps() {
        matrixManager.info();
        return "ops, trans, get1";
    }

    @Override
    public Matrix trans(Matrix matrix) {
        return matrixManager.trans(matrix);
    }

    @Override
    public Matrix single() {
        try {
            Thread.sleep(10000l); // bad resource -- test Hystrix
            log.info("-- after sleeping --");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Matrix.instancE();
    }

    @Override
    public Matrix mult(Matrix... matrixs) {
        return matrixManager.mult(matrixs);
    }
}
