package org.fedon.matrix.rest;

import javax.ws.rs.Path;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fedon.matrix.facade.MatrixManager;
import org.fedon.matrix.model.Matrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dmytro Fedonin
 *
 */
@Component
@Path("/easy-matrix")
public class EasyMatrixEndpoint implements MatrixIf {
    private final Log log = LogFactory.getLog(this.getClass());
    @Autowired
    MatrixManager matrixManager;

    @Override
    public Matrix mult(Matrix... matrixs) {
        return matrixManager.mult(matrixs);
    }

    @Override
    public Matrix trans(Matrix matrix) {
        log.info("input --- " + matrix);
        log.info("manager --- " + matrixManager);
        return matrixManager.trans(matrix);
    }

    @Override
    public String supportedOps() {
        log.info("---");
        matrixManager.info();
        return "ops, trans, get1, mult";
    }

    @Override
    public Matrix single() {
        return Matrix.instancE();
    }

}
