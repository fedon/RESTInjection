package org.fedon.matrix.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.WebApplicationException;

import org.fedon.matrix.model.Matrix;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Dmytro Fedonin
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MatrixManagerTest {
    @InjectMocks
    MatrixManager mng;

    @Test
    public void testMult() {
        Matrix a = new Matrix();
        a.set(1, 0, 1);
        Matrix b = new Matrix();
        b.set(0, 1, 3);

        Matrix result = mng.mult(b, Matrix.instancE());
        assertNotNull(result);
        assertEquals(b, result);
        System.out.println("---");

        result = mng.mult(a, b, Matrix.instancE());
        assertNotNull(result);
        System.out.println("result(abE): " + result);

        result = mng.mult(b, a);
        assertNotNull(result);
        System.out.println("result(ba): " + result);

        Matrix[] ba = new Matrix[2];
        ba[0] = b;
        ba[1] = a;
        result = mng.mult(ba);
        assertNotNull(result);
        System.out.println("ba: " + result);
    }

    @Test(expected = WebApplicationException.class)
    public void testMult_Ex() {
        mng.mult(Matrix.instancE());
    }
}
