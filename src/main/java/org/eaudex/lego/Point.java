package org.eaudex.lego;

import java.util.Iterator;
import java.util.Map.Entry;



class Point implements Iterable<IndexValue> {

    protected final int n;
    protected final int[] indices;
    protected final double[] values;

    public Point(int n, int[] inds, double[] vals) {
        assert n > 0;
        assert inds.length == vals.length;
        this.n = n;
        indices = inds;
        values = vals;
        // validate feature dimensions
        for (Integer i : inds)
            assert i < n;
    }

    public int length() {
        return n;
    }

    @Override
    public Iterator<IndexValue> iterator() {
        return new IndexValueIterator(indices, values);
    }

}
