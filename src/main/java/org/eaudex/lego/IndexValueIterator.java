package org.eaudex.lego;

import java.util.Iterator;


class IndexValueIterator implements Iterator<IndexValue> {

    private final int length;
    private final int[] indices;
    private final double[] values;
    private int curr;

    public IndexValueIterator(int[] inds, double[] vals) {
        assert inds.length == vals.length;
        length = inds.length;
        indices = inds;
        values = vals;
        curr = 0;
    }

    @Override
    public boolean hasNext() {
        return curr < length;
    }

    @Override
    public IndexValue next() {
        int ind = indices[curr];
        double val = values[curr];
        curr += 1;
        return new IndexValue(ind,val);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported!!");
    }

}

