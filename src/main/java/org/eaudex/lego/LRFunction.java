package org.eaudex.lego;


class LRFunction implements Function {

    private final int n;
    private final int l;
    private final Dataset dataset;

    public LRFunction(Dataset dataset) {
        int n = Integer.MIN_VALUE;
        for (Point pt : dataset) {
            // validate dimensionality
            if (n == Integer.MIN_VALUE)
                n = pt.length();
            assert n == pt.length();
            // validate label
            double lab = ((LabelPoint) pt).label();
            assert lab == -1.0 || lab == 1.0;
        }
        this.n = n;
        this.l = dataset.size();
        this.dataset = dataset;
    }

    /**
     * obj =: \sum_i log(1 + exp(-yi w'xi))
     */
    @Override
    public double getValue(Model m) {
        double objval = 0.0;
        for (Point pt : dataset) {
            double lab = ((LabelPoint) pt).label();
            assert lab == -1.0 || lab == 1.0;
            double decval = m.eval(pt);
            objval += Math.log(1.0 + Math.exp(-1.0*lab*decval));
        }
        return objval;
    }

    /**
     * grad_j =: \sum_i -yi * xi_j / (1 + exp(yi w'xi))
     */
    @Override
    public Model getGradient(Model m) {
        int n = ((LinearModel) m).length();
        double[] grad = new double[n];

        for (Point pt : dataset) {
            double lab = ((LabelPoint) pt).label();
            assert lab == -1.0 || lab == 1.0;
            double decval = m.eval(pt);
            double factor = lab / (1.0 + Math.exp(lab*decval));
            for (IndexValue indval : pt) {
                int ind = indval.index();
                double val = indval.value();
                if (ind < n)
                    grad[ind] -= val*factor;
                else
                    break;
            }
        }

        return new LinearModel(grad);
    }

    @Override
    public Model getMiniBatchGradient(Model m, int k) {
        return null;
    }

    @Override
    public Model getStochasticGradient(Model m) {
        return null;
    }

}
