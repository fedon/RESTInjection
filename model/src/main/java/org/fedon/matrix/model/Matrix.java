package org.fedon.matrix.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Dmytro Fedonin
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Matrix {
    static Matrix e;
    int[][] value = new int[3][3];

    public void set(int x, int y, int val) {
        value[y][x] = val;
    }

    public int get(int x, int y) {
        return value[y][x];
    }

    public static Matrix instancE() {
        if (e == null) {
            e = new Matrix();
            e.set(0, 0, 1);
            e.set(1, 1, 1);
            e.set(2, 2, 1);
        }
        return e;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(value);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matrix other = (Matrix) obj;
        if (!Arrays.equals(value[0], other.value[0]) || !Arrays.equals(value[1], other.value[1]) || !Arrays.equals(value[2], other.value[2]))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Matrix [value=\n" + Arrays.toString(value[0]) + "\n" + Arrays.toString(value[1]) + "\n" + Arrays.toString(value[2]) + "\n]";
    }
}
