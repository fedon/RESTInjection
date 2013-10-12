package org.fedon.matrix.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.fedon.matrix.model.Matrix;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;

/**
 * @author Dmytro Fedonin
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MatrixManagerTest {
    @Mock
    ApplicationContext appc;
    @InjectMocks
    MatrixManager mng;

    @Test
    public void testMult() {
        // MatrixManager mng = new MatrixManager();
        Matrix a = new Matrix();
        a.set(1, 0, 1);
        Matrix b = new Matrix();
        b.set(0, 1, 3);
        when(appc.getDisplayName()).thenReturn("mock");

        Matrix result = mng.mult(b, Matrix.instancE());
        assertNotNull(result);
        assertEquals(b, result);
        System.out.println("---");

        result = mng.mult(a, b, Matrix.instancE());
        assertNotNull(result);
        System.out.println("result: " + result);

        result = mng.mult(b, a);
        assertNotNull(result);
        System.out.println("result: " + result);

        Matrix[] ba = new Matrix[2];
        ba[0] = b;
        ba[1] = a;
        result = mng.mult(ba);
        assertNotNull(result);
        System.out.println("ba: " + result);
    }
}
