package org.eaudex.lego;



class LinearModel implements Model {

    private final double[] weights;

    public LinearModel(int n) {
        assert n > 0;
        weights = new double[n];
    }

    public LinearModel(double[] w) {
        int n = w.length;
        assert n > 0;
        weights = new double[n];
        for (int i=0; i<n; ++i) {
            weights[i] = w[i];
        }
    }

    public int length() {
        return weights.length;
    }

    @Override
    public double eval(Point pt) {
        double s = 0.0;
        for (IndexValue indval : pt) {
            int ind = indval.index();
            double val = indval.value();
            if (ind < weights.length)
                s += val*weights[ind];
            else
                break;
        }
        return s;
    }

    /*
    public double getWeight(int idx) {
        assert 0 <= idx && idx < weights.length;
        return weights[idx];
    }

    public void setWeight(int idx, double val) {
        assert 0 <= idx && idx < weights.length;
        weights[idx] = val;
    }
    */

}

