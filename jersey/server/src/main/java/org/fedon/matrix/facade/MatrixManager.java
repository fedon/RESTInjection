package org.fedon.matrix.facade;

import java.util.Arrays;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ResourceInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fedon.matrix.model.Matrix;

/**
 * @author Dmytro Fedonin
 *
 */
@Resource
@ManagedBean
public class MatrixManager {
    private final Log log = LogFactory.getLog(this.getClass());
    @Inject
    ResourceInfo rInfo;

    public Matrix mult(Matrix... matrixs) {
        if (matrixs.length < 2) {
            String error = "At least two instance of Matrix should be provided";
            log.error(error);
            throw new WebApplicationException(new IllegalArgumentException(error), HttpServletResponse.SC_BAD_REQUEST);
        }
        for (int i = 0; i < matrixs.length; i++) {
            log.info("matrix[" + i + "] for mult: " + matrixs[i]);
        }
        Matrix result = matrixs[0];
        for (int i = 1; i < matrixs.length; i++) {
            result = mult(result, matrixs[i]);
        }
        return result;
    }

    protected Matrix mult(Matrix left, Matrix right) {
        Matrix result = new Matrix();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int val = 0;
                for (int i = 0; i < 3; i++) {
                    val += left.get(i, y) * right.get(x, i);
                }
                result.set(x, y, val);
            }
        }
        return result;
    }

    public void info() {
        log.info("Resource: " + rInfo.getResourceClass().getName());
        log.info("Annotations: " + Arrays.toString(rInfo.getResourceMethod().getAnnotations()));
    }

    public Matrix trans(Matrix matrix) {
        log.debug("input: " + matrix);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (x < y) {
                    int swap = matrix.get(x, y);
                    matrix.set(x, y, matrix.get(y, x));
                    matrix.set(y, x, swap);
                }
            }
        }
        log.info("output: " + matrix);
        return matrix;
    }
}
