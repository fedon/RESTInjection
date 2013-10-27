
package org.fedon.matrix.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.fedon.matrix.facade.MatrixManager;
import org.fedon.matrix.model.Matrix;

/**
 * @author Dmytro Fedonin
 */
@Path("/jersey")
public class MatrixEndpoint implements MatrixIf {
    // @Autowired
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
        return Matrix.instancE();
    }

    @Override
    public Matrix mult(Matrix... matrixs) {
        return matrixManager.mult(matrixs);
    }
}
