package org.eaudex.lego;

import org.junit.*;

import static org.junit.Assert.*;



public class PointTest {

    private final int n = 10;
    private final int[] inds = {1, 2, 9};
    private final double[] vals = {1.0, 2.0, 3.0};
    private final Point pt = new Point(n, inds, vals);

    @Test
    public void lengthTest() {
        assertTrue(pt.length() == n);
    }

    @Test
    public void iteratorTest() {
        int k = 0;
        for (IndexValue indval : pt) {
            int ind = indval.index();
            double val = indval.value();
            assertEquals(inds[k], ind);
            assertEquals(vals[k], val, 10);
            k += 1;
        }
    }

}
