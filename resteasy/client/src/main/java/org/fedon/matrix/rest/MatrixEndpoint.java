
package org.fedon.matrix.rest;

import javax.ws.rs.Path;

import org.fedon.matrix.facade.MatrixManager;
import org.fedon.matrix.model.Matrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dmytro Fedonin
 */
@Component
@Path("/math")
public class MatrixEndpoint implements MatrixIf {
    @Autowired
    MatrixManager matrixManager;
    
    // public Matrix mult(Matrix left, Matrix right) {
    // return matrixManager.mult(left, right);
    // }

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
        return matrixManager.mult(matrixs); // TODO make general
    }
}
