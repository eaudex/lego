package org.eaudex.lego;


class IndexValue {

    protected final int index;
    protected final double value;

    public IndexValue(int ind, double val) {
        assert ind >= 0;
        index = ind;
        value = val;
    }

    public int index() {
        return index;
    }

    public double value() {
        return value;
    }

}

