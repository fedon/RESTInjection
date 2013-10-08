package org.fedon.matrix.facade;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fedon.matrix.model.Matrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dmytro Fedonin
 *
 */
@Service
public class MatrixManager {
    private final Log log = LogFactory.getLog(this.getClass());
    @Autowired
    ServletContext ctx;

    public Matrix mult(Matrix left, Matrix right) {
        // TODO implement
        log.warn("Not yet implemented");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void info() {
        log.info("Server: " + ctx.getServerInfo());
    }

    public Matrix trans(Matrix matrix) {
        log.info(matrix);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (x < y) {
                    int swap = matrix.get(x, y);
                    matrix.set(x, y, matrix.get(y, x));
                    matrix.set(y, x, swap);
                }
            }
        }
        log.info(matrix);
        return matrix;
    }
}
