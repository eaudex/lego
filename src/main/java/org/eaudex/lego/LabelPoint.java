package org.eaudex.lego;


class LabelPoint extends Point {

    protected final double label;

    public LabelPoint(double lab, int n, int[] inds, double[] vals) {
        super(n, inds, vals);
        label = lab;
    }

    public double label() {
        return label;
    }

}

